package beakjoon;

import java.util.Scanner;

public class 최댓값_2566 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int max = 0;
	int[][] board = new int[9][9];
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			board[i][j] = sc.nextInt();
			if (board[i][j] > max) max = board[i][j];
		}
	}
	System.out.println(max);
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (board[i][j] == max) {
				System.out.println((i + 1)+" " + (j + 1));
				break;
			}
		}
	}
}
}
