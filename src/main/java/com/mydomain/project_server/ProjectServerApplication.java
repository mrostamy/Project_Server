package com.mydomain.project_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ProjectServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjectServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        File tempDir = new File("src/resources/uploads");

        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
    }
}
