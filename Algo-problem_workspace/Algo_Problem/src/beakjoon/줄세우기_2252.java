package beakjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 줄세우기_2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 총 학생 수 
		int M = sc.nextInt(); // 비교한 횟수 / 간선 갯수
		
//		int[][] stu = new int[N + 1][N + 1]; // 2차원 배열은 메모리 초과남
		List<Integer>[] stu = new ArrayList[N + 1];
		int[] pre = new int[N + 1]; // [학생번호]의 값 = 그 학생의 선행조건(앞선 학생들 수)  
		boolean[] vis = new boolean[N + 1]; // 이미 줄 선 아이인지 파악 
		
		for (int i = 0; i < N + 1; i++) {
			stu[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			stu[A].add(B);
			pre[B]++;	// 선행조건/앞선 학생 수 표시
		}

		
		Queue<Integer> qu = new LinkedList();
		
		for (int i = 1; i < N + 1; i++) { // 얘를 while문 안에 넣으면 시간 초과 뜸. 
			if ( pre[i] <= 0 && !vis[i]) {
				qu.add(i); // 방문한 적 없고 선행조건 없는 애들 다 큐에 넣기
				vis[i] = true;
			} 
		}
		
		while(true) {


			if(qu.isEmpty()) break;
			
			int curr = qu.poll();

				for ( int c : stu[curr]) {
					pre[c]--; // 본인보다 키 큰애 하나 나갔으니 선행조건 하나 줄여주기
					if(pre[c] == 0 && !vis[c]) qu.add(c); // 지금 줄어든 애들 중에서만 다음 후보가 있으니까 여기서 qu에 추가
				}
			System.out.print(curr + " ");
			
		}
		
			
	}
}
