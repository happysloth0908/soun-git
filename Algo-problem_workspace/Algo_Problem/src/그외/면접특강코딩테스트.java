package 그외;

import java.util.Scanner;

public class 면접특강코딩테스트 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		String str = "abc";
		System.out.println(myPad(str));
	}

	private static String myPad(String str) {
		str += "          ";
		return str.substring(0, 10);
	}
	
}
