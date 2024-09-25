package beakjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호붙이기_2667 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		// 디버깅 출력
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		///// 입력 완료
		List<Integer> complexSize = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 집이 있고, 방문한 적이 없다면
				if (map[i][j] == 1 && !visited[i][j]) {
					int size = bfs(i, j); // 아파트 번지수도 추가하기
					complexSize.add(size);
					// ---- 디버깅용 출력-----
//					for (int ii = 0; ii < N; ii++) {
//					for (int jj = 0; jj < N; jj++) {
//						System.out.print(map[ii][jj]);
//					}
//					System.out.println();
//				}
					// ---- 디버깅용 출력-----

				}
			}
		}

		Collections.sort(complexSize);
		
		System.out.println(complexSize.size());
		
		for (int i = 0; i < complexSize.size(); i++) {
			System.out.println(complexSize.get(i));			
		}

	}

	private static int bfs(int x, int y) {
		Queue<int[]> que = new LinkedList(); // 얘네 좌표를 담을 수 있는 큐 만들기

		que.add(new int[] { x, y }); // 첫 번째 지점 넣기
		visited[x][y] = true;
		
		int count = 0; // 집 수 세기
		while (!que.isEmpty()) {

			int[] tmp = que.poll();
			int i = tmp[0];
			int j = tmp[1];

			count++; // 집 수 추가하기

			for (int d = 0; d < 4; d++) {
				int nr = i + dr[d];
				int nc = j + dc[d];

				// 범위에서 벗어나면 걔는 따지지 말기
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] == 0)
					continue;

				que.add(new int[] { nr, nc });
				visited[nr][nc] = true; // 방문 처리 표시
			}

		}
		return count;
	}
}
