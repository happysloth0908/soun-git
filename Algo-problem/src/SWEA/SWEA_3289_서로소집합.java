package SWEA;

import java.util.*;
import java.io.*;


public class SWEA_3289_서로소집합 {
	static int[] parents;
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner("1\r\n" + "7 8\r\n" + "0 1 3\r\n" + "1 1 7\r\n" + "0 7 6\r\n" + "1 7 1\r\n"
				+ "0 3 7\r\n" + "0 4 2\r\n" + "0 1 1\r\n" + "1 1 1");
		int T = sc.nextInt(), t = 0;
		
		while (t++ < T) {
			N = sc.nextInt();
			M = sc.nextInt();
			parents = new int[N + 1];
			make();
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < M; i++) {
				int op = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				switch(op) {
				case 0: 
					union(x,y);
					break;
				case 1:
					if(find(x) == find(y)) {
						sb.append("1");
					}else {
						sb.append("0");
					}
				}
			}
			System.out.println("#" + t + " " + sb.toString());
		}
	}
	private static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]); // find 할 때마다 또 부모 찾아 삼만리 가지 않도록 저장해주는 것
	}
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}

	private static void make() {
		for (int i = 1; i < N + 1; i++) {
		parents[i] = i;
		}

	}
}
