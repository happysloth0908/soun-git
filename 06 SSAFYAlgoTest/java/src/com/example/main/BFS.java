package com.example.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	static int N;
	static String[][] mapData;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = 16;
		mapData = new String[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				mapData[i][j] = sc.next();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mapData[i][j]);
			}
			System.out.println();
		}
		
		int[] next_step = bfs(1,15);
		
		int a = next_step[0];
		int b = next_step[1];
		String output = null;
		
		if (a == -1 && b == 0) {
			output = "U A";
		} else if (a == 1 && b == 0){
			output = "D A";
		} else if (a == 0 && b == -1){
			output = "L A";
		} else if (a == 0 && b == 1 ){
			output = "R A";
		}
		
		
		System.out.println(output);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	private static int[] bfs(int i, int j) {
		Queue<int[]> qu = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int sr = -2;
		int sc = -2;
		qu.add(new int[] { i, j, sr, sc, 0});
		System.out.println(i + " + " + j);
		visited[i][j] = true;
	
		
		while(!qu.isEmpty()) {
			
			int[] curr = qu.poll();
			visited[curr[0]][curr[1]] = true;
			System.out.println(Arrays.toString(curr));
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) {
					continue;
				}
				if(mapData[nr][nc].equals("X")) {
					System.out.println("찾았다! 포탑");
					return new int[] {curr[2] ,curr[3]};
				}
				
				if(mapData[nr][nc].equals("G")) {
					System.out.println("잔디다");
//					continue;
					System.out.println(curr[4]);
					if(curr[4] == 0) {
						sr = dr[d]; // 방향 저장
						sc = dc[d];
					}
					System.out.println("curr[2]&[3]= " + "[" + curr[2] + "]" +"[" + curr[3] + "]");
//					qu.add(new int[] {nr, nc, curr[2], curr[3], curr[4]});
					qu.add(new int[] {nr, nc, sr, sc, curr[4] + 1});
					
				}
				
			}
			
		}
		return null;
		
		
		
	}
	
}
