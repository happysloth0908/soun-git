package 그외;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Node2 implements Comparable<Node2>{
    int n;
    int price;

    public Node2(int n, int price) {
        this.n = n;
        this.price = price;
    }

    @Override
    public int compareTo(Node2 other) {
        return Integer.compare(this.price, other.price);
    }
}

public class DikstraPractice_Mina {
    static ArrayList<Node2>[] alist = new ArrayList[5];
    static PriorityQueue<Node2> pq = new PriorityQueue<>();
    static int[] best = {0, 999, 999, 999};

    static void solution() {

        // 초기화 방법 1
        for (int i = 0; i < 4; i++) {
            alist[i] = new ArrayList<>();
        }

        // 노드 추가
        alist[0].add(new Node2(1, 10));
        alist[0].add(new Node2(2, 30));

        alist[1].add(new Node2(2, 10));
        alist[1].add(new Node2(3, 40));

        alist[2].add(new Node2(3, 50));

        // 초기화 방법 2
//        alist[0] = new ArrayList<>(Arrays.asList(new Node2(1, 10), new Node2(2, 30)));
//        alist[1] = new ArrayList<>(Arrays.asList(new Node2(2, 10), new Node2(3, 40)));
//        alist[2] = new ArrayList<>(Arrays.asList(new Node2(3, 50)));
//        alist[3] = new ArrayList<>();

        pq.add(new Node2(0, 0));

        while (!pq.isEmpty()) {
            Node2 now = pq.poll();

            // Dummy 값인지 확인
            if (now.price > best[now.n]) continue;

            // 다음 갈 수 있는 노드 중, best 갱신 가능시, 갱신 후 pq에 추가
            for (Node2 next : alist[now.n]) {
                if (best[next.n] > now.price + next.price) {
                    best[next.n] = now.price + next.price;
                    pq.add(new Node2(next.n, best[next.n]));
                }
            }
        }

    }

    public static void main(String[] args) {
        solution();

        for (int i = 0; i < 4; i++) {
            System.out.print(best[i] + " ");
        }
    }
}
