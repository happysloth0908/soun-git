import java.util.Arrays;
import java.util.Scanner;

public class 다익스트라_인접행렬 {
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
				+ "4 5 12");
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		
		int[] D = new int[V];  			// 최소비용
		boolean[] v = new boolean[V];	// 신장트리 포함 여부
		
		Arrays.fill(D, Integer.MAX_VALUE);
		
		D[0] = 0;  // 시작 정점 
		int ans = 0;
		for (int i = 0; i < V; i++) {
			// 최소인 것 찾기
			int minCost = Integer.MAX_VALUE;
			int minVertax = -1;
			for (int j = 0; j < V; j++) {
				if (!v[j] && minCost > D[j]) {
					minCost = D[j]; 
					minVertax = j;
				}
			}
			
			ans += minCost;			// 신장트리에 포함된 정점들의 비용
			v[minVertax] = true;  // 신장트리 포함
			
			// 최소인 정점의 인접 정점들의 비용 업데이트
			for (int j = 0; j < V; j++) {
				if (!v[j] 
						&& adj[minVertax][j] != 0
						&& D[j] > adj[minVertax][j] + D[minVertax]) {
					D[j] = adj[minVertax][j] + D[minVertax];
				}
			}
		}
		System.out.println(ans);
		System.out.println(Arrays.toString(D));
	}
}










