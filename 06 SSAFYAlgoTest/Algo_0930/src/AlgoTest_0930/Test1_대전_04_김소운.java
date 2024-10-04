package AlgoTest_0930;

import java.util.Scanner;

public class Test1_대전_04_김소운 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int H = sc.nextInt();
			proCount = 0;
			
			// 1만으로 이루어진 경우 있으니까 나중에 +1 해줌. 
			
			
//			int count = 0;

			int four = 0; // 4의 개수
			while(4*four <= H) { // 4의 개수를 1씩 늘려감. 
				
				int nH = H - 4*four; 
				
				int one = 0;
				int three = 0; // 3의 개수 
				while (3*three <= nH) { // 3의 개수를 1씩 늘려감. 
					one = H - four*4 - three*3; // 4와 3을 뺀 나머지 값은 전부 1로 
//					System.out.println(four + "," + three + "," + one);
					경우의수구하기(four, three, one); 
					three++;

					
				}
				
				four++;

			}
			
			
			System.out.println("#" + t + " " + proCount);
			
			
			
		}

	}
	static int proCount = 0;

	private static void 경우의수구하기(int four, int three, int one) {
		int to = four + three + one;
		int a = 0;
		int total = 1;
		int totalF = 1;
		int totalT = 1;
		int totalO = 1;
		while(to - a > 0) {
			total *= to - a; 
			a++;
		}
		System.out.println(total);
		int b = 0;
		while(four - b > 0) {
			totalF *= four - b; 
			b++;
		}
//		System.out.println(totalF);
		b = 0;
		while(three - b > 0) {
			totalT *= three - b; 
			b++;
		}
//		System.out.println(totalT);
		b = 0;
		while(one - b > 0) {
			totalO *= one - b; 
			b++;
		}
//		System.out.println(totalO);
		
		if(totalT == 0 ) totalT = 1;
		if(totalF == 0 ) totalF = 1;
		if(totalO == 0 ) totalO = 1;
		
		if(four == 0 && three == 0 && one == 0) {
		    // 이 경우를 특별히 처리
		    return;
		}
		
		proCount += total / (totalT * totalF * totalO);
//		System.out.println(proCount);
		
	}

}
