package org.koushik.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
			
		Configuration configuration = new Configuration();
	    configuration.configure();
	    
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
	    
	    

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*
		for (int i = 0;i<10;i++) {
			
			UserDetails user = new UserDetails();
			user.setUserName("User " + i);
			session.save(user);
		}
		*/
	    Query query = session.createQuery("from UserDetails user where user.userId = 1");
	    query.setCacheable(true);
	    List<UserDetails> users = query.list();
	    
		session.getTransaction().commit();
		session.close();
	    
	    
	    

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
	    Query query2 = session2.createQuery("from UserDetails user where user.userId = 1");
	    query2.setCacheable(true);
	    users = query2.list();
	    
	    session2.getTransaction().commit();
	    session2.close();
	}

}
