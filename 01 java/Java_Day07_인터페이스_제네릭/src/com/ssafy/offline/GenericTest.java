/*
 * Object 사용
 * 장점 : 여러가지 타입을 받을 수 있다.
 * 단점 : 값을 꺼낼때 형변환 해야 한다.
 *     : 특정 데이터 타입으로 제한할 수 없다.
 * 	   : 실행시점에 에러가 발생하는 것을 알수 있다.
 * 
 * 
 * Generic를 이용한 해결
 * 
 */
package com.ssafy.offline;

import java.util.HashMap;
import java.util.Map;

class Box {
	Object data;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
/*
 * class 클래스이름<타입 파라미터>
 * 권장하는 1차 후보 이름
 * T : Type
 * E : Element
 * K : Key
 * V : Value
 * N : Number
 * 
 *    class Box            ->   Box b = new Box();
 *    class GenericBox<T>  ->   GenericBox<String> b 
 *                                    = new GenericBox<String>();
 */
class GenericBox<T> {
	T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
class DoubleBox<T, E> {
	T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}

public class GenericTest {
	public static void main(String[] args) {
		// List is a raw type. 
		// References to generic type List<E> should be parameterized
		DoubleBox<String, Integer> dBox = 
				new DoubleBox<>(); 
		
//		GenericBox<String> box = 
//				new GenericBox<String>();
		// 1.7 버전 부터 지원
		GenericBox<String> box = new GenericBox<>();
		// GenericBox is a raw type. 
		// References to generic type GenericBox<T> should be parameterized
//		GenericBox box = new GenericBox();
		box.setData("문자열 담기");
//		box.setData(1);
		String data = box.getData();
		System.out.println(data);
		
		GenericBox<Integer> box2 = 
				new GenericBox<Integer>();
		box2.setData(100);
		int value = box2.getData();
		System.out.println(value);
		
		/*
 		Box numberBox = new Box();
		numberBox.setData("문자열 데이터");
		numberBox.setData(1);
		String data = (String)numberBox.getData();
		System.out.println("data : " + data);
		*/
	}
}











