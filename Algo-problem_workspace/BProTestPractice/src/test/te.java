package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class te {
	public static void main(String[] args) {
		Deque<String> deq = new ArrayDeque<>();
		deq.push("AA");
//		System.out.println(deq.pop());
		
		deq.add("BB");
		String a = deq.getFirst();
		System.out.println(a);
//		deq.remove();
		deq.addFirst("cc");
		System.out.println(deq.poll());
		
	}
}
