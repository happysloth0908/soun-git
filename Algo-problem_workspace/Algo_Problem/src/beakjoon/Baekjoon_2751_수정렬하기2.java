package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_2751_수정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb);
		
	}
}
		
//		quickSort(arr, 0, arr.length - 1);
//		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < arr.length; i++) {
//			sb.append(arr[i]).append('\n');
//		}
//		System.out.println(sb);
//
//	}
//
//	private static void quickSort(int[] arr, int left, int right) {
//		if(left >= right) return;
//		
//		int part = partition(arr, left, right);
//		
//		quickSort(arr, left, part -1);
//		quickSort(arr,part, right);
//	}
//
//	private static int partition(int[] arr, int left, int right) {
//		int pivot = arr[(left+right)/2];
//		while(left <= right) {
//			while(arr[left] < pivot)left++;
//			while(pivot < arr[right])right--;
//			if(left <= right) {
//				swap(arr, left, right);
//				left++;
//				right--;
//			}
//		}
//		return left;
//	}
//
//	private static void swap(int[] arr, int left, int right) {
//		int tmp = arr[left];
//		arr[left] = arr[right];
//		arr[right] = tmp;
//	}
//}
