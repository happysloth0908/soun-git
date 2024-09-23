package test08_comparable;


// 사용자 정의 클래스가 정렬되기 위해서는
// 비교 기준이 필요
// 1. Comparable 인터페이스 구현
//   -> 제네릭: 타입 매개변수에 비교하고자 하는 클래스 타입을 집어넣어준다.

public class Person implements Comparable<Person>{
	String name;
	int age;
		
	@Override
	public int hashCode() {
		// 일반적으로 String은 같은 문자열에 대해서 같은 해시코드가 나온다.
		// => name의 해시코드만 사용해서 구별하자.
		return name.hashCode();
	}

	// 매개변수와 같으면 true, 아니면 false
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) { // 비교하고자 하는 obj가 Person 타입이라면
			Person p = (Person) obj;
			return this.age == p.age;
		}
		// Person이 아니라면
		return false; // 다르다!
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// add unimplemented methods..
	//
	@Override
	public int compareTo(Person o) {
		// 1. 나이
		// 나이를 기준으로 비교해보자.
//		return o.age - this.age; // 나 자신과, 비교대상의 나이를 순서대로 뺐더니 => 오름차순 정렬.
		                         // 비교대상 - 나 => 내림차순 정렬.
		
		// 2. 이름?
//		return this.name.compareTo(o.name); // String에 정의되어 있는 비교 메서드를 사용한다.
		
		// 1. 기본적으로는 나이 순으로 // 나이가 같다면 이름순으로?
		if (this.age == o.age) {
			return this.name.compareTo(o.name) * -1; // 부호를 바꿔주면 역순이 된다.
		}
		return this.age- o.age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
