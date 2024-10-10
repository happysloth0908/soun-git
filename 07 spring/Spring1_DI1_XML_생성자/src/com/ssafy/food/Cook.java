package com.ssafy.food;

public class Cook {
	private Ingredient ingredient;
	Cook(){
//		System.out.println("기본생성자 호출됨. ");
	}

	public Cook(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public void display() {
		System.out.println("요리에 사용된 재료 : " + ingredient.getName());
	}
	
	
}
