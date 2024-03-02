package com.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hibernate.entity.Passport;
import com.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j // For logging
public class SpringBootHibernateApplication implements CommandLineRunner {

	@Autowired
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
	    //When Student is the owning side of the relationship
	    Student student = entityManager.find(Student.class, 1L);
	    if (student != null) {
	        log.info("Student -> {}", student);
	        Passport passport = student.getPassport();
	        if (passport != null) {
	            log.info("Get Passport from Student -> {}", passport);
	        } else {
	            log.warn("Passport not found for student with ID 1");
	        }
	    } else {
	        log.warn("Student with ID 1 not found");
	    }

	    //when passport is the owning side of the relationship
	    Passport passport = entityManager.find(Passport.class, 1L);
	    if (passport != null) {
	        log.info("Passport -> {}", passport);
	        Student studentFromPassport = passport.getStudent();
	        if (studentFromPassport != null) {
	            log.info("Get Student from Passport  -> {}", studentFromPassport);
	        } else {
	            log.warn("Student not found for passport with ID 1");
	        }
	    } else {
	        log.warn("Passport with ID 1 not found");
	    }
	}
}
