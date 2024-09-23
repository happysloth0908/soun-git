package com.ssafy.offline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Car implements Comparable<Car> {
	String name;
	int price;
	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "car [name=" + name + ", price=" + price + "]";
	}
	@Override
	public int compareTo(Car o) {
		return this.name.compareTo(o.name);
	}
}
public class SortTest {
	public static void main(String[] args) {
		Car c1 = new Car("제너시스 gv80", 8000);
		Car c2 = new Car("BMW X6", 10000);
		Car c3 = new Car("아우디 R8", 15000);
		Car c4 = new Car("롤스로이스 팬텀", 70000);
		List<Car> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);

		Collections.sort(list, new CarComp());
		System.out.println(list);
	}
	
	static class CarComp implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return (o1.price - o2.price) * -1;
		}
	}
}















