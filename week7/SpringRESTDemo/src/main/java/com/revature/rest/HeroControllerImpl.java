package com.revature.rest;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.ajax.ClientMessage;
import com.revature.model.Hero;
import com.revature.service.HeroService;


/*
 * @RequestMapping 
 * 
 * path = /somthing that targets the collections featured in our URI
 * -- in this controller this would look something like here/register
 * 
 * produces -- tells Spring how to marshal specific mediatypes.
 * -- if the client sends us a header that says: Accept="application/xml", they will get XML back
 * 
 */
@Controller("heroController")
@CrossOrigin(origins = "http://localhost:4200")   //http://localhost:8080/SpringRESTDemo/hero/register
@RequestMapping(path="/hero", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class HeroControllerImpl implements HeroController{

	// use Autowiring for a HeroService property
	@Autowired
	private HeroService heroService;

	
	/**
	 * 
	 * 
	 * @RequestMapping(value="/register.app", method=RequestMethod.POST)
	 * Is the same as we have below.
	 * 
	 * @ResponseBody marshal our POJOS into JSON with Jackson (because we have the dependency).
	 * 
	 * @RequestBody unmarshals JSON available in the request body into our POJO.
	 */
	@PostMapping("/register")
	public @ResponseBody ResponseEntity<ClientMessage> registerHero(@RequestBody Hero hero) {
		return (heroService.registerHero(hero)) ? 
				new ResponseEntity<>(REGISTRATION_SUCCESSFUL, HttpStatus.OK) :
				new ResponseEntity<>(INVALID_DATA, HttpStatus.BAD_REQUEST);
				
			// ReponseEntity is provided by Spring to represent a full HTTP response,
				// uncluding headers, body and status 
	}

	@PostMapping("/findHero")
	public @ResponseBody ResponseEntity<Object> findHero(@RequestBody Hero hero, HttpServletRequest request) {
		// set Hero foundHero = to something....
		
		// set up a condition : IF the found hero is not null....
		return heroService.getHero(hero.getName());
	}

	@GetMapping("/findAllHeroes")
	public @ResponseBody List<Hero> findAllHeroes() {
		return heroService.getAllHeroes();
	}

	
}
