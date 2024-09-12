package day0912;

import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법01_피보나치 {
	static int[] callFibo = new int[1000];
	static int[] memo; // 계산 값을 저장하기 위한 공간 할당
	
	static {
		memo = new int[1000];
		Arrays.fill(memo,  -1);
		memo[0] = 0;
		memo[1] = 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 움슈눈 들어오지 않는다고 가정하기 
		int N = sc.nextInt(); // 만약 계산이 21억을 넘어갈 것 같으면 전부 다 long 으로 바꿔줘야 함. 
		
		System.out.println(fibo1(N)); // 딜레이가 있음. 
		System.out.println(fibo2(N)); // 바로 나옴.
		System.out.println(fibo3(N)); // 딜레이가 있음. 
 //		System.out.println(Arrays.toString(callFibo));
	}
	
	public static int fibo3(int n) {
		int[] dp = new int [n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp[n];
	}
	
	public static int fibo2(int n) {
//		if (n >= 2 && memo[n] == 0)
		if (memo[n] == -1 )
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		return memo[n];
	}
	
	public static int fibo1(int n) {
		callFibo[n]++;
		// 기저 조건  n == 0 : 0을 반환 / n == 1 : 1 을 반환
		if (n <= 1) return n;
		return fibo1(n-1) + fibo1(n-2);
	}
	
}
