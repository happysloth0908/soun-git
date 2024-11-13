package com.ssafy.mvc.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private String key = "SSAFY_NonMajor_JavaTrack_SecretKey";
	private SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

	
	//토큰 생성시 다양한 데이터를 저장할 수 있음  (DTO or Map)
	public String createToken (String name) {
		//유효기간
		Date exp = new Date(System.currentTimeMillis() + 1000*60*60); //1시간
		return Jwts.builder().header().add("typ", "JWT").and()
				.claim("name", name).expiration(exp)
				.signWith(secretKey).compact();
	}
	
	//유효성 검증
	//이거 했을 때 에러 나면 유효기간이 지난거!
	public Jws<Claims> validate(String token){
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}
}
