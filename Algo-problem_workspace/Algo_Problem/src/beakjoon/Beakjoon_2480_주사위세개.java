package beakjoon;

import java.util.Scanner;

public class Beakjoon_2480_주사위세개 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int ans;
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a > max) max = a;
			if(b > max) max = b;
			if(c > max) max = c;
			
			if(a == b && b == c && c == a ) {
				ans = 10000 + a * 1000;
			}
			else if(a == b || a == c) {
				ans = 1000 + a * 100;
			}
			else if(b == c) {
				ans = 1000 + b * 100;
			}
			else {
				ans = max *100;
			}
			System.out.println(ans);
	}
}
