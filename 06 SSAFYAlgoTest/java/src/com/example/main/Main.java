package com.example.main;

import com.example.libraries.Bridge;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
	private static String NICKNAME = "대전_4반_김소운";
	private static String[][] mapData; // 맵 정보
	private static boolean[][] Rvisited; // 맵 정보
	
	private static Map<String, String[]> allies = new HashMap<>(); // 아군 정보
	private static Map<String, String[]> enemies = new HashMap<>(); // 적군 정보
	private static String[] codes; // 암호문 정보

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

			String output = ""; // 알고리즘 결괏값이 없을 경우를 대비하여 초기값을 S로 설정

			int[] myPosition = { -1, -1 };
			for (int i = 0; i < mapData.length; i++) {
				for (int j = 0; j < mapData[i].length; j++) {
					if (mapData[i][j].equals("A")) {
						myPosition[0] = i;
						myPosition[1] = j;
						System.out.println("myPosition = " + i + " + " + j);
						break;
					}
				}
				if (myPosition[0] > 0)
					break;
			}
			int[] enemyPosition = { -1, -1 };
			for (int i = 0; i < mapData.length; i++) {
				for (int j = 0; j < mapData[i].length; j++) {
					if (mapData[i][j].equals("H")) {
						enemyPosition[0] = i;
						enemyPosition[1] = j;
						System.out.println("enemyPosition = " + i + " + " + j);
						break;
					}
				}
				if (enemyPosition[0] > 0)
					break;
			}
// ----- 여기부터 내  코드 작성
			// G이면 가는 bfs 구현하기

			// 사방에 포탑이 있다면 그 방향으로 쏘기
			int N = mapData.length;
			System.out.println("N :" + N);
			for (int d = 0; d < 4; d++) {
				int nr = myPosition[0] + dr[d];
				int nc = myPosition[1] + dc[d];
				if (nr < N && nc < N && nr >= 0 && nc >= 0 && nr == 0 && nc == 15/*mapData[nr][nc].equals("H")*/) {
					System.out.println("포탑 발견!");
					switch (d) {
					case 0:
						output = "U S";
						break;
					case 1:
						output = "D S";
						break;
					case 2:
						output = "L S";
						break;
					case 3:
						output = "R S";
						break;
					}
				}

				// 사방에 포탑 없다면 그쪽으로 가기
//				int[] nextStep = bfs(myPosition[0], myPosition[1]);
				int[] nextStep = bfs(14, 0);
				

				int w = myPosition[0] - nextStep[0];
				int h = myPosition[1] - nextStep[1];

				// 이제 결과 받아서 방향 정해주기
				if (w < 0) {
					output = "U A";
				} else {
					output = "D A";
				}
				if (h < 0) {
					output = "R A";
				} else {
					output = "L A";
				}

// ----- 여기까지가 내 코드

//            if (myPosition[0] < mapData.length - 1 && mapData[myPosition[0] + 1][myPosition[1]].equals("G")) {
//                output = "D A";
//            } else {
//                output = "R A";
//            }

				// while 문의 끝에는 다음 코드가 필수로 존재하여야 함
				// output에 담긴 값은 submit 함수를 통해 배틀싸피 메인 프로그램에 전달
				gameData = bridge.submit(output);
			}

			// 반복문을 빠져나왔을 때 배틀싸피 메인 프로그램과의 연결을 완전히 해제하기 위해 close 함수 호출
			bridge.close();
		}
	}

//	----- 여기부터 내  코드 작성
	// U D L R
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean visited[][];

	private static int[] bfs(int x, int y) {
		int N = mapData.length;
		visited = new boolean[N][N];
		Queue<int[]> qu = new LinkedList<>();

		// (현재 위치 x,y, 바로 다음에 선택할 위치 ,0,0, 이동 횟수}
		qu.add(new int[] { x, y, -2, -2, 0 });

		while (!qu.isEmpty()) {
			int[] curr = qu.poll();
			System.out.println("poll했음 : " + curr[0] + " , " + curr[1]);

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				// 넘어가거나 이미 갔거나 잔디가 아니라면 안 갈거니까 건너뛰기
				if (nr >= N || nc >= N || nr < 0 || nc < 0) continue;
//				if (nr < N && nc < N && nr >= 0 && nc >= 0 && /*(mapData[nr][nc].equals("X") || mapData[nr][nc].equals("H"))*/ nr == 15 && nc == 0  ) {
				if( nr == 15 && nc == 0 ) {
					System.out.println("nextStep = " + curr[3] + " + " + curr[4]);
					return new int[] { curr[3], curr[4] };

				}
//				
//				if () {
////					System.out.println(d + " 이미 방문했어, 안 가");
//					continue;
//				}
////				if (!mapData[nr][nc].equals("G")) {
////					System.out.println(d + " 풀이 아냐, 안 가");
////					continue;
////				}
//				if () {
////					System.out.println(d + " 풀이 아냐, 안 가");
//					continue;
//				}

				// 만약 지금이 딱 첫 발자국이라면 그 발자국을 파라미터로 기억하기
				if (curr[4] == 0) {
//					System.out.println("첫발자국!" + nr + " + " + nc);
					qu.add(new int[] { nr, nc, nr, nc, 1 });
				} else if(!visited[nr][nc] && !(mapData[nr][nc].equals("R") || mapData[nr][nc].equals("W") || mapData[nr][nc].equals("T") /*|| mapData[nr][nc].equals("H") */) ) {
					// 첫 발자국이 아니라면 그 전꺼를 그대로 기억하기
					qu.add(new int[] { nr, nc, curr[2], curr[3], curr[4] + 1 });
//					System.out.println(nr+" + " + nc +"큐에 추가!");

				}
			}
		}
		return null;

	}
	// ----- 여기까지가 내 코드
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
		for (int i = 0; i < mapHeight; i++) {
			mapData[i] = rows[rowIndex + i].split(" ");
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