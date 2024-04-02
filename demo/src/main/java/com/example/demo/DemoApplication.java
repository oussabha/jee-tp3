package com.example.demo;

import com.example.demo.entities.patient;
import com.example.demo.repositories.Patientrepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
@Bean
    CommandLineRunner commandLineRunner(Patientrepositories patientrepositories){
        return args -> {
            patientrepositories.save(
                    new patient(null,"Hassan",new Date(),false,12));
            patientrepositories.save(
                    new patient(null,"mohamed",new Date(),true,88));
            patientrepositories.save(
                    new patient(null,"oussama",new Date(),true,321));
            patientrepositories.save(
                    new patient(null,"simo",new Date(),false,12));

            patientrepositories.findAll().forEach(p->{
                System.out.println(p.getNom());
                    }
                    );
        };
    }
}
