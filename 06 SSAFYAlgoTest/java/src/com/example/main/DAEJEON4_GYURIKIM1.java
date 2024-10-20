package com.example.main;

import com.example.libraries.Bridge;

import java.util.*;

public class DAEJEON4_GYURIKIM1 {
	private static String NICKNAME = "대전4반_김규리일";
	private static String[][] mapData; // 맵 정보
	private static Map<String, String[]> allies = new HashMap<>(); // 아군 정보
	private static Map<String, String[]> enemies = new HashMap<>(); // 적군 정보
	private static String[] codes; // 암호문 정보
	private static String output;
	private static int[] dx = { 0, 1, -1, 0 };
	private static int[] dy = { -1, 0, 0, 1 };
	private static int normalBomb, tankBomb, numTop;


	public static void main(String[] args) {
		Bridge bridge = new Bridge();
		String gameData = bridge.init(NICKNAME);

		// while 반복문: 배틀싸피 메인 프로그램과 클라이언트(이 코드)가 데이터를 계속해서 주고받는 부분
		while (gameData.length() > 0) {
			// 자기 차례가 되어 받은 게임정보를 파싱
			System.out.printf("----입력데이터----\n%s\n----------------\n", gameData);
			parseData(gameData);

			// 파싱한 데이터를 화면에 출력하여 확인
			System.out.printf("\n[맵 정보] (%d x %d)\n", mapData.length, mapData[0].length);
			for (int i = 0; i < mapData.length; i++) {
				for (int j = 0; j < mapData[i].length; j++) {
					System.out.printf("%s ", mapData[i][j]);
				}
				System.out.println();
			}

			System.out.printf("\n[아군 정보] (아군 수: %d)\n", allies.size());
			for (String key : allies.keySet()) {
				String[] value = allies.get(key);
				if (key.equals("A")) {
					System.out.printf("A (내 탱크) - 체력: %s, 방향: %s, 보유한 일반 포탄: %s개, 보유한 대전차 포탄: %s개\n", value[0],
							value[1], value[2], value[3]);
					normalBomb = Integer.parseInt(value[2]);
					tankBomb = Integer.parseInt(value[3]);
				} else if (key.equals("H")) {
					System.out.printf("H (아군 포탑) - 체력: %s\n", value[0]);
				} else {
					System.out.printf("%s (아군 탱크) - 체력: %s\n", key, value[0]);
				}
			}

			System.out.printf("\n[적군 정보] (적군 수: %d)\n", enemies.size());
			for (String key : enemies.keySet()) {
				String[] value = enemies.get(key);
				if (key.equals("X")) {
					System.out.printf("H (적군 포탑) - 체력: %s\n", value[0]);
				} else {
					System.out.printf("%s (적군 탱크) - 체력: %s\n", key, value[0]);
				}
			}

			System.out.printf("\n[암호문 정보] (암호문 수: %d)\n", codes.length);
			for (int i = 0; i < codes.length; i++) {
				System.out.printf("%s\n", codes[i]);
			}

			// 탱크의 동작을 결정하기 위한 알고리즘을 구현하고 원하는 커맨드를 output 변수에 담기
			// 코드 구현 예시: '아래쪽으로 전진'하되, 아래쪽이 지나갈 수 있는 길이 아니라면 '오른쪽로 전진'하라

			output = "S"; // 알고리즘 결괏값이 없을 경우를 대비하여 초기값을 S로 설정

			int[] myPosition = { -1, -1 };
			for (int i = 0; i < mapData.length; i++) {
				for (int j = 0; j < mapData[i].length; j++) {
					if (mapData[i][j].equals("A")) {
						myPosition[0] = i; // y
						myPosition[1] = j; // x
						break;
					}
				}
				if (myPosition[0] > 0)
					break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = myPosition[1] + dx[d], ny = myPosition[0] + dy[d];
				if (0 <= nx && nx < mapData[0].length && 0 <= ny && ny < mapData.length) {
					if (dx[d] == -1 && dy[d] == 0) {
						output = "L ";
					} else if (dx[d] == 1 && dy[d] == 0) {
						output = "R ";
					} else if (dx[d] == 0 && dy[d] == 1) {
						output = "D ";
					} else if (dx[d] == 0 && dy[d] == -1) {
						output = "U ";
					}

					if (mapData[ny][nx].equals("X") && normalBomb != 0) { // 포탑 일반포탄
						output += "F M";
						break;
					} else if (tankBomb < enemies.size() && mapData[ny][nx].equals("F")) { // 보급시설
						StringBuilder trans = new StringBuilder();
						for (int i = 0; i < codes[0].length(); i++) {
							trans.append((char)('A' + (codes[0].charAt(i) - 'A' + 9)%26));
						}
						output = "G " + trans;
						System.out.println(output);
						break;
					} else if (mapData[ny][nx].contains("E") && tankBomb != 0) { // 대전차 포탄 
						output += "F S";
						break;
//					} else if (mapData[ny][nx].equals("T") && normalBomb > numTop) {
//						output += "F M";
//						break;
					}
				}
			}

			if (!output.contains("F") && !output.contains("G")) {
				getDir(myPosition[1], myPosition[0]);
			}

			// while 문의 끝에는 다음 코드가 필수로 존재하여야 함
			// output에 담긴 값은 submit 함수를 통해 배틀싸피 메인 프로그램에 전달

			System.out.println(output);

			gameData = bridge.submit(output);
		}

		// 반복문을 빠져나왔을 때 배틀싸피 메인 프로그램과의 연결을 완전히 해제하기 위해 close 함수 호출
		bridge.close();
	}

