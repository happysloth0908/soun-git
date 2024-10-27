package beakjoon;

import java.util.Scanner;

public class Beakjoon_2630_색종이만들기 {
	static int[][] map;
	static int blueCount = 0;
	static int whiteCount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//		System.out.println("-------맵 정보------");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		cut(0, 0, N);
//		System.out.println("whiteCount: " + whiteCount);
//		System.out.println("blueCount: " + blueCount);
		System.out.println(whiteCount);
		System.out.println(blueCount);
	}

	private static void cut(int r, int c, int size) {
//		if(size == 1) {
//			return;
//		}
		
		boolean check = check(r, c, size); // 같은 색인지 확인하기
		int newSize = size/2;
		if (!check) { // 같은 색이 아니라면 분할하기
			cut( r, c, newSize); // 왼쪽 위
			cut( r , c+ newSize, newSize); // 오른쪽 위
			cut( r+newSize , c, newSize); // 왼쪽 아래 
			cut( r+newSize, c+newSize , newSize); // 오른쪽 아래
		}
		

	}

	private static boolean check(int r, int c, int size) {// 같은 색인지 확인
//		System.out.println(r + " " + c + " " + size);
		int color = map[r][c];


		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if (map[i][j] != color) {
//					System.out.println(color + " 와 같은 색 아니구만");
					return false;
				}
			}
		}
		if (color == 1) {
			blueCount += 1;
		} else {
			whiteCount += 1;
		}
		return true;
	}

}
