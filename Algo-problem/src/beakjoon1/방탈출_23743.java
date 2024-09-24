package beakjoon1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 방탈출_23743 {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int w; //시간인데 걍 가중치는 w로 다 표기하자
		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w; 
		}
		
		
		
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 지점 
		int M = sc.nextInt(); // 간선
		
		int nN = N + 1;
		int nM = M + 1; //왜냐면 마지막 탈출구도 지점으로 여김
		
		List<Edge>[] adjList = new ArrayList[nM + 1]; 
	
		for (int i = 1; i < M + 1; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			
			adjList[A].add(new Edge(A, B, C));
			adjList[B].add(new Edge(A, B, C));
		}
		
		for (int i = 1; i < M + 1; i++) {
			adjList[nM].add(new Edge(nM, i, sc.nextInt()));
		} // 탈출구를 마지막 지점으로 추가해줌. 
		
		int[] visited = new int[nM + 1];
		
			
	}
}
