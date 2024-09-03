package t;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("5 10\r\n"
				+ "1 2 1 3 1 4 1 5\r\n"
				+ "2 3 2 4 2 5 \r\n"
				+ "3 4 3 5 \r\n"
				+ "4 5 ");
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		
		List<Integer>[] injupList = new ArrayList[V + 1];
	
		for (int i = 0; i <= V; i++) {
			injupList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			injupList[A].add(B);
			injupList[B].add(A);
		}
		
		for (int i = 1; i <= V; i++) {
			for (int j = 0; j < injupList[i].size(); j++) {
				System.out.print(i + " " + "=>" + " " +  injupList[i].get(j));	
				System.out.println();
				
			}
			System.out.println();
		}
		
		
	}
}
