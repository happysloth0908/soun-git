package test06_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
	public static void main(String[] args) {
		// Deque
		// - Deque: 인터페이스
		// - 구현체: ArrayDeque, LinkedList
		// - 양쪽 끝에서 자유롭게 자료의 추가, 삭제 가능
		
		// 객체배열관리 실습 : array <= 실제로 배열을 가지고 리스트를 만들어 본 것임
		// 중간에 삭제, 중간에 추가...
		// 중간에서 삭제 추가가 빈번하게 일어나는 상황
		// array : 조회는 빠르다. 
		
		// LinkedList: 조회는 느리다. 삭제&추가는 빠름.
		
		
		Deque<String> deque = new ArrayDeque<>();
		
		deque.addFirst("alice");
		deque.addFirst("luna");
		deque.addLast("max");
		deque.addFirst("daisy");
		
		System.out.println(deque);
		
		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
		System.out.println(deque.removeFirst());
		System.out.println(deque.removeFirst());
		
		
	}
}
