package 그외;

public class 피보나치연습 {
	static int memo[] = new int[1000000];
	
	public static void main(String[] args) {
		int ans = get_fibo(45);
		System.out.println(ans);
	}

	private static int get_fibo(int i) {
		
		//가드절
		if(i == 0) return 0;
		if(i == 1) return 1;
		
		//이미 계산한 내용이 있으면 불러오기
		if(memo[i] != 0) {
			return memo[i];
		}
		
		int b = get_fibo(i-1);
		int a = get_fibo(i-2);
		int sum = a + b;
		memo[i] = sum;
		return sum;
	}
}
