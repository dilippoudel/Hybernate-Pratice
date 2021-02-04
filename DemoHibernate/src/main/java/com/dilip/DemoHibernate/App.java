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
    	AlienName an = new AlienName();
    	an.setFname("Dilip");
    	an.setMname("Kumar");
    	an.setLname("Poudel");
    	
    	Alien telusko = new Alien();
    	 telusko.setAid(101);
    	 telusko.setColor("pink");
    	 telusko.setAname(an);
    	 
    	// configuration
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	// create session factory
    	
    	SessionFactory sf = con.buildSessionFactory();    	
    	// saving the data to database
    	Session session = sf.openSession();
    	
    	Transaction tx =  session.beginTransaction();
    	session.save(telusko);
    	telusko = (Alien) session.get(Alien.class, 1056);
    	tx.commit();
    	System.out.println(telusko);
    }
}
