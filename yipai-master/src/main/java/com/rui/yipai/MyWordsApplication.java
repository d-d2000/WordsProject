package com.rui.yipai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.rui.yipai.mapper","com.rui.yipai.dao"})
public class MyWordsApplication {
  public static void main(String[] args) {
    SpringApplication.run(MyWordsApplication.class, args);
  }

}
