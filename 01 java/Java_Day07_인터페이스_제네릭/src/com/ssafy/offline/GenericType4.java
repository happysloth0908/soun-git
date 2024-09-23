package com.ssafy.offline;
/*
	타입 파라미터의 제한
 */
class WildBox<T> {}
class Fruit {}
class Apple extends Fruit {}
class Grape extends Fruit {}
public class GenericType4 {
	public static void main(String[] args) {
		WildBox<Fruit> fBox = new WildBox<>();
		WildBox<Apple> aBox = new WildBox<>();
		WildBox<Grape> gBox = new WildBox<>();
//		fBox = aBox;		// error
		WildBox<?> box1 = new WildBox<Fruit>();
		box1 = new WildBox<Apple>();
		box1 = new WildBox<Grape>();
		
		WildBox<? extends Fruit> box2 = new WildBox<Fruit>();
		box2 = new WildBox<Apple>();
		box2 = new WildBox<Grape>();

		WildBox<? super Fruit> box3 = new WildBox<Fruit>();
//		box3 = new WildBox<Apple>();  // error
	}
}


















