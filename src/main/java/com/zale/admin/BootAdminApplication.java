package com.zale.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.zale.admin")
@MapperScan("com.zale.admin.mapper")
public class BootAdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootAdminApplication.class, args);
    }

}
