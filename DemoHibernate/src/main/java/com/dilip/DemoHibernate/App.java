package com.dilip.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    	
    	HardDisk hd = new HardDisk();
    	hd.setHid(301);
    	hd.setType("SDD");
    	
    	Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setName("Dell");
    	laptop.setHarddisk(hd);
    	

    	Courses courses = new Courses();
    	courses.setCid(201);
    	courses.setCname("computer science");
    	
    	
    	
    	Student std = new Student();
    	std.setRollId(1);
    	std.setMarks(50);
    	std.setName("DIlip");
    	std.getLaptop().add(laptop);    	
    	courses.getStudent().add(std);	
    	// configuration
    	Configuration con = new Configuration().configure();
    	con.addAnnotatedClass(Student.class);
    	con.addAnnotatedClass(Laptop.class);
    	con.addAnnotatedClass(HardDisk.class);
    	con.addAnnotatedClass(Courses.class);
    	
    	// create session factory
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	
    	SessionFactory sf = con.buildSessionFactory(registry);    	
    	// saving the data to database
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
    	session.save(laptop);
    	session.save(courses);
    	session.save(std);
    	session.save(hd);
    	session.getTransaction().commit();
    	
    	
    	Student s1 = session.get(Student.class, 1);
    	System.out.println(s1);
    	session.close();
    	
    	Session session1 = sf.openSession();
    	session1.beginTransaction();
    	Student s2 = session1.get(Student.class, 1);
    	System.out.println(s2);
    	
    	session1.getTransaction().commit();
    	session1.close();
    	
    	
    	
    	Session session2 = sf.openSession();
    	session2.beginTransaction();
    	Student s3 = session2.get(Student.class, 1);
    	System.out.println(s3);
    	
    	session2.getTransaction().commit();
    	session2.close();

    	
    }
}
