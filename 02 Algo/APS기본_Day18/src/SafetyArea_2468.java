import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SafetyArea_2468 {
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int count, max, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		int maxHeight = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				maxHeight = Math.max(maxHeight, map[r][c]);
			}
		}
		
		max = 0;
		
		for (int i = 0; i < maxHeight; i++) {
			inspect(i);
			for (int j = 0; j < N; j++) {
				Arrays.fill(visited[j], false);
			}
			max = Math.max(max, count);
			count = 0;
		}
		
		System.out.println(max);
	}
	
	static void inspect(int height) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] - height > 0 && visited[r][c] == false) {
					bfs(r, c, height);
					count++;
				}
			}
		}
	}
	
	static void bfs(int r, int c, int height) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {r, c});
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int pr = tmp[0];
			int pc = tmp[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = pr + dr[d];
				int nc = pc + dc[d];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] - height > 0 && visited[nr][nc] == false) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
