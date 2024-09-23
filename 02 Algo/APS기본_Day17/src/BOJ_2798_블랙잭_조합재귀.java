import java.util.Scanner;

public class BOJ_2798_블랙잭_조합재귀 {
	static int data[], N, M, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		// cnt, start, sum
		solve(0, 0, 0);
		System.out.println(ans);
	}
	
	static void solve(int cnt, int start, int sum) {
		if (sum > M) return;
		if (cnt == 3) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = start; i < N; i++) {
			solve(cnt + 1, i + 1, sum + data[i]);
		}
	}
}

/*
5 21
5 6 7 8 9
21

10 500
93 181 245 214 315 36 185 138 216 295
497
*/