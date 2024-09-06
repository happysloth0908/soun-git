package t;

import java.util.Arrays;
import java.util.Scanner;

public class 인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("5\r\n"
				+ "1 2 1 3 1 4 1 5\r\n"
				+ "2 3 2 4 2 5 \r\n"
				+ "3 4 3 5 \r\n"
				+ "4 5 ");
		int N = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];

		int n = (N * (N - 1)) / 2;
		for (int i = 0; i < n; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			arr[A][B] = 1;
			arr[B][A] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		}
}
