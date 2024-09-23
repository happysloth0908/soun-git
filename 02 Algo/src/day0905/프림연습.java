package day0905;

import java.util.Arrays;
import java.util.Scanner;

public class 프림연습 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();
			adj[v1][v2] = adj[v2][v1] = w;
		}

		int[] p = new int[V]; // 누구로부터
		int[] D = new int[V]; // 최소비용
		boolean[] v = new boolean[V]; // 신장트리 포함 여부

		Arrays.fill(p, -1);
		Arrays.fill(D, Integer.MAX_VALUE);

		D[0] = 0; // 시작 정점!

		int ans = 0;

		for (int i = 0; i < V; i++) {
			// 최소인 것 찾기
			int minCost = Integer.MAX_VALUE;
			int minVertax = -1;
			for (int j = 0; j < V; j++) {
				if (!v[j] && minCost > D[j]) { // ????근데 D[j] 는 지금 맥스 아닌가?
					minCost = D[j];
				}
			}
			// 최소인 정점의 인접 정점들의 비용 업데이트
			ans += minCost; // 신장 트리에 포함된 정점들의 비용
			v[minVertax] = true; // 신장 트리 포함
			for (int j = 0; j < V; j++) {
				if (!v[j] && adj[minVertax][j] != 0 && D[j] > adj[minVertax][j]) {
					D[j] = adj[minVertax][j];
					p[j] = minVertax;
				}
			}
		}
		System.out.println(ans);
	}
}
