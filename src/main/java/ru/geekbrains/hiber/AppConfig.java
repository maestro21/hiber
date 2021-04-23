package ru.geekbrains.hiber;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.geekbrains.hiber")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AppConfig {

}
