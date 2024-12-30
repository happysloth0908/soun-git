package test;

public class BinarySearch_몇순위가되고싶다 {
	static int arr[] = { 225, 220, 160, 160, 160, 100 };
	
	static void bs(int target) {
		int left = 0;
		int right = arr.length - 1;
		// 사실 ans 는 left 나 right 에 저장되는데 그렇게 출력하면 넘 헷갈림. 
		int ans = -1;
		
		while(left <= right) {
			int mid = (left + right) /2;
			
//			if (arr[target] == arr[mid]); 이건 할 필요가 없음. arr 안에 해당 점수가 있는지 판별
			
			// 1. 현재 원하는 등수의 점수와 동일한 것들 중 가장 왼쪽 인덱스
			// 2. 역순 정렬이 되어 있다. 
			//		-부등호 방향, left right 이동 방향 조심 
			
			if(arr[target] >= arr[mid]) {
				right = mid - 1; // 역순 정렬이라 left 가 아닌 right
				ans = mid;
			} else {
				left = mid + 1; 
//				ans = mid; 왜 여기는 안 하지? 같은 점수일 때 왼쪽 부분을 확인해야 하니까
			}
		}
		System.out.println((target + 1) + "등 = " + arr[ans] + "~" + (arr[ans - 1] - 1) + "점");
	}
	
	
	public static void main(String[] args) {
		for (int target = 2; target <= 6; target++) {
			bs(target -1);
		}
	}
}
