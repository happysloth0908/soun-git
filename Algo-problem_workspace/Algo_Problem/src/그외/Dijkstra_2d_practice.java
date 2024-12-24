package 그외;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_2d_practice {
	static class Node {
		int x;
		int y;
		int price;
		
		public Node(int x ,int y, int price) {
			this.x = x;
			this.y = y;
			this.price = price;
		}
	}
	
	static int[][] maze = {
		    {0, 3, 5, 2},
		    {-1, -1, 1, -1},
		    {2, 4, 3, 2},
		    {6, -1, -1, 1},
		    {0, 1, 2, 1}
		};
	
	public static void main(String[] args) {
		Dijkstra();
	}

	private static void Dijkstra() {
		int[][] dist = new int[5][4];
		for(int i = 0; i < 5; i++) {
		    for(int j = 0; j < 4; j++) {
		        dist[i][j] = Integer.MAX_VALUE;
		    }
		}
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.price - b.price);
		int dirY[] = {1, -1, 0, 0};
		int dirX[] = {0, 0, -1, 1};
		
		pq.add(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
//			System.out.println(now.y+ " " + now.x + " " + now.price);
			
			//더미 제거
			if(now.price > dist[now.y][now.x]) continue;
			
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dirY[i];
				int nx = now.x + dirX[i];
				
				if(ny < 0 || nx < 0 || ny >= 5 || nx >= 4) continue;
				if(maze[ny][nx] == -1) continue; //벽인 경우
				
				if(dist[ny][nx] > now.price + maze[ny][nx]) {
					dist[ny][nx] = now.price + maze[ny][nx];
					pq.add(new Node(nx, ny, dist[ny][nx]));
				}
				
				
			}
		
		}
		
		System.out.println(dist[4][0]);
		
	}
}
