package com.ssafy.offline;
//class MyCheckedException extends Exception {}  // checked exception
//class MyUnCheckedException extends RuntimeException {} // unchecked exception
//class CarPriceException extends Exception {}
class CarPriceException extends RuntimeException {
	CarPriceException() {
		super("가격은 0보다 커야 합니다.");
	}
	CarPriceException(String msg) {
		super(msg);
	}
}
class Car {
	String name;
	int price;
	public Car(String name, int price) throws CarPriceException {
		if (price < 0) {
			throw new CarPriceException("가격은 0보다 커야 합니다.(" + price + ")");
		}
		this.name = name;
		this.price = price;
	}
}
public class ExceptionTest02 {
	public static void main(String[] args) {
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Car c1 = new Car("모닝", 1100);
			Car c2 = new Car("테슬라 모델X", -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		throw new MyCheckedException();
//		throw new MyUnCheckedException();
	}
}










