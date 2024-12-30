package test;

import java.util.Arrays;

public class ParametricSearch_츄러스 {
	static int churros[] = {50, 30, 40}; 
	static int person_cnt = 5;
	
	
	
	
	public static void main(String[] args) {
		System.out.println(ps());
	}



	private static int ps() {
		int left = 0; // 1이어도 상관 x
		int right = Arrays.stream(churros).max().getAsInt();
		int ans = -1;
		
		while(left <= right) {
			int mid = (left + right) /2;
			
			if(test(mid)) {
				left = mid + 1;
				ans = mid;
			}else {
				right = mid - 1;
			}
		}
		return ans;
	}



	private static boolean test(int mid) {
		int cnt = 0;
		for (int i = 0; i < churros.length; i++) {
			cnt += churros[i] / mid;
		}
		if(cnt >= person_cnt) return true;
		return false;
	}
}
