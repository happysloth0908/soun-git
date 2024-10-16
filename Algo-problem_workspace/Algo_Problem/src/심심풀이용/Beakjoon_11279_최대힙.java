package 심심풀이용;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Beakjoon_11279_최대힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int curr = sc.nextInt();
			if(curr == 0 ) { 	// 0이 입력되면
				if(pq.isEmpty()) {   // 근데 큐가 비어있다면
					System.out.println(0); // 0을 출력하고
					continue;				// 탈출하기
				}
				int max = pq.poll();		// 0 이 입력되고 큐가 비지 않았다면 폴하기
				System.out.println(max);	// 폴 출력하기
			}else {
				pq.add(curr);	// 0이 입력이 아니라면 큐에 넣기
			}
		}
	}
}
