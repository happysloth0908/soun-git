package test01_list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// List
		// - 순서도 있고, 중복도 허용
		
		List<String> names = new ArrayList<String>();
		
		// 원소의 추가
		names.add("luna");
		names.add("max");
		names.add("daisy");
		names.add("max");
		
//		System.out.println(names);
		
		// 리스트가 비어있는지 체크
//		System.out.println(names.isEmpty());
		
		// 수정
		names.set(0, "emily");
//		System.out.println(names);
		
		// 조회
//		System.out.println(names.get(3));
		
		// 순회
//		for(String name : names) {
//			System.out.println(name);
//		}
		
		
		// 삭제
		// 인덱스를 이용한 삭제
		names.remove(0);
//		System.out.println(names);
		
		// 값을 이용한 삭제
		names.remove("daisy");
//		System.out.println(names);
		
		names.remove("max");
//		System.out.println(names);
		// 똑같은 값이 여러 개 있다면, 하나만 지워진다.
		
		// 전부 삭제
		names.clear();
//		System.out.println(names);
//		System.out.println(names.isEmpty());
		
		// 삭제를 할 때 주의할점
		// - 중복된 값이 있을 때
		names.add("max");
		names.add("max");
		names.add("luna");
		
		System.out.println(names);
		
		// max를 다 지우고 싶다.
		// => for문을 돌면서 순회를 하면서, 일치하는 애들은 전부 지워버린다.
//		for(int i=0; i<names.size(); i++) {
//			if(names.get(i).equals("max"))
//				names.remove(i);
//		}
		
		for(int i=names.size()-1; i>=0; i--) {
		if(names.get(i).equals("max"))
			names.remove(i);
		}
		
		System.out.println(names);
		
		
		
	}
}




