package beakjoon;

import java.util.Scanner;

public class Beakjoon_17484_진우의달여행 {
	static int N;
	static int M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 행 
		M = sc.nextInt(); // 열
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
		int c = 0; // 열 위치
		int r = 0; // 행 위치
		int pc = -2; // 전의 c 위치
		int sum = 0; // 합
		for (int i = 0; i < M; i++) {
			c = i;
			move(r, c, pc, sum); // 0, 0, -2, 0 초기값
		}
		
		System.out.println(min);
		
	}
	static int min;
	private static void move(int r, int c, int pc, int sum) {
		// 무조건 r은 한 칸씩 늘어나기 
		// c 는 -1, 0, 1로 변화하는데 전에 했던 건 안 됨. 
//		System.out.println("int r : " + r + "| int c : " + c + "| int pc : " + pc + "| int sum : " + sum);
		
		if(r >= N) { // 달에 도착하면 그동안의 sum 값을 비교해서 초기화하기
			if (sum < min) {
				min = sum;
//				System.out.println("갱신된 sum:" + sum);
			}
//			System.out.println("-----");
			return; // 왔던 곳으로 돌아가기
		}
		
		if(c < 0 || c >= M ) return; // 아래 넘어가기 전에 범위 나가면 내쫓기
		
		sum += map[r][c];
			
		//왼쪽 아래로 갈 때 
		if(pc != -1) {
			move( r + 1, c - 1, -1, sum);
		}
		
		// 아래로 갈 때
		if(pc != 0) {
			move( r + 1, c, 0, sum);
		}
		
		//오른쪽 아래로 갈 때 
		if(pc != 1) {
			move( r + 1, c + 1, 1, sum);
		}
		
	}
}
