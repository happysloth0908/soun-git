package 그외;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
	int n;
	int price;
	
	public Node(int n ,int price) {
		this.n = n;
		this.price = price;
	}
}

public class DikstraPractice {
	ArrayList<Node>[] alist = new ArrayList[5];
	void init() {
        // 초기화 방법 1
        for (int i = 0; i < 4; i++) {
            alist[i] = new ArrayList<>();
        }

        // 노드 추가
        alist[0].add(new Node(1, 10));
        alist[0].add(new Node(2, 30));

        alist[1].add(new Node(2, 10));
        alist[1].add(new Node(3, 40));

        alist[2].add(new Node(3, 50));

        // 초기화 방법 2
//        alist[0] = new ArrayList<>(Arrays.asList(new Node2(1, 10), new Node2(2, 30)));
//        alist[1] = new ArrayList<>(Arrays.asList(new Node2(2, 10), new Node2(3, 40)));
//        alist[2] = new ArrayList<>(Arrays.asList(new Node2(3, 50)));
//        alist[3] = new ArrayList<>();

	}
	
	void solution() {
		init();
		dijkstra();
	}
	
	public static void main(String[] args) {
		new DikstraPractice().solution();
	}
	
	void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.price - b.price);
		int[] dist = new int[4];
		Arrays.fill(dist,  Integer.MAX_VALUE);
		
		dist[0] = 0;
		pq.add(new Node(0,0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dist[now.n] < now.price) continue;
			
			for(Node next : alist[now.n]) {
				int cost = dist[now.n] + next.price;
				
				if(cost < dist[next.n]) {
					dist[next.n] = cost;
					pq.add(new Node(next.n, cost));
				}
			}
		}

		System.out.println(Arrays.toString(dist));
	}
	
}
