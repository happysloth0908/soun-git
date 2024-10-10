package com.ssafy.movie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		// 컨테이너 객체 생성하기 movie-config.xml 파일을 로딩 시킴
		ApplicationContext container = new GenericXmlApplicationContext("movie-config.xml");
//		for (String beanName : container.getBeanDefinitionNames()) {
//			System.out.println(beanName);
//		}
		Movie movie1 = container.getBean(Movie.class);
		Movie movie2 = (Movie) container.getBean("movie");
		Movie movie3 = container.getBean("movie", Movie.class);
		System.out.println(movie1 == movie2);
		System.out.println(movie2 == movie3);
		movie1.display();
	}
}
