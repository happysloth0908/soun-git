package com.ssafy.myBoard.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.myBoard.board.model.dao")
public class DBConfig {


}
