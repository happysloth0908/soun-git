package test;

public class ParametricSearch_자동차연료게이지1 {
	static String guage = "#######___";
	
	static int ps(String guage){
		int left = 0;
		int right = guage.length() - 1;
		int ans = -1;
		
		while(left <= right) {
			int mid = (left + right) /2;
			
			if(guage.charAt(mid) == '#') {
				left = mid + 1;
				ans = mid;
			}else {
				right = mid - 1;
			}
		}
		return ans + 1;
	}
	
	
	public static void main(String[] args) {
		int ans = ps(guage);
		System.out.println((ans)*100 /guage.length() + "%");
	}
}
