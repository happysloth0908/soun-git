package AlgoTest_0930;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test02_대전_04_김소운 {
	public static int N;
	public static int M;
	public static char[][] board;
	public static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 높이
			M = sc.nextInt(); // 너비
			
			board = new char[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				String tmp = sc.next(); // 한줄식 받기
				
				for (int j = 0; j < M; j++) {
					 board[i][j] = tmp.charAt(j);
				}
			}	
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(board[i][j]);
//				}
//				System.out.println();
//			}
			
			// 입력 완료 ----------
			
			int cntW = 0;
			int cntB = 0;
			int cntO = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if ( !visited[i][j]) { // 방문 안 한 곳부터 dfs
						DFS(i, j, board[i][j]); // 색도 전달
						 if (board[i][j] == 'W') {
							 cntW++;
						 } else if (board[i][j] == 'B') {
							 cntB++;
						 } else if (board[i][j] == 'O') {
							 cntO++;
					}
					}
				}
			}
			System.out.println("#" + t + " " + cntB + " " + cntO + " " + cntW );
			
			
			
			
			
			
		}
		
	}
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};

	private static void DFS(int x, int y, char color) {
		int cnt = 0;
		Queue<int[]> que = new LinkedList<>(); // char 배열이 들어갈 수 있는 que
		
		visited[x][y] = true; // 방문 처리 해주기
		que.add(new int[] {x,y}); // 첫 점부터 큐에 넣기
		
		while(!que.isEmpty()) { // 큐가 빌 때까지 하기 
			int[] tmp = que.poll();
			int tmpX = tmp[0];
			int tmpY = tmp[1];
			
			for (int d = 0; d < 4; d++) { // 사방탐색
				int nr = tmpX + dr[d];
				int nc = tmpY + dc[d];
				
				// 보드를 넘어가거나 이미 방문한 적 있다면 패스하기
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue; 
				
				if (board[nr][nc] == color) {
					que.add(new int[] {nr,nc}); // 큐에 넣기
					visited[nr][nc] = true; // 방문처리 해주기
					cnt++;
					
				}
				
			}
			
			
		}
		
	}
}
