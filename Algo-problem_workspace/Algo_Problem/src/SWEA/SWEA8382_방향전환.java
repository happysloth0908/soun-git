package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA8382_방향전환 {
//	static int X; // 시작점
//	static int Y;
	static int eX;	// 끝지점
	static int eY;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
				arr = new int[200][200];

				int X = sc.nextInt() + 100;
				int Y = sc.nextInt() + 100;
				eX = sc.nextInt() + 100;
				eY = sc.nextInt() + 100;
			
				int ans = bfs(X,Y);
				
				System.out.println("#"  + t + " " + ans);
				
		}
		
	}
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	// rl 은 좌우로 갔는지 판단, 0이면 그전에 상하, 1이면 그전에 좌우로 간것
	private static int bfs(int x, int y) {
		visited = new boolean[200][200];
		Queue<int[]> que = new LinkedList<>();
		//x 좌표, y 좌표, 전에 좌우 갔는지, sum
		que.add(new int[]{x, y, 0, 0});
		que.add(new int[]{x, y, 1, 0});
		
		while(!que.isEmpty()) {
			int[] curr = que.poll();
			visited[curr[0]][curr[1]] = true;
			if(curr[0] == eX && curr[1] == eY) {
				return curr[3];
				
			}
			
			if(curr[2] == 0) { // 상하로 갔으니 이제 좌우로 가야 함. 
				for (int i = 0; i < 2; i++) {
					int nr = curr[0] + dr[i];
					int nc = curr[1] + dc[i];
					
					
					if(nr < 0 || nc < 0 || nr >= 200 || nc >= 200 || visited[nr][nc]) {
						continue; // 범위 나가거나 이미 방문했으면 제외
					}
					que.add(new int[] {nr, nc, 1, curr[3] + 1});
				}
			}else {// 좌우로 갔으니 이제 상하로 가야 함. 
				for (int i = 2; i < 4; i++) {
					int nr = curr[0] + dr[i];
					int nc = curr[1] + dc[i];
					
					
					if(nr < 0 || nc < 0 || nr >= 200 || nc >= 200 || visited[nr][nc]) {
						continue; // 범위 나가거나 이미 방문했으면 제외
					}
					que.add(new int[] {nr, nc, 0, curr[3] + 1});
				}
				
			}
		}
		return 0;
	}
}
