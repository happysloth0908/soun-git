package com.ssafy.offline;
/*
	타입 파라미터의 제한
 */
class GenericNumberBox<T extends Number> {
	
}
public class GenericType3 {
	public static void main(String[] args) {

		GenericNumberBox<Integer> box = new GenericNumberBox<>();
		GenericNumberBox<Double> box2 = new GenericNumberBox<>();
//		GenericNumberBox<String> box3 = new GenericNumberBox<>();
	}
}







