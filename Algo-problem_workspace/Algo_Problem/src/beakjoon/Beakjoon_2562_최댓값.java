package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Beakjoon_2562_최댓값 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int arr [] = new int[9];
		int max = 0;
		int count = 0;
		
		for (int i = 0; i < 9; i++) {
			int curr = Integer.parseInt(br.readLine());
			if(curr > max) {
				max = curr;
				count ++ ;
			}
		}
		
		System.out.println(max + "\n" + count);
	}
}
