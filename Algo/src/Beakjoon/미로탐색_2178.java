package Beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {

	static int N, M;

	static int[][] arr;
	static boolean[][] visited;

	static int answer;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Pos {
		int r;
		int c;
		int d; // 지금까지 온 거리

		public Pos(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}

		bfs();

	}

	private static void bfs() {
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(0, 0, 1));
		visited[0][0] = true;

		while (!que.isEmpty()) {

			Pos curr = que.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || arr[nr][nc] == 0)
					continue; // 조건에 안 맞으면 다음 d로 넘어가!

				que.add(new Pos(nr, nc, curr.d + 1));

				visited[nr][nc] = true;
				if (nr == N - 1 && nc == M - 1) {
					answer = curr.d + 1;
					System.out.println(answer);
					return;
				}
			}
		}

	}

}
