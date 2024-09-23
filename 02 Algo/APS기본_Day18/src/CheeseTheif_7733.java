
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheeseTheif_7733 {
	
	static int N, result, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			int max = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
					max = Math.max(max, map[r][c]);
				}
			}
			
			for (int i = 1; i < max; i++) {
				cnt = 0;
				bfs(i);
				result = Math.max(result, cnt);
				for (int j = 0; j < N; j++) {
					Arrays.fill(visited[j], false);
				}
			}
			
			System.out.println("#" + test_case + " " + (result == 0 ? 1 : result));
			result = 0;
		}
	}

	static void bfs(int i) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] > i && !visited[r][c]) {
					Queue<int[]> queue = new LinkedList<>();
					
					queue.add(new int[] {r, c});
					visited[r][c] = true;
					
					while (!queue.isEmpty()) {
						int[] tmp = queue.poll();
						
						int cr = tmp[0];
						int cc = tmp[1];
						
						for (int d = 0; d < 4; d++) {
							int nr = cr + dr[d];
							int nc = cc + dc[d];
							
							if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] > i) {
								queue.add(new int[] {nr, nc});
								visited[nr][nc] = true;
							}
						}
					}
					cnt++;
				}
			}
		}
	}
}