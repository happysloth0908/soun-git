package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 네트워크연결_1922 {

	public static class Edge implements Comparable<Edge>{
	int a;
	int b;
	int w; // 연결하는데 드는 비용
	
	public Edge(int a, int b, int w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public String toString() {
		return "Edge [a=" + a + ", b=" + b + ", w=" + w + "]";
	}
	
	public int compareTo(Edge o) {
		return this.w - o.w;
	}

}
	
	static int N;
	static int M;
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int ans = 0; //답
		
		Edge[] edges = new Edge[M]; //간선 개수만큼 담을 수 있는 배열 만들기
		
		for (int i = 0; i < M; i++) {
			//에지를 담을 수 있는 배열에 에지 담기
			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(edges); // 순서대로 나열하기
				
		// 누가 부모인지 표시해주는 배열 p
		// 근데 입력 보니까 지점이 1부터 시작함. 
		// 그래서 0은 무시되니까 1칸 더 늘려줘야 outofbounds가 안 뜸
		p = new int[N + 1]; 
		for (int i = 0; i < N + 1; i++) {
			p[i] = i; // 일단 시작은 모두 자기가 자신의 부모임. 
		}
		
		//// ---- 준비는 마쳤다. -----
		
		for (int i = 0; i < M; i++) { // 가중치 제일 작은 간선부터 쭉 해보기
			// 간선의 양 끝에 있는 지점을 확인해서 이미 트리에 없으면 부모 바꿔주기 작업 시작
			int aP = findSet(edges[i].a); // 부모 찾기
			int bP = findSet(edges[i].b); // 부모 찾기
			
			if(aP != bP) {
				union(aP, bP); // 부모 다르면 합쳐버려
				ans += edges[i].w; // 그리고 간선 가중치 더하기!
			}
			
		}
		System.out.println(ans);
		
	}
	//부모 찾기 메서드
	private static int findSet(int a) { 
		if (p[a] == a) return a; // 부모 == 자신이면 자기값 내보내기
		else {
			return p[a] = findSet(p[a]);
		}
	}
	
	// 부모 다른 애들끼리 합쳐서 부모 똑같게 만들기 메서드
	private static void union(int aP, int bP) {
		// 부모 바꿔주기! 어차피 findSet으로 이미 다 대장만 골라옴. 
		//대장을 바꿔버리면 나중에 붙어 있던 애들도 다 바뀌게 되어 있음. 
		p[bP] = aP; 
	}
	
	
}
