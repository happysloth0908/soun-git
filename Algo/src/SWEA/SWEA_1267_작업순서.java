package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1267_작업순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10, t = 0;
		while (t++ < T) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			int[][] adjArr = new int[V + 1][V + 1];
			int[] degree = new int[V + 1]; // 선행 조건 얼마나 있는지 표시

			for (int i = 0; i < E; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				adjArr[r][c] = 1;
				degree[c] += 1;
			} // 입력 완료

			// 1. 우선적으로 진입차수가 0인 친구들 큐에 몽땅 넣기
			Queue<Integer> que = new LinkedList<>();
			for (int i = 1
					; i < V + 1; i++) {
				if (degree[i] == 0) {
					que.add(i);
				}
			}
			
			System.out.print("#" + t + " ");
			while (!que.isEmpty()) {
				int curr = que.poll();
				System.out.print(curr + " ");
				for (int i = 1; i < V + 1; i++) {
					if(adjArr[curr][i] == 1) {
						degree[i]--;
						if (degree[i] == 0) {
							que.add(i);							
						}
					}
					
				}
			}
			System.out.println();

		}

	}
}
