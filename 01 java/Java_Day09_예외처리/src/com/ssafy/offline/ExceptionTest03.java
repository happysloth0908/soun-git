package com.ssafy.offline;

import java.util.Scanner;

class InvalidRangeExcpetion extends RuntimeException {
//class InvalidRangeExcpetion extends Exception {
//class MyException2 extends Exception {
	
}

public class ExceptionTest03 {
	static void process() throws InvalidRangeExcpetion {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1 ~ 3 사이의 숫자를 입력 : ");
		int num = sc.nextInt();
			if (num < 1 || num > 3) {
				throw new InvalidRangeExcpetion();
			}
	}
	
	
	public static void main(String[] args) {
		try {
			process();
		} catch (InvalidRangeExcpetion e) {
			e.printStackTrace();
		}
	}
}
