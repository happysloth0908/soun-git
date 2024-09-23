package com.ssafy.offline;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOTest01 {
	public static void main(String[] args) {
		try (
			FileInputStream fis = new FileInputStream("data/dog.jpg");
			BufferedInputStream bis = new BufferedInputStream(fis); 	
				
			FileOutputStream fos = new FileOutputStream("data/dog2.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(fos);	
		) {
			while (true) {
				int ch = bis.read();
				if (ch == -1) break;
				bos.write(ch);
			}
			System.out.println("복사 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





