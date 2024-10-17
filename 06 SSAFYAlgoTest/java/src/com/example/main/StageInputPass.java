package com.example.main;
import java.io.IOException;
import java.util.Scanner;

import com.example.libraries.Bridge;

public class StageInputPass {
	/** 닉네임을 사용자에 맞게 변경해 주세요(공백 불가) */
	private static String NICKNAME = "무적_싸피청년";
	
    public static void main(String[] args) throws IOException {
        Bridge bridge = new Bridge();
        String gameData = bridge.init(NICKNAME);
        System.out.println("----------------");
        System.out.println(gameData);
        System.out.println(gameData.replaceAll("[ \n]", ""));
        System.out.println("----------------");
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (gameData.length() == 0) break;

            gameData = bridge.submit(sc.next());
            System.out.println(gameData);
        }
        bridge.close();
    }
}

