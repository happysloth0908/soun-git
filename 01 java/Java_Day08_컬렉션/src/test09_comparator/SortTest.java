package test09_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		// 정렬
		// - 순서가 있는 자료구조: List
		
		List<Person> persons = new ArrayList<>();
		
		persons.add(new Person("daisy", 3));
		persons.add(new Person("luna", 3));
		persons.add(new Person("max", 3));
		persons.add(new Person("alice", 2));
		
		System.out.println(persons);
		
		// 정렬
		// Collections 유틸리티 클래스의
		// sort() 메서드 사용
		
		Collections.sort(persons, new PersonComparator()); 
		// 사용자 정의클래스를 사용한 리스트는 기본적으로 정렬할 수 없음!
		// Comparable 인터페이스 구현 or 사용자 정의 Comparator 클래스를 정의(Comparator 인터페이스를 구현해서)
		// - 비교 기준이 없으므로 사용자 정의 클래스에 비교 기준을 만들어준다.
		
		// 문자 => 정수로 표현(0~65535)
		System.out.println(persons);
		// 만약 숫자의 리스트였다면 수의 크기의 오름차순으로 정렬.
		
		
		
	}
}
