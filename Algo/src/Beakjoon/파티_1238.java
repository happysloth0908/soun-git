package Beakjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 파티_1238 {
	public static class Node implements Comparable<Node> {
		int a; // 지점과 무게만 가지고 있으면 됨.
		int w;

		public Node(int a, int w) {
			super();
			this.a = a;
			this.w = w;
		}

		public int compareTo(Node o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Node [a=" + a + ", w=" + w + "]";
		}

	}

	public static int N;
	public static int M;

	public static int[] partyToHome;
	public static int[] homeToParty;

	public static List<Node>[] adj;
	public static List<Node>[] reverseAdj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 지점 수
		M = sc.nextInt(); // 간선 수
		int X = sc.nextInt(); // 시작할 점

		adj = new ArrayList[N + 1];
		reverseAdj = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
			reverseAdj[i] = new ArrayList<>();
		} // null 값이 안 나오게 초기화 시켜주기

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int time = sc.nextInt();

			adj[from].add(new Node(to, time));
			reverseAdj[to].add(new Node(from, time));
		} // 인덱스 = 한 지점, 인덱스 값 = 한 지점과 연결된 지점 & 그 가중치

		partyToHome = dijkstra(X, adj);
		homeToParty = dijkstra(X, reverseAdj);
		
		int max = 0;
		for (int i = 0; i < N + 1; i++) {
			int total = partyToHome[i] + homeToParty[i];
			if (max < total) max = total;
		}
		
		System.out.println(max);

	}

	private static int[] dijkstra(int X, List<Node>[] adj) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		int[] dist = new int[N + 1]; // 1부터 시작해서
		Arrays.fill(dist, Integer.MAX_VALUE); // 배열 다 최댓값으로 채우기
		dist[X] = 0;
		pq.offer(new Node(X, 0)); // add 로 하면 삽입에 실패하면 오류 발생

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int currNode = curr.a; // 제일 가중치가 작은 지점
			int currTime = curr.w; // 가중치

			if (currTime > dist[currNode])
				continue; // 다른 길로 돌아온 가중치가 더 작다면 넘어가기

			for (Node n : adj[currNode]) {
				int nextNode = n.a; // poll 된 지점과 연결된 지점
				int nextTime = currTime + n.w; // 그 전의 가중치 + 현재 가중치

				if (nextTime < dist[nextNode]) { // 합산된 가중치 < 시작점에서부터 거리 or 초기값
					dist[nextNode] = nextTime;
					pq.offer(new Node(nextNode, nextTime)); // 가중치 누적해서 다시 큐에 넣기

				}
			}
		}
		return dist;
	}

}
