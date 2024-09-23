import java.util.Arrays;
import java.util.Scanner;

public class 다익스트라_인접행렬_연습 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("6 11\r\n"
				+ "0 1 4\r\n"
				+ "0 2 2\r\n"
				+ "0 5 25\r\n"
				+ "1 3 8\r\n"
				+ "1 4 7\r\n"
				+ "2 1 1\r\n"
				+ "2 4 4\r\n"
				+ "3 0 3\r\n"
				+ "3 5 6\r\n"
				+ "4 3 5\r\n"
				+ "4 5 12");  // 39
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[] D = new int[V];
		int[][] adj = new int[V][V];
		boolean[] visited = new boolean[V];

		Arrays.fill(D, Integer.MAX_VALUE);
		
		for (int i = 0; i < E; i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		
		
		D[0] = 0;
		
		int sum = 0;
		for (int i = 0; i < V; i++) {
		
			// 최소 비용을 가진 정점을 선택하자...
			int minCost = Integer.MAX_VALUE;
			int minVertax = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && minCost > D[j]) {
					minCost = D[j];
					minVertax = j;
				}
			}
			sum += minCost;
			visited[minVertax] = true;
			
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adj[minVertax][j] != 0 && D[j] > adj[minVertax][j] + D[minVertax]) {
					D[j] = adj[minVertax][j] + D[minVertax];
				}
			}
		}
		System.out.println(sum);
		System.out.println(Arrays.toString(D));
	}
}





































