package com.example.main;

import java.util.Scanner;

import com.example.libraries.Bridge;

public class pass {
	private static String NIKENAME = "패스패스";

	public static void main(String[] args) {
		Bridge bridge = new Bridge();

		String gameData = bridge.init(NIKENAME);
		//
		System.out.println("----------------");
		System.out.println(gameData);
		System.out.println(gameData.replaceAll("[ \n]", ""));
		System.out.println("----------------");
		//

		Scanner sc = new Scanner(System.in);
		while (true) {
			if (gameData.length() == 0)
				break;

			gameData = bridge.submit(sc.next());
			System.out.println(gameData);
		}
		bridge.close();
	}

}