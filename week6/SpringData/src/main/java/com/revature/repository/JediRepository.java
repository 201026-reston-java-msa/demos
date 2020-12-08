package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Jedi;

/*
 * For more JpaRepository methods, go here: https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
 */
/*
 * In this repository interface we will extend the JpaRepository
 * Which is functionality that this project (Spring Data allows 
 * us in order to abstract away the Data Access Object
 * (Spring Data creates it for us)
 */

@Transactional
public interface JediRepository extends JpaRepository<Jedi, Long>{
	
	

}
