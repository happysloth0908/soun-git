import java.util.Arrays;
import java.util.Scanner;

public class 프림_인접행렬_연습 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 11\r\n"
				+ "0 1 32\r\n"
				+ "0 2 31\r\n"
				+ "0 5 60\r\n"
				+ "0 6 51\r\n"
				+ "1 2 21\r\n"
				+ "2 4 46\r\n"
				+ "2 6 25\r\n"
				+ "3 4 34\r\n"
				+ "3 5 18\r\n"
				+ "4 5 40\r\n"
				+ "4 6 51");		// 175
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		int[] D = new int[V];
		boolean[] visited = new boolean[V];
		
		Arrays.fill(D, Integer.MAX_VALUE);
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			adj[from][to] = adj[to][from] = weight;
		}
		
		D[0] = 0;
		
		int sum = 0;
		// 프림 시작...
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
				if (!visited[j] && adj[minVertax][j] != 0 && D[j] > adj[minVertax][j]) {
					D[j] = adj[minVertax][j];
				}
			}
		}
		System.out.println(Arrays.toString(D));
		System.out.println(sum);
	}
}





















