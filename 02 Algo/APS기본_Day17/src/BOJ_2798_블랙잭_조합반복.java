import java.util.Scanner;

public class BOJ_2798_블랙잭_조합반복 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {			
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = data[i] + data[j] + data[k];
					if (sum > M) continue;
					ans = Math.max(ans, sum);
				}
			}
		}
		System.out.println(ans);
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