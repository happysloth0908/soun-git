package com.ssafy.food;

import org.springframework.beans.factory.annotation.Autowired;

public class Cook {
	@Autowired
	private Ingredient ingredient;
	public Cook() {
		
	}
	public Cook(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public void setIngredient (Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public void display() {
		System.out.println("요리에 사용된 재료 : " + ingredient.getName());
	}
	
	
}
