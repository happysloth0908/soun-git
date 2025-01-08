package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon_1032_명령프롬프트2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] pattern = br.readLine().toCharArray();
		
		for (int i = 1; i < N; i++) {
			char[] curr = br.readLine().toCharArray();
			for (int j = 0; j < curr.length; j++) {
				if(pattern[j] != curr[j]) {
					pattern[j] = '?';
				}
			}
		}
		String ans = new String(pattern);
		System.out.println(ans);
	}
}
