package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon_1032_명령프롬프트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String arr [] = new String [N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
//		System.out.println("문자열 길이는 " + arr[2].length());
//		System.out.println(Arrays.toString(arr));
//		StringBuilder sb = new StringBuilder();
		String ans = arr[0];
		for (int i = 0; i < arr[0].length(); i++) {
//			System.out.println("1: " +  i + "번째 글씨 비교 시작");
			for (int j = 1; j < N; j++) {
//				System.out.println("2: " + j + "번째 문자열 검사");
				if( ans.charAt(i) != arr[j].charAt(i)) {
//					System.out.println("3: " + i + "번째 글씨가 다르다!!");
//					System.out.println("4: " + ans.charAt(i) + "를 ?로 바꾼다!");
//					ans = ans.replace(ans.charAt(i), '?'); // 이렇게 하면 다 교체해버림
					ans = ans.substring(0, i) + "?" + ans.substring(i+ 1);
//					System.out.println("5: " + "그럼 현재 ans 는 " + ans);
					break;
				}
			}
//			sb.append(arr[j].charAt(i));
			
		}
		System.out.println(ans);
	}
}
