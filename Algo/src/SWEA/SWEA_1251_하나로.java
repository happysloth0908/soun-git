package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1251_하나로 {

	static int N;
	static int[][] position;
	static double fee;

	static class Edge {
		int From;
		int to;
		double edgeLen; // 나중에 이거랑 세율 곱해서 답 출력하기\

		public Edge(int from, int to, int edgeLen) {
			super();
			From = from;
			this.to = to;
			this.edgeLen = edgeLen;
		}

//		@Override
//		public String toString() {
//			return "Edge [From=" + From + ", to=" + to + ", edgeLen=" + edgeLen + "]";
//		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner("2\r\n" + "2\r\n" + "0 0\r\n" + "0 100\r\n" + "1.0\r\n" + "4\r\n" + "0 0 400 400\r\n"
				+ "0 100 0 100\r\n" + "1.0");

		int T = sc.nextInt(), t = 0;
		while (t++ < T) {

			N = sc.nextInt();
			position = new int[N][2];

			// 섬 좌표 인풋 받기
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					position[j][i] = sc.nextInt();
				}
			}			
			fee = sc.nextDouble();
			
//			System.out.println(Arrays.deepToString(position));
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					Math.pow(position[i][0] - position[j][0], 2);
					
				}
			}
		}
	}
}
