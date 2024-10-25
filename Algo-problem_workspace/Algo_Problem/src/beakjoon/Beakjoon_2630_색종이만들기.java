package beakjoon;

import java.util.Scanner;

public class Beakjoon_2630_색종이만들기 {
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//		System.out.println("-------맵 정보------");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		cutAndCheck(N);
		System.out.println(count);
		
		
		
		
	}
	static int count = 0;
	private static void cutAndCheck(int r, int c, int n) {
		if(n == 1) {
			count += 4;
			return;
		}
		if(n % 2 != 0) return;
		System.out.println("재귀호출! : " + n);
		int hn = n/2;
		for (int i = 0; i < hn ; i++) {
			for (int j = 0; j < hn; j++) {
				if(map[0][0] != map[i][j]) {
					System.out.println( "시작 색은 "+ map[0][0] + " 인데 지금 색은 " + map[i][j]);
					cutAndCheck(hn);
					break;
				}
			}
		}
		System.out.println("색이 모두 " + map[0][0] +" 같아서 통과 count :" + count);
		count++;
		for (int i = hn; i < n ; i++) {
			for (int j = 0; j < hn; j++) {
				if(map[hn][0] != map[i][j]) {
					System.out.println( "시작 색은 "+ map[hn][0] + " 인데 지금 색은 " + map[i][j]);
					cutAndCheck(hn);
					break;
				}
			}
		}
		System.out.println("색이 모두 같아서 통과 count :" + count);
		count++;
		for (int i = 0; i < hn ; i++) {
			for (int j = hn; j < n; j++) {
				if(map[0][hn] != map[i][j]) {
					System.out.println( "시작 색은 "+ map[0][hn] + " 인데 지금 색은 " + map[i][j]);
					cutAndCheck(hn);
					break;
				}
			}
		}
		System.out.println("색이 모두 같아서 통과 count :" + count);
		count++;
		for (int i = hn; i < n ; i++) {
			for (int j = hn; j < n; j++) {
				if(map[hn][hn] != map[i][j]) {
					System.out.println( "시작 색은 "+ map[hn][hn] + " 인데 지금 색은 " + map[i][j]);
					cutAndCheck(hn);
					break;
				}
			}
		}
		System.out.println("색이 모두 같아서 통과 count :" + count);
		count++;
		
		
		
	}
}
