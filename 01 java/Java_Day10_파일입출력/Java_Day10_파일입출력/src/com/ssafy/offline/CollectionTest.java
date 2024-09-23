package com.ssafy.offline;

import java.util.ArrayList;
import java.util.List;

class Student {
	private int no;
	private String name;
	private String region;
	public Student() {
	}
	public Student(int no, String name, String region) {
		this.no = no;
		this.name = name;
		this.region = region;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", region=" + region + "]";
	}
}
interface IStudentManager {
	void add(Student student);

	void delete(int i);

	void modify(int no, String region);
}
class StudentManagerImpl implements IStudentManager {
	private StudentManagerImpl() {}
	private static IStudentManager instance = new StudentManagerImpl();
	public static IStudentManager getInstance() {
		return instance;
	}
	private List<Student> students = new ArrayList<>();
	@Override
	public void add(Student student) {
		students.add(student);
	}
	@Override
	public void delete(int no) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getNo() == no) {
				students.remove(i);
				break;
			}
		}
	}
	@Override
	public void modify(int no, String region) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getNo() == no) {
				students.get(i).setRegion(region);
				break;
			}
		}
	}
	
	
}
public class CollectionTest {
	public static void main(String[] args) {
		IStudentManager sm = StudentManagerImpl.getInstance();
		sm.add(new Student(1, "hong", "대전"));
		sm.add(new Student(2, "kang", "대전"));
		sm.add(new Student(3, "kim", "서울"));
		sm.add(new Student(4, "lee", "구미"));
		
		sm.delete(3);

		sm.modify(2, "제주");
	}
}




















