package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_13460_구슬탈출2 {
	static int N;
	static int M;
	static char map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		System.out.println(N + " " + M);

		map = new char[N][M];
//		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
//				map[i][j] = (char)br.read(); // 이렇게 하면 /n 도 하나의 문자로 입력됨...! 
				map[i][j] = line.charAt(j);
			}
		}

		////
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		/////
		Rlocation = null;
		Blocation = null;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R')
					Rlocation = new int[] { i, j };
				if (map[i][j] == 'B')
					Blocation = new int[] { i, j };
			}
		}
		System.out.println(
				"Rlocation: " + Arrays.toString(Rlocation) + "\n" + "Blocation: " + Arrays.toString(Blocation));

		BFS();

	}

	static int Rlocation[];
	static int Blocation[];
	static int dr[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dc[] = { 0, 0, -1, 1 }; // 상하좌우
//	static boolean visited[][];

	private static void BFS() {
		Queue<int []> que = new LinkedList<>();
		boolean visited[][] = new boolean[N][M];
		que.add(Rlocation);
		visited[Rlocation[0]][Rlocation[1]] = true;
		
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0];
				int nc = curr[1];
				
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '#'|| visited[nr][nc]) continue;
				if(map[nr][nc] == 'O') break;
				// 끝까지 가보기 # 에 부딪히기 전까지 
				int finalR = nr;
				int finalC = nc;
				while(finalR + dr[i] >= 0 && finalC + dc[i] >= 0 && finalR + dr[i] < N && finalC + dc[i] < M && map[finalR + dr[i]][finalC + dc[i]] == '.' ) {
				    finalR += dr[i];
				    finalC += dc[i];
				}

				if(!visited[finalR][finalC]) {
				    que.add(new int[] {finalR, finalC});
				    visited[finalR][finalC] = true;
				    System.out.println("추가됨 nr:" + finalR +"| nc:" + finalC);
				}
					
			}
		}
		
	}
}
