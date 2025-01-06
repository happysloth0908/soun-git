package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beakjoon_10798_세로읽기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char arr [][] = new char [6][16];
		
		for (int i = 0; i < 5; i++) {
			String temp = br.readLine();
			for (int j = 0; j < temp.length(); j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
				
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 15; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(arr[j][i] == '\u0000') {
					continue;
				}
				System.out.print(arr[j][i]);
			}
		}
		
		
		
	}
}
