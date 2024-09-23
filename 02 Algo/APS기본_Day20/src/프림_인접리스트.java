import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 프림_인접리스트 {
	static class Node {
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}
	}
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
				+ "4 6 51");
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		List<Node>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();
			adj[v1].add(new Node(v2, w));
			adj[v2].add(new Node(v1, w));
		}
		
		int[] D = new int[V];  			// 최소비용
		boolean[] v = new boolean[V];	// 신장트리 포함 여부
		
//		Arrays.fill(p, -1);
		Arrays.fill(D, Integer.MAX_VALUE);
		
		D[0] = 0;  // 시작 정점 
		int ans = 0;
		for (int i = 0; i < V; i++) {
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
			for (Node node : adj[minVertax]) {
				if (!v[node.v] 
						&& D[node.v] > node.w) {
					D[node.v] = node.w;
				}
			}
		}
		System.out.println(ans);
	}
}










