package SWEA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상호의배틀필드_1873 {

	static int H;
	static int W;
	static char[][] board;
	static char[] userCom;
	static int[] tankState;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(), t = 0; // 테케 수

		while (t++ < T) {
			H = sc.nextInt();
			W = sc.nextInt();

			board = new char[H][W];

			for (int i = 0; i < H; i++) {
				String tmp = sc.next();
				for (int j = 0; j < W; j++) {
					board[i][j] = tmp.charAt(j);
				}
			}

			int N = sc.nextInt();
			Queue<Character> userCom = new LinkedList<Character>(); // 사용자 커멘드

			String tmp = sc.next();
			for (int j = 0; j < N; j++) {
				userCom.add(tmp.charAt(j));
			}

			// -- 입력 끝

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			
			System.out.println("-------------");

			tankState = findTank();

			while (!userCom.isEmpty()) { // 사용자 커멘드가 끝날 때까지
				char curr = userCom.poll();
				switch (curr) {
				case 'S': // tankState의 첫 인덱스에서 방향을 보고 그 방향으로 포탄 던지기
					shoot();
					break;
				case 'U': // 위로 방향 돌리고 갈 수 있으면 가기
					tankState[0] = 1;
					board[tankState[1]][tankState[2]] = '^';
					go('^');
					break;
				case 'D': // 아래로 방향 돌리고 갈 수 있으면 가기
					tankState[0] = 2;
					board[tankState[1]][tankState[2]] = 'v';
					go('v');
					break;
				case 'L': // 왼쪽으로 방향 돌리고 갈 수 있으면 가기
					tankState[0] = 3;
					board[tankState[1]][tankState[2]] = '<';
					go('<');
					break;
				case 'R': // 오른쪽으로 방향 돌리고 갈 수 있으면 가기
					tankState[0] = 4;
					board[tankState[1]][tankState[2]] = '>';
					go('>');
					break;
				}
				
				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				
				System.out.println("--------");
				
			}

			int finalX = tankState[1];
			int finalY = tankState[2];
			char finalD;
			switch (tankState[0]) {
			case 1:
				finalD = '^';
				break;
			case 2:
				finalD = 'v';
				break;
			case 3:
				finalD = '<';
				break;
			case 4:
				finalD = '>';
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + tankState[0]);
			}
			
			board[finalX][finalY] = finalD;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}

		}

	}

	private static void go(char der) {
		System.out.println("go 호출");
		int d = tankState[0]; // 탱크 방향
		int x = tankState[1]; // 탱크 열
		int y = tankState[2]; // 탱크 행

		int nr = x + dr[d];
		int nc = y + dc[d];

		if (nr < 0 || nc < 0 || nr >= H || nc >= W || board[nr][nc] == '*' || board[nr][nc] == '#'
				|| board[nr][nc] == '-') {
			return; // 보드에서 벗어나거나 못가는 곳이면 그냥 돌아가기
		} else {
			board[x][y] = '.'; // 탱크가 있던 곳은 평지니까 평지로 바꾸고
			tankState[1] = nr;
			tankState[2] = nc; // 이동하기
			// 새로운 탱크의 위치는 딱히 표시할 필요 없긴 한데.... 마지막에만 표시하면 됨.
			board[tankState[1]][tankState[2]] = der;
			return;
		}

	}

	private static void shoot() { // 탱크 방향으로 쭉 가다가 벽을 만나면 멈춤. 벽돌이면 부숨.
		System.out.println("shoot 호출");
		System.out.println(tankState[0]);
		int d = tankState[0]; // 탱크 방향
		int x = tankState[1]; // 탱크 열
		int y = tankState[2]; // 탱크 행

		int nr = x + dr[d];
		int nc = y + dr[d];
		// 앞에 벽이 있거나 보드 끝이 아니라면 계속 가기
		// 앞에 벽이 있으면 멈추고 벽돌벽이면 부수기
		while (true) {
			if (nr < 0 || nc < 0 || nr >= H || nc >= W) {
				return; // 보드에서 벗어나면 그냥 돌아가기
			}
			if (board[nr][nc] == '.' || board[nr][nc] == '-') {
				nr += dr[d];
				nc += dr[d];
			} else if (board[nr][nc] == '*') {
				board[nr][nc] = '.'; // 부숴서 평지 만들기
				return;
			} else { // 강철 벽은 그냥 돌아가기
				return;
			}

		}

	}

	static int[] dr = { 0, -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, 0, -1, 1 };

	private static int[] findTank() {
		System.out.println("findTank 호출");
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (board[i][j] != '<' && board[i][j] != '>' && board[i][j] != '^' && board[i][j] != 'v') {
					continue;
				}
				switch (board[i][j]) { // 상하좌우 방향 확인
				case '^':
					return new int[] { 1, i, j };
				case 'v':
					return new int[] { 2, i, j };
				case '<':
					return new int[] { 3, i, j };
				case '>':
					return new int[] { 4, i, j };
				default:
					break;
				}
			}

		}
		return null;
	}
}