package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[st.countTokens()];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		long count = 0;
		for (int i = 0; i < N; i++) {
			count++; // 한 반에 총감독 최소 1명은 들어가기 때문에 
			double leftPeople = arr[i] - A; // B 와 나눠 줄 때 둘 중 하나가 실수여야 실수로 답이 나와서 올림이 가능하다. 
//			System.out.println("leftPeople 는 " + leftPeople);
			if (leftPeople <= 0) { // leftPeople 이 음수일 때도 생각해줘야 함. 
				continue;
			}
//			System.out.println("더 필요한 감독관은" + (int) Math.ceil(leftPeople / B)); // ceil 소수점 뒤에 1이상의 숫자가 있으면 올림
			count += (leftPeople + B - 1 ) / B; // long 타입에 넣어서 자동으로 정수형으로 변환
//			B를 더하면: "한 사람이 더 필요할까?" 를 확인하는 거
//			1을 빼는 건: "앗, 딱 맞게 나누어떨어질 때는 한 명 더 필요없어!" 라고 알려주는 거
		}
		System.out.println(count);

	}
}
