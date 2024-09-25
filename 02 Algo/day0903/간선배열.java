package day0903;
import java.util.List;
import java.util.Scanner;

public class 간선배열 {


/////////////////////클래스
	static class Edge {
		int A, B, W;

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return  A + "-" + B + ", W=" + W ;
		}
	}

	////////////////////////

	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"5 10\r\n" + "1 2 1 1 3  1 1 4 1 1 5 1\r\n" + "2 3 1 2 4 1 2 5 1 \r\n" + "3 4 1 3 5 1 \r\n" + "4 5 1");

		int V = sc.nextInt();
		int E = sc.nextInt();

		Edge[] edge = new Edge[E];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();

			edge[i] = new Edge(A, B, W);
//			edge[i] = new Edge(B, A, W);
		}
		for (int i = 0; i < E; i++) {
			System.out.println(edge[i]);

		}

	}
}
