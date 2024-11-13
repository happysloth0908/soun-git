package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SWEA_5648_원자소멸 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
//			int[][] map = new int[2202][2202];
			// 배열 담기
			List<int[]> dotList = new ArrayList<>();
			int[] dx = { 0, 0, -1, 1 };
			int[] dy = { 1, -1, 0, 0 };

			int energy = 0; // 에너지 총량

			int N = sc.nextInt(); // 점 개수
			int dotLeft = N; // 남은 점 수 
			int worstcase = 4000;
			
			for (int i = 0; i < N; i++) {
//				int a = sc.nextInt();
//				int b = sc.nextInt();
//				int c = sc.nextInt();
//				int d = sc.nextInt();
				int colided = 0; // 부딧히면 1이 됨. 
				dotList.add(new int[] { sc.nextInt()*2, sc.nextInt()*2 , sc.nextInt(), sc.nextInt(), 0 });
			}

			// ---확인용 코드
//			for (int i = 0; i < dotList.size(); i++) {
//				System.out.println(Arrays.toString(dotList.get(i)));
//			}
			// ---확인용 코드

			while (N > 0 && worstcase > 0) {
				worstcase--;
				// 부딪힌 애들 계산하고 빼주기
				for (int i = 0; i < dotList.size(); i++) {
//					System.out.println("부딧힌 애들 계산하자:" + dotList.size());
					int[] curr = dotList.get(i);
					if(curr[4] == 1) continue; // 부딧힌 애니까 넘기기
					
					boolean colide = false; // curr의 부딧힘 여부
					int x = curr[0];
					int y = curr[1];
					int d = curr[2];
					
					for (int j = 0; j < dotList.size(); j++) {
						int[] compare = dotList.get(j);
						if(compare[4] == 1) continue; // 부딧힌 애니까 넘기기
						
						
						// 같은 애가 아니고, x랑 y 좌표가 같거나 /
						if ((i != j && x == compare[0] && y == compare[1])
								// 마주보고 있으면서 한 칸 차이나면
								/* || x + dx[d] == compare[0] && y + dy[d] == compare[1] */) {
							System.out.println(Arrays.toString(compare) + "가 curr와 부딧힘, "+ compare[3]+ "만큼 더해줄거임. ");
							energy += compare[3];
//							dotList.remove(j); // 부딪힌 애들은 빼주기
							compare[4] = 1; // 부딧힘 처리하기
							dotLeft--;
							colide = true;		// curr 의 부딪힘 여부 true 로 정하기
							
						}
					}
					if(colide) {
		//				System.out.println(curr[3] + "만큼 더해줄거임. ");
						energy += curr[3];
//							dotList.remove(i); // 부딪힌게 맞다면 curr 빼주기
						curr[4] = 1; // 부딧힘 표시
						dotLeft--;
					}
				}

				// 에너지 다 쓴 애들은 빼주기 // 가다가 힘이 빠지지 않음..!
//				for (int i = 0; i < dotList.size(); i++) {
////					System.out.println("에너지 다 쓴 애들 계산하자:" + dotList.size());
//					int[] curr = dotList.get(i);
//					if(curr[4] == 1) continue;
//					
//					if (curr[3] <= 0) {
//						System.out.println(Arrays.toString(curr) + "힘 다 빠짐.");
//						curr[4] = 1; // 빠짐 표시
//						dotLeft--;
////						dotList.remove(i);
//						System.out.println("빠지고 남은 수 " + dotList.size());
//						continue;
//					}
//				}
				// 한 칸씩 움직여주기
				for (int i = 0; i < dotList.size(); i++) {
//					System.out.println("남은 애들 옮겨주자:" + dotList.size());
					int[] curr = dotList.get(i);
					curr[0] += dx[curr[2]];
					curr[1] += dy[curr[2]];
				}

			}

			System.out.println("#" + t + " " +  energy);

		}

	}
}
