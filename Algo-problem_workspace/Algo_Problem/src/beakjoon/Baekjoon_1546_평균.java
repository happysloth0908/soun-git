package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1546_평균 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> grades = new PriorityQueue<>((a,b) -> b-a);
		for (int i = 0; i < n; i++) {
			grades.add(Integer.parseInt(st.nextToken()));
		}
		double max = grades.peek();
		System.out.println("max는" + max);
		double sum = 0;
		for (int i = 0; i < n; i++) {
			int curr = grades.poll();
			System.out.println("curr는 " + curr);
			System.out.println("sum에 더할 값은:" + curr / max * 100);
			sum += curr / max * 100;
		}
		System.out.println(sum / n);
	}
}
