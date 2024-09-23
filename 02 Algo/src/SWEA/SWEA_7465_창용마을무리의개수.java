package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_7465_창용마을무리의개수 {

	static int N, M; // 정점 , 간선
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(), t = 0;

		while (t++ < T) {
			N = sc.nextInt();
			M = sc.nextInt();
			parent = new int[N + 1];

			make();

			for (int i = 0; i < M; i++) { // 합쳐야 할 무리 다 입력
				union(sc.nextInt(), sc.nextInt());
			}
			
			// 후반 가서 다시 합치지 않은 애들은 그대로 두면 다른 숫자를 가르킴.
			// 그래서 이렇게 다시 처음부터 끝까지 훑어주면서 최종 부모 가르키게 해야 함. 
			for (int i = 1; i <= N; i++) {  
				find(i);
			}

			Set<Integer> group = new HashSet<>(); // 중복되는 수는 없애줄 set 등장

			for (int i = 1; i <= N; i++) { // 최종 부모 1명씩만 남게 담음
				group.add(parent[i]);
			}

			System.out.println("#" + t + " " + group.size()); // 최종 부모 수  = 무리 수
		}
	}

	private static void make() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);

	}

	private static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);

		if (xRoot == yRoot)
			return; // 서로 부모 노드가 같으면 연결 안 해줌으로써 루프 방지
		parent[yRoot] = xRoot;
		return;
	}

}