	private static void getDir(int x, int y) {
		boolean[][] visited = new boolean[mapData.length][mapData[0].length];
		Queue<int[]> queue = new LinkedList<>();
		int rx = -2, ry = -2; // 이동할 방향
		queue.offer(new int[] { x, y, rx, ry, 0 });
		visited[y][x] = true;

		done: while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0], cy = cur[1];
			rx = cur[2];
			ry = cur[3];
			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d], ny = cy + dy[d];
				if (0 <= nx && nx < mapData[0].length && 0 <= ny && ny < mapData.length && !visited[ny][nx]) {
					visited[ny][nx] = true;
					if (mapData[ny][nx].equals("G") || mapData[ny][nx].equals("T")) {
						if (cur[4] == 0) {
							rx = dx[d];
							ry = dy[d];
						}
						queue.offer(new int[] { nx, ny, rx, ry, cur[4] + 1 });
					} else if (tankBomb < enemies.size() - 1 && mapData[ny][nx].equals("F")) {
						break done;
					} else if (mapData[ny][nx].equals("X")) {
						break done;
//					} else if (tankBomb >= enemies.size() - 1 && mapData[ny][nx].contains("E")) {
//						break done;
					}
				}
			}

		}

		if (rx == -1 && ry == 0) {
			output = "L A";
		} else if (rx == 1 && ry == 0) {
			output = "R A";
		} else if (rx == 0 && ry == 1) {
			output = "D A";
		} else if (rx == 0 && ry == -1) {
			output = "U A";
		}
	}

	// 입력 데이터를 파싱하여 변수에 저장
	static void parseData(String gameData) {
		// 입력 데이터를 행으로 나누기
		String[] rows = gameData.split("\n");
		int rowIndex = 0;

		// 첫 번째 행 데이터 읽기
		String[] header = rows[rowIndex].split(" ");
		int mapHeight = Integer.parseInt(header[0]); // 맵의 세로 크기
		int mapWidth = Integer.parseInt(header[1]); // 맵의 가로 크기
		int numOfAllies = Integer.parseInt(header[2]); // 아군의 수
		int numOfEnemies = Integer.parseInt(header[3]); // 적군의 수
		int numOfCodes = Integer.parseInt(header[4]); // 암호문의 수
		rowIndex++;

		// 기존의 맵 정보를 초기화하고 다시 읽어오기
		mapData = new String[mapHeight][mapWidth];
		numTop = 0;
		for (int i = 0; i < mapHeight; i++) {
			mapData[i] = rows[rowIndex + i].split(" ");
			for (int j = 0; j < mapWidth; j++) {
				if (mapData[i][j].equals("X")) {
					numTop++;
				}
			}
		}
		rowIndex += mapHeight;

		// 기존의 아군 정보를 초기화하고 다시 읽어오기
		allies.clear();
		for (int i = 0; i < numOfAllies; i++) {
			String[] allyData = rows[rowIndex + i].split(" ");
			String allyName = allyData[0];
			String[] allyInfo = Arrays.copyOfRange(allyData, 1, allyData.length);
			allies.put(allyName, allyInfo);
		}
		rowIndex += numOfAllies;

		// 기존의 적군 정보를 초기화하고 다시 읽어오기
		enemies.clear();
		for (int i = 0; i < numOfEnemies; i++) {
			String[] enemyData = rows[rowIndex + i].split(" ");
			String enemyName = enemyData[0];
			String[] enemyInfo = Arrays.copyOfRange(enemyData, 1, enemyData.length);
			enemies.put(enemyName, enemyInfo);
		}
		rowIndex += numOfEnemies;

		// 기존의 암호문 정보를 초기화하고 다시 읽어오기
		
		codes = new String[numOfCodes];
		for (int i = 0; i < numOfCodes; i++) {
			codes[i] = rows[rowIndex + i];
		}
	}
}