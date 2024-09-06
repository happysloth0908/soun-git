package day0906;

import java.util.Scanner;

// 미완. 라이브 코드 보기 
public class 보호필름 {
	static int D, W, K; //D: 행 3~13 W: 열 1~20 K: 통과기준 1~D
	static int[][] film;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			ans = K;
			
			makefilm(0,0);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	// idx 현재 약을 주입하려는 행
	// cnt  약품을 주입한 횟수
	private static void makefilm(int idx, int cnt) {
		if(idx == D) {
			if(isOk())
				ans = Math.min(ans, cnt);
			return;
		}
		
		
	}
	// 모든 열의 연속된 특성이 K개 이상인가?
	private static boolean isOk() {
		//열을 고정시킨 상태에서 검사할거임. 
		for (int c = 0; c < W; c++) {
			boolean flag = false; 
			int cnt = 1;
			
			for (int r = 1; r < D; r++) {
				if(film[r][c] == film[r - 1][c]) cnt++;
				else cnt = 1; 
				
				if(cnt >= K) {
					flag = true;
					break;
				}
			}
			if(!flag) return false;
		}
		return true; 
	}
	
	
}
