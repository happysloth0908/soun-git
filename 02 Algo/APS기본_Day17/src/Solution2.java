import java.util.Scanner;

public class Solution2 {
	static int N, M, K, ans;
	static int[] data, sol;
	public static void main(String[] args) {
		Scanner sc = new Scanner("3\r\n"
				+ "5 3 66\r\n"
				+ "33 22 11 21 23\r\n"
				+ "5 3 67\r\n"
				+ "33 22 11 21 23\r\n"
				+ "19 8 70\r\n"
				+ "33 22 11 21 23 33 22 11 21 23 33 22 11 21 23 33 22 11 21");
		
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			ans = 0;
			data = new int[N];
			sol = new int[M];
			for (int i = 0; i < N; i++) data[i] = sc.nextInt();
			
			comb(0, 0);
			
			System.out.printf("#%d %d%n", t, ans == 0 ? -1 : ans * fact());
		}
 	}
	private static int fact() {
		int sum = 1;
		for (int i = 2; i <= M; i++) sum *= i;
		return sum;
	}
	private static void comb(int idx, int start) {
		if (idx == M) {
			int sum = 0;
			for (int i = 0; i < M; i++) sum += sol[i];
			if (sum == K) ans++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			sol[idx] = data[i];
			comb(idx + 1, i + 1);
		}
	}
}














