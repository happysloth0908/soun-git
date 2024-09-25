package 그외;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 산악구조 {
	
	public static List<Node>[] inl; // 인접 리스트
	public static boolean[] visited; // 방문 체크
	public static int[][] mount; // 산 배열
	
	
//	static int[] dr = new int[];
//	static int[] dc = { 0, 0 ,1 ,-1};
	
	public class Node{
		int v;
		int w;
	
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			int N = sc.nextInt();
			
			visited = new boolean[(N+1)*(N+1)];
			inl = new ArrayList[(N+1)*(N+1)];  
			
			for (int i = 1; i < (N+1)*(N+1); i++) {
				inl[i] = new ArrayList<>();
			} //  null 값 안 나오게 하기!

			for (int i = 0; i < N + 1; i++) {
				int y = 0;
				y ++;
				for (int j = 0; j < N + 1; j++) {
					
					for (int d = 0; d < args.length; d++) {
////						int nr = i + dr[d];
////						int nc = j + dc[d];
//						
//						if (nr > 0 && nc > 0 && nr < N+1 && nc < N+1 ) {
//							inl[i].add(new Node(y,mount[nr][nc]));
//						}
					}
				}
			}
			
		}
		
	}

	}

