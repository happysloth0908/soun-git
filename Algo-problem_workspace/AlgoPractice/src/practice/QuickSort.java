package practice;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = { 0, 100, 4, 3, 2, 8, 1, 9, 20, 22 };
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int left, int right) {
		int part = partition(arr, left, right);
		if(left < part - 1) {
			quickSort(arr, left, part - 1);
		}
		if(right > part) {
			quickSort(arr, part, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		while (left <= right) {
			while (arr[left] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}

}
