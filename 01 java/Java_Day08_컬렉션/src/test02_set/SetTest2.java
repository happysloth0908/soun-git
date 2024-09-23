package test02_set;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {
	public static void main(String[] args) {
		
		Set<Person> set = new HashSet<>();
		
		set.add(new Person("luna", 3));
		set.add(new Person("luna", 3));
		
		
		// set에는 한 사람? 아니면 두 사람?
		// set이 같다고 판단하는 기준: hashcode가 같으면서 equals 값도 같아야함.
		System.out.println(set);
		
		// 사용자 정의 클래스를 사용하는 경우
		// Set을 사용하기 위해서는 hashCode(), equals()메서드를 오버라이드 해줘야 한다.
	}

}
