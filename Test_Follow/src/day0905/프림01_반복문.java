package day0905;

import java.util.Arrays;
import java.util.Scanner;

public class 프림01_반복문 {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			adjArr[A][B] = adjArr[B][A] = W; // 무향이니까
		}
		boolean[] visited = new boolean[V];
		int[] p = new int[V]; // 부모 표시 (근데 필요없을거면 작성 안 해두 됨 )
		int[] dist = new int[V]; // 선택한 간선의 가중치

		// 프림 제 1장: 초기화!!
		for (int i = 0; i < V; i++) {
			dist[i] = INF;
		}
//		Arrays.fill(dist, INF); // 위의 코드랑 똑같은거 
		
		// 프림 제 2장 : 시작정점을 결덩
		dist[0] = 0;
		
		//프림 제 3장 : 가중치 배열을 돌면서 가장 값이 낮은 것을 골라서 방문 췍! / 갱신
		for (int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;
		 // 방문 안 하고  가장 작은 값 가져와
			for (int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}// 해당 반복문이 종료가 되면  idx는 가장 작은 값을 가짐! 방문하지 않은
			visited[idx] = true; // 방문처리

			// 방문 안 하고 갱신 가능하면 갱신해 
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx; // 필요시
				}
			}// 끝~!
	
		}
		int ans = 0;
		for (int i = 0; i < V; i++) {
			ans += dist[i];
		}
		System.out.println(ans);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51";
}
