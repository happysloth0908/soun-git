package beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beakjoon_1012_유기농배추 {
	static int map[][];
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();  //가로
			N = sc.nextInt();	// 세로
			map= new int [M][N];
			int K = sc.nextInt(); // 배추 개수
			for (int j = 0; j < K; j++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}
			
//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			int ans = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					ans++;
//					System.out.println("보낸다 : " + i + "," + j);
					BFS(i, j);
				}
			}
		}
		System.out.println(ans);
		}
	}

	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {1, -1, 0, 0};
	private static void BFS(int a, int b) {
		Queue<int[]> que = new LinkedList<>();
		
		que.add(new int [] {a,b});
		map[a][b] = 0;
		
		while(!que.isEmpty()) {
			int curr [] = que.poll();
//			System.out.println(curr[0] + "," + curr[1]);
//			map[curr[0]][curr[1]] = 0; // 이렇게 나올 때 방문처리를 하면 너무 늦어서 중복이 있을 수 있음. 
			
			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + curr[0];
				int nc = dc[i] + curr[1];
				
				if(nr < M && nc < N && nr >= 0 && nc >= 0 && map[nr][nc] == 1) {
					que.add(new int [] {nr, nc});
					map[nr][nc] = 0;
				}
			}
			
		}
		
	}
}
