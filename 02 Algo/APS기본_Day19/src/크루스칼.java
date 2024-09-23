import java.util.Arrays;
import java.util.Scanner;

public class 크루스칼 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	static int[] parents;
	static int V, E;
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
		V = sc.nextInt();
		E = sc.nextInt();
		parents = new int[V];
		Edge[] edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {  // 간선정보 저장
			edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(edgeList);

		make();
		
		int cnt = 0;  // 선택된 간선의 수
		int sum = 0;
		for (Edge e : edgeList) {
			if (!union(e.from, e.to)) continue;
			
			sum += e.weight;
			if (++cnt == V - 1) {
				break;
			}
		}
		System.out.println(sum);
	}
	
	// 만들기
	public static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	// 찾기
	public static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	// 합치기
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}










