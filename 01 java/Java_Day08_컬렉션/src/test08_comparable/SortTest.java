package test08_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
	static class Idol implements Comparable<Idol> {
		String name;
		int age;
		int fanCount;
		public Idol(String name, int age, int fanCount) {
			this.name = name;
			this.age = age;
			this.fanCount = fanCount;
		}
		@Override
		public String toString() {
			return "Idol [name=" + name + ", age=" + age + ", fanCount=" + fanCount + "]";
		}
		// 나이순으로 정렬
		// 만약, 나이가 같으면 이름의 역순으로 정렬
		public int compareTo(Idol other) {
			if ((this.age - other.age) != 0) {
				return this.age - other.age;
			}
			return this.name.compareTo(other.name) * -1;
		}
	}
	
	static class IdolComparator implements Comparator<Idol> {
		@Override
		public int compare(Idol o1, Idol o2) {
			return o1.fanCount - o2.fanCount;
		}
	}
	
	public static void main(String[] args) {
		List<Idol> list = new ArrayList<>();
		list.add(new Idol("카리나", 24, 100));
		list.add(new Idol("윈터", 27, 70));
		list.add(new Idol("장욱", 27, 1000));
		list.add(new Idol("진종수", 30, 1000));
		Collections.sort(list, new IdolComparator());
		System.out.println(list);
		
		
		// Comparable 인터페이스 타입이어야 한다.
//		Collections.sort(list);
//		System.out.println(list);
		
		
		/*
		List<Integer> sList1 = new ArrayList<>();
		sList1.add(10);
		sList1.add(20);
		sList1.add(30);
		sList1.add(15);
		
		Collections.sort(sList1);
		
		System.out.println(sList1);
		
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
		
		Collections.sort(persons); 
		// 사용자 정의클래스를 사용한 리스트는 기본적으로 정렬할 수 없음!
		// Comparable 인터페이스 구현 or Comparator 클래스를 정의
		// - 비교 기준이 없으므로 사용자 정의 클래스에 비교 기준을 만들어준다.
		
		// 문자 => 정수로 표현(0~65535)
		System.out.println(persons);
		// 만약 숫자의 리스트였다면 수의 크기의 오름차순으로 정렬.
		*/
	}
}
