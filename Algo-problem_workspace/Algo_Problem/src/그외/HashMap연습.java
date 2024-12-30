package 그외;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HashMap연습 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> visiter = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			if(!visiter.containsKey(name)) {
				visiter.put(name, 0);
			}
			visiter.put(name, visiter.get(name) + 1);
			
		}
		String name = br.readLine();
		if(visiter.containsKey(name)) {
			System.out.println(visiter.get(name));
		}else {
			System.out.println("그런 방문자는 없습니다. ");
		}
	}
}
