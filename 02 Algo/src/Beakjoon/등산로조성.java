package Beakjoon;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class 등산로조성 {
	static int N , K; // 지도 가로세로, 깍을 수 있는 정도
	static int[][] map; // 전체 지도
	static boolean[][] visited;
	static int maxH; // 가장 높은 곳
	static int ans;
//	static boolean usedK; // K를 사용해서 깎아줬는지
	//------------
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		int T = sc.nextInt(), t = 0;
		
		while(t ++ < T) {
			N = sc.nextInt(); // 지도 가로세로
			K = sc.nextInt(); //깍을 수 있는 정도
			map = new int[N][N];
			visited = new boolean[N][N];
			maxH = 0;
			ans = 0;
			
			//------지도 input 받으면서 최댓값 구하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] > maxH) maxH = map[i][j]; // 최댓값 구하기
				}
			}
			//-------
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxH) {// 최댓값을 찾으면 
						dfs(i, j, 1, false);
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
		
	}
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	static void dfs(int x, int y, int dist, boolean usedK){
		
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = x + dr[d];
			int nc = y + dc[d];
			
			// 경계 넘어가거나 이미 간 곳 쳐내기
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
			
			// 다음 칸이 더 낮을 경우
			if (map[x][y] > map[nr][nc]) {
				dfs(nr, nc, dist +1, usedK);
			}// 다음 칸이 높은데 K로 어떻게 깍아볼만 할 때 
			else if (!usedK && map[x][y] > map[nr][nc] - K) {
				int tmp = map[nr][nc];
				map[nr][nc] = map[x][y] - 1;
				dfs(nr, nc, dist + 1, true);
				map[nr][nc] = tmp;
			}
			
		}
		visited[x][y] = false;
		
		if(dist > ans)
			 ans = dist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static String input = "10\r\n"
			+ "5 1\r\n"
			+ "9 3 2 3 2\r\n"
			+ "6 3 1 7 5\r\n"
			+ "3 4 8 9 9\r\n"
			+ "2 3 7 7 7\r\n"
			+ "7 6 5 5 8\r\n"
			+ "3 2\r\n"
			+ "1 2 1\r\n"
			+ "2 1 2\r\n"
			+ "1 2 1\r\n"
			+ "5 2\r\n"
			+ "9 3 2 3 2\r\n"
			+ "6 3 1 7 5\r\n"
			+ "3 4 8 9 9\r\n"
			+ "2 3 7 7 7\r\n"
			+ "7 6 5 5 8\r\n"
			+ "4 4\r\n"
			+ "8 3 9 5\r\n"
			+ "4 6 8 5\r\n"
			+ "8 1 5 1\r\n"
			+ "4 9 5 5\r\n"
			+ "4 1\r\n"
			+ "6 6 1 7\r\n"
			+ "3 6 6 1\r\n"
			+ "2 4 2 4\r\n"
			+ "7 1 3 4\r\n"
			+ "5 5\r\n"
			+ "18 18 1 8 18\r\n"
			+ "17 7 2 7 2\r\n"
			+ "17 8 7 4 3\r\n"
			+ "17 9 6 5 16\r\n"
			+ "18 10 17 13 18\r\n"
			+ "6 4\r\n"
			+ "12 3 12 10 2 2\r\n"
			+ "13 7 13 3 11 6\r\n"
			+ "2 2 6 5 13 9\r\n"
			+ "1 12 5 4 10 5\r\n"
			+ "11 10 12 8 2 6\r\n"
			+ "13 13 7 4 11 7\r\n"
			+ "7 3\r\n"
			+ "16 10 14 14 15 14 14\r\n"
			+ "15 7 12 2 6 4 9\r\n"
			+ "10 4 11 4 6 1 1\r\n"
			+ "16 4 1 1 13 9 14\r\n"
			+ "3 12 16 14 8 13 9\r\n"
			+ "3 4 17 15 12 15 1\r\n"
			+ "6 6 13 6 6 17 12\r\n"
			+ "8 5\r\n"
			+ "2 3 4 5 4 3 2 1\r\n"
			+ "3 4 5 6 5 4 3 2\r\n"
			+ "4 5 6 7 6 5 4 3\r\n"
			+ "5 6 7 8 7 6 5 4\r\n"
			+ "6 7 8 9 8 7 6 5\r\n"
			+ "5 6 7 8 7 6 5 4\r\n"
			+ "4 5 6 7 6 5 4 3\r\n"
			+ "3 4 5 6 5 4 3 2\r\n"
			+ "8 2\r\n"
			+ "5 20 15 11 1 17 10 14\r\n"
			+ "1 1 11 16 1 14 7 5\r\n"
			+ "17 2 3 4 5 13 19 20\r\n"
			+ "6 18 5 16 6 7 8 5\r\n"
			+ "10 4 5 4 9 2 10 16\r\n"
			+ "2 7 16 5 8 9 10 11\r\n"
			+ "12 19 18 8 7 11 15 12\r\n"
			+ "1 20 18 17 16 15 14 13\r\n"
			+ "";
}
