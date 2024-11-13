package com.ssafy.mvc.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTest {
	public static void main(String[] args) throws InterruptedException {
		// 비밀키 하나 필요함. 길이 제한이 있어서 너무 짧아도 안 됨.
		String key = "SSAFY_NonMajor_JavaTrack_SecretKey";
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

		Map<String, String> headers = new HashMap<>(); // 헤더에 뭐 많이 넣을거라 만듦
		headers.put("typ", "JWT");

		// JWT 3가지 (헤더/ 페이로드/ 서명)
		String token = Jwts.builder() // JWT를 만들 수 있는 빌더를 쓰게 됨
				.header() // 빌더 헤더를 만드는 객체가 됨
				.add("name", "choi").add(headers) // 헤더 한꺼번에 다 넣기
				.and() // 다시 JWT 빌더로 돌아감.
				.subject("ssafy").expiration(new Date(System.currentTimeMillis() + 3000)) // 유효 기간 설정 (3초)
				.signWith(secretKey) // 서명 완료
				.compact(); // 실제 토큰으로 만들기
		
		System.out.println(token);
		
		Thread.sleep(4000); // 유효기간 3초인데 4초 기다리게 하고 parse 하게 하기 
		
		Jws<Claims> jwsClaims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
		
		System.out.println(jwsClaims.getHeader());
		System.out.println(jwsClaims.getPayload());
		System.out.println(jwsClaims.getSignature());
	}
}
