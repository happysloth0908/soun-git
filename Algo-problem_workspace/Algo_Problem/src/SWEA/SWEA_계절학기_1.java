package SWEA;

import java.util.Scanner;

public class SWEA_계절학기_1 {
	public static void main(String[] args){
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = sc.nextInt();
			int W = sc.nextInt();
			
//			int N = Integer.parseInt(st.nextToken());
//			int W = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];

//			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
//				arr[i] = Integer.parseInt(st.nextToken());
				arr[i] = sc.nextInt();
			}

//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]);
//		}
			int ans = findCombination(N, W, arr);
			System.out.println(ans);
		}

	}

	private static int findCombination(int N, int W, int[] arr) {
		int count = 0;
		// 1부터 N까지의 모든 가능한 조합의 길이에 대해
		for (int r = 1; r <= N; r++) {
			count += combination(0, r, 0, W, arr, new boolean[N]);
		}
		return count;
	}

	// start: 시작 인덱스
	// r: 현재 구하고자 하는 조합의 크기
	// sum: 현재까지의 합
	// S: 목표 합
	// visited: 각 원소의 선택 여부를 표시하는 배열
	private static int combination(int start, int r, int sum, int W, int[] arr, boolean[] visited) {
		// 현재 합이 목표값을 초과하면 더 이상 진행할 필요 없음
		if (sum > W)
			return 0;

		// r개를 모두 선택했을 때
		if (r == 0) {
			// 합이 S와 같으면 1을 반환, 아니면 0을 반환
			return sum == W ? 1 : 0;
		}

		int count = 0;
		// start부터 시작하여 남은 원소들 중에서 선택
		for (int i = start; i < arr.length; i++) {
			visited[i] = true;
			// 현재 원소를 선택하고 다음 원소 선택으로 넘어감
			count += combination(i + 1, r - 1, sum + arr[i], W, arr, visited);
			visited[i] = false;
		}
		return count;
	}
}
