package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
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
	
	/*We use the top keyword if we know that a particular field is not unique*/
	Jedi findTopByName(String name);
	
	// Spring data Will automatically recognize the following;
	List<Jedi> findByNameContaining(String pattern);
	// In SQL it uses %LIKE% query
	
	// Using Native SQL
	@Query(value= "SELECT * FROM JEDI WHERE J_NAME = ?1", nativeQuery = true)
	Jedi findJediNative(String name);
	
	// Call functions
	@Query(value="SELECT TO_CHAR(CURRENT_TIMESTAMP, 'MM/DD/YYYY HH:MI:SS')", nativeQuery = true)
	String currentJediTime();
	
	/*Stored Procedures*/
	@Procedure(name="INSERT_JEDI")
	void save(@Param("ID") Integer id, @Param("NAME") String name, @Param("SABER_COLOR") String saberColor);
	
	
	
	
	
	
	
	
}
