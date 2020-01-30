package com.challenge.bktransfer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Juliano Nakamura
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.challenge.bktransfer")
public class AppConfig implements WebMvcConfigurer {

}