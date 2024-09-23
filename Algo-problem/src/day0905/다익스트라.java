package day0905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다익스트라 {
	static class Node{
		int v, w;
		
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
		}
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
				+ "4 5 12\r\n"
				+ "");
		int V = sc.nextInt();
		int E = sc.nextInt();
//		int[][] adj = new int[V][V];
		List<Node>[] adj = new ArrayList[V]; 
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();			
		}
		
		int[] D = new int[V]; // 최소비용
		boolean[] v = new boolean[V]; // 신장트리 포함 여부
		Arrays.fill(D, Integer.MAX_VALUE);
		D[0] = 0; // 시작 정점!
		int ans = 0;

//		int[] p = new int[V]; // 누구로부터
		
//		for (int i = 0; i < E; i++) {
//			int v1 = sc.nextInt();
//			int v2 = sc.nextInt();
//			int w = sc.nextInt();
//			adj[v1][v2] = adj[v2][v1] = w;
//		}


//		Arrays.fill(p, -1);



		for (int i = 0; i < V; i++) {
			// 최소인 것 찾기
			int minCost = Integer.MAX_VALUE;
			int minVertax = -1;
			for (int j = 0; j < V; j++) {
				if (!v[j] && minCost > D[j]) { // ????근데 D[j] 는 지금 맥스 아닌가?
					minCost = D[j];
					minVertax = j;
				}
			}
			// 최소인 정점의 인접 정점들의 비용 업데이트
			ans += minCost;  
			v[minVertax] = true; 
			
			for (Node node : adj[minVertax]) {
				if (!v[node.v] && D[node.v] > D[minVertax] + node.w) {
					D[node.v] = D[minVertax] + node.w;
				}
			}
		}
		System.out.println(ans);
	}
}
