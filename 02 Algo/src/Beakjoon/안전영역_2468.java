package Beakjoon;

import java.util.Scanner;

public class 안전영역_2468 {
	static int MAX;
	static int N;
	static int[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MAX = 1;
		N = sc.nextInt();
		board = new int[N][N];
		int maxWater = 0;
		int minWater = Integer.MAX_VALUE;
		
		// -------보드 완성 ------------
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] > maxWater) maxWater = board[i][j];
				if (board[i][j] < minWater) minWater = board[i][j];
			}
		}
		// -------------------
		
		// 물 높이에 따라 한 번씩 다 경우의 수를 따져주기
		for (int i = minWater; i < maxWater; i++) {
			boolean[][] visited = new boolean[N][N];
			dfs(i, visited);
		}
		
		System.out.println(MAX);
		
		
	}
	
	// 안전 지역의 시작점 찾기! 아직 방문 안 하고 높은 곳 찾아서 시작!
	public static void dfs(int wLevel, boolean[][] visited){
		int safePlace = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ( wLevel < board[i][j] && !visited[i][j]) {
					DFS(i, j , visited, wLevel);
					safePlace++; // 한번 DFS 를 돌아 나왔다는 건 한 안전 지역을 다 탐색하고 왔다는 거니까 + 1
//					System.out.println(safePlace); // 디버깅 출력문
				}
			}
		}
		if (MAX < safePlace) MAX = safePlace;
	}
	
	private static void DFS(int i, int j, boolean[][] visited, int wLevel) {
		// --------디버깅용 출력문 -------- 
//		for (int k = 0; k < N; k++) {
//			for (int k2 = 0; k2 < N; k2++) {
//				if (visited[k][k2]) {
//					System.out.print("v");
//				}else {
//					System.out.print(0);					
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("-----------");
		// --------디버깅용 출력문 --------
		
		// 방문 처리 해주기
		visited[i][j] = true;
		
		//사방 탐색해서 나아갈 곳 정하기 
		//for 문을 탐색하다가 말고 재귀로 또 호출할거임. 그 호출된게 끝나면 하다만거 하러 돌아올거임. 
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			// 판 밖을 넘어가거나 이미 들린 곳이라면 패스 
			if (nc < 0 || nr < 0 || nc >= N || nr >= N || visited[nr][nc]) continue;
			
			if (board[nr][nc] > wLevel) {
				DFS(nr, nc, visited, wLevel);
			}
		}
		
	}
}
