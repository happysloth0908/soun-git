/*
 *  규 : 4 - 08:09.06
 * 	소 : 5 - 08:14.72
 * 	동 : 2 - 11:17.07
 *  욱 : 1 - 11:48.11
 *  신 : 3 - 15:14.51
 *  정 : 6 - 09:23.11
 */

import java.util.Arrays;

public class 오늘의할일 {
	static int[] arr = { 19, 2, 72, 44, 50 };
	static int N = arr.length;
	static int[] temp = new int[N];
	
	public static void main(String[] args) {
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int left, int right) {
		// TODO Auto-generated method stub
		
		if(left < right) {
			int mid= (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {
		// TODO Auto-generated method stub
		int L = left;
		int R = mid + 1;
		int idx = left;
		while(L <= mid && R <= right) 
		{
			if(arr[L] < arr[R]) {
				temp[idx++] = arr[L++];
			} else {
				temp[idx++] = arr[R++];
			}
		}
		if(L <= mid) {
			for (int i = L; i <= mid; i++) {
				temp[idx++]= arr[i];
			}
		}
		else {
			for (int i = R; i <= right; i++) {
				temp[idx++]= arr[i];
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
	}



}
