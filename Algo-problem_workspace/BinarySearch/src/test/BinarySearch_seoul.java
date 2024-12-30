package test;

public class BinarySearch_seoul {
	static int winners []= { 100, 200, 201, 204, 208, 304, 305 };
	
	static int bs(int a){
		int left = 0;
		int right = winners.length - 1;
		
		while (left <= right ) {
			int mid = (left + right) / 2;
			
			if(a == winners[mid]) return 1;
			
			if(a > winners[mid]) left = mid +1;
			else right = mid -1;
		}
		
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		int friends [] = {207, 200, 100};
		
		int cnt = 0;
		for (int i = 0; i < friends.length; i++) {
			if (bs(friends[i]) == 1) cnt ++;
		}

		System.out.println(cnt);
	}
}
