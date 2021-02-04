package com.dilip.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Alien telusko = new Alien();
    	telusko.setAid(1056);
    	telusko.setAname("Dilip");
    	telusko.setColor("Blue");
    	
    	// configuration
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	// create session factory
    	
    	SessionFactory sf = con.buildSessionFactory();    	
    	// saving the data to database
    	Session session = sf.openSession();
    	
    	Transaction tx =  session.beginTransaction();
    	session.save(telusko);
    	tx.commit();
    }
}
