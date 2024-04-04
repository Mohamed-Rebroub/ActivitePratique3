package com.example.ActivitePratique3;
import com.example.ActivitePratique3.entities.Patient;

import com.example.ActivitePratique3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ActivitePratique3Application implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;


	public static void main(String[] args) {
		SpringApplication.run(ActivitePratique3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Mohamed",new Date(),false,34));
		patientRepository.save(new Patient(null,"Hanane",new Date(),false,100));
		patientRepository.save(new Patient(null,"Imane",new Date(),false,200));

	}
}
