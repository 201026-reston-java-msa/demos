package com.revature.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Hero;

@Repository("heroRepository") // Now we can use this class to access Data 
//and it will be detected in classpath scanning
@Transactional // Important annotation telling spring how this class is asscoiated with db sessions
public class HeroRepositoryHibernate implements HeroRepository{

	private static Logger logger = Logger.getLogger(HeroRepositoryHibernate.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public HeroRepositoryHibernate() {
		logger.trace("Injectoin session factory bean");
	}
	
	public void save(Hero hero) {
		sessionFactory.getCurrentSession().save(hero);
		
	}

	@SuppressWarnings("unchecked")
	public List<Hero> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Hero.class).list();
	}

	public Hero findByName(String name) {
		try {
			return (Hero) sessionFactory.getCurrentSession().createCriteria(Hero.class)
					.add(Restrictions.like("name", name)) // this should be the PROPERTY name of the class
					.list()
					.get(0);
		} catch (IndexOutOfBoundsException e) { 
			logger.debug(e);
			return null;
		}
	}

}
