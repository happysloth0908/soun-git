package day0909;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬01 {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static void main(String[] args) {
		Scanner sc = new Scanner("9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n"
				+ "5 6\r\n" + "9 6\r\n" + "6 7");

		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] adjArr = new int[V + 1][V + 1];
		int[] degree = new int[V + 1]; // 진입 차수를 저장할 배열

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adjArr[A][B] = 1; // 가중치 따로 없으니까 1로 표기!
			degree[B]++; // 진입 차수를 증가!
		} // 입력 완!

		// 1. 진입 차수가 0인 친구들 큐에 몽땅 넣기
		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0) {
				que.add(i);
			}
		}

		StringBuilder sb = new StringBuilder(); // 한꺼번에 출력을 위해 추가하는 애

		// 2. 큐가 공백 상태가 될때까지 진행
		// 간선 제거하고, 진입차수가 0이 되면 또 큐에 넣기
		while (!que.isEmpty()) {
			int curr = que.poll();
//			System.out.println(cook[curr]);
			sb.append(cook[curr]).append("\n"); // ??????이게 뭐지

			for (int i = 0; i < V + 1; i++) {
				// 유향이라 인덱스 순서가 중요함!
				if (adjArr[curr][i] == 1) {
					degree[i]--; // 진입차수 하나 깍기.
					adjArr[curr][i] = 0; // 이 과정 안 해도 괜찮긴 함.
					// 만약 이번에 i 정점의 진입차수가 0이 되었다면 큐에 넣기
					if (degree[i] == 0) {
						que.add(i);
					}
				}
			}

		}
		System.out.println(sb);
	}

}
