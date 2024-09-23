package com.ssafy.offline;

import java.io.FileReader;

class MyClose implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("MyClose close()");
	}
}
public class ExceptionTest01 {
	public static void main(String[] args) {
		// The resource type MyClose does not implement java.lang.AutoCloseable
		System.out.println(1);
		try (MyClose mc = new MyClose()) {
			System.out.println(2);
		} catch (Exception e) {
			System.out.println(3);
		} 
		MyClose mc = null;
		try {
			System.out.println(2);
			mc = new MyClose();
		} catch (Exception e) {
			System.out.println(3);
		} finally {
			try {
				mc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(4);
	}
}
