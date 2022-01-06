package com.gpn.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Inicializar no Camunda Tasklist (Start process), somente depois
 * de ter inicializado o ServicesServer.
 */
@SpringBootApplication
public class Application {
  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }
}