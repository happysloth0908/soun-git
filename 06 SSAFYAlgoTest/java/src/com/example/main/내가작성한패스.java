package com.example.main;

import com.example.libraries.Bridge;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class 내가작성한패스 {
	private static String NICKNAME = "대전_4반_김소운";

	public static void main(String[] args) {
		Bridge bridge = new Bridge();
		String gameData = bridge.init(NICKNAME);
		
		System.out.println("----------");
		System.out.println(gameData);
		System.out.println(gameData.replaceAll("[/n]", ""));
		System.out.println("----------");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			if(gameData.length() == 0) break;
			bridge.submit(sc.next());
			System.out.println(gameData);
		}

		bridge.close();
	}
}
 