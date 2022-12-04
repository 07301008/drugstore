package com.wangwei.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// 5、创建springmvc的配置文件，加载controller对应的bean
@Configuration
@ComponentScan("com.wangwei.controller")
@EnableWebMvc
public class SpringMvcConfig {
}
