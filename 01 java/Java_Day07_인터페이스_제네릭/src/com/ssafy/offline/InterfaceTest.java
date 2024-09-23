package com.ssafy.offline;

import java.util.LinkedList;
import java.util.List;

class WebServer implements Server {
	@Override
	public void start() {
		System.out.println("서버를 구동합니다.");
	}
	@Override
	public void stop() {
		System.out.println("서버를 중지합니다.");
	}
	@Override
	public void restart() {
		System.out.println("서버를 재구동합니다.");		
	}
}
class MobileServer implements Server {
	@Override
	public void start() {
		System.out.println("서버를 구동합니다.");
	}
	@Override
	public void stop() {
		System.out.println("서버를 중지합니다.");
	}
	@Override
	public void restart() {
		System.out.println("서버를 재구동합니다.");		
	}
}
public class InterfaceTest {
	public static void main(String[] args) {
//		Server s = new Server();
//		Server s = new WebServer();
		System.out.println(Server.PORT);
		// The final field Server.PORT cannot be assigned
//		Server.PORT = 100;
		Server s = new MobileServer();
		s.start();
		s.restart();
		s.stop();
		
		List<String> list = new LinkedList<>();
		list.add("1번");
		list.add("2번");
		list.add("3번");
		System.out.println(list.size());
		System.out.println(list.isEmpty() ? "리스트는 비어 있음" : "리스트는 비어 있지 않다.");
	}
}









