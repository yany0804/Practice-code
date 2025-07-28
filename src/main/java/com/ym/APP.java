package com.ym;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ym.mapper")
public class APP {
    public static void main(String[] args) {

        SpringApplication.run(APP.class);
    }
}

