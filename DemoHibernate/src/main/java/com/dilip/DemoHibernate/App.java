package com.dilip.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setName("Dell");

    	
    	Student std = new Student();
    	std.setRollId(1);
    	std.setMarks(50);
    	std.setName("DIlip");
    	std.setLaptop(laptop);

    	
    	
	// configuration
    	Configuration con = new Configuration().configure();
    	con.addAnnotatedClass(Student.class);
    	con.addAnnotatedClass(Laptop.class);
    	
    	// create session factory
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	
    	SessionFactory sf = con.buildSessionFactory(registry);    	
    	// saving the data to database
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
    	session.save(laptop);
    	session.save(std);
    	session.getTransaction().commit();
    	
    }
}
