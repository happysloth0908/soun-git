package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Beakjoon_10814_나이순정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<Integer, String> member = new TreeMap<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			member.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			System.out.println(member.get .getKey() + " " + member.pollFirstEntry().getValue());
		}
	}
}
