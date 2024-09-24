package com.ssafy.dto;

import java.io.Serializable;
import java.util.Arrays;

public class Person implements Serializable{
	// 직렬화를 해야 한다. 
	private static final long serialVersionUID = 1L; //UID로 버전 확인, 리터 아니고 L은 long 임.  
	
	private String name;
	private int age;
	private String gender;
	private String[] hobbies;

	//기본 생성자를 만들어야 한다. 
	public Person() {
	}

	public Person(String name, int age, String gender, String[] hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.hobbies = hobbies;
	}

	// getter setter 를 사용해서 접근할 수 있어야 한다. 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", hobbies=" + Arrays.toString(hobbies)
				+ "]";
	}
}
