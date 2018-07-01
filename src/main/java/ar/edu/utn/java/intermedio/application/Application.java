package ar.edu.utn.java.intermedio.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ar.edu.utn.java.intermedio.controller.BenchmarkController;
import ar.edu.utn.java.intermedio.service.BenchmarkService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {BenchmarkController.class, BenchmarkService.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
