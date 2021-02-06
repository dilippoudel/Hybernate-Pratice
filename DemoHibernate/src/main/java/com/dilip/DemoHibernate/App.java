package com.dilip.DemoHibernate;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
//		HardDisk hd = new HardDisk();
//    	hd.setHid(301);
//    	hd.setType("SDD");
//    	
//    	Laptop laptop = new Laptop();
//    	laptop.setLid(101);
//    	laptop.setName("Dell");
//    	laptop.setHarddisk(hd);
//    	
//
//    	Courses courses = new Courses();
//    	courses.setCid(201);
//    	courses.setCname("computer science");
    	
    	
    	
//    	Student std = new Student();
//    	std.setRollId(1);
//    	std.setMarks(50);
//    	std.setName("DIlip");
//    	std.getLaptop().add(laptop);    	
//    	courses.getStudent().add(std);	
    	// configuration
    	Configuration con = new Configuration().configure();
    	con.addAnnotatedClass(Alien.class);
//    	con.addAnnotatedClass(Student.class);
//    	con.addAnnotatedClass(Laptop.class);
//    	con.addAnnotatedClass(HardDisk.class);
//    	con.addAnnotatedClass(Courses.class);
    	
    	// create session factory
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	
    	SessionFactory sf = con.buildSessionFactory(registry);  
    	
    	
    	// saving the data to database
//    	Session session = sf.openSession();
//    	session.beginTransaction();
//    	   	
//    	session.save(laptop);
//    	session.save(courses);
//    	session.save(std);
//    	session.save(hd);
//    	session.getTransaction().commit();
    	
    	
    	
    	
    	// fetching data from database using querry with cache
    	
//    	Session session1 = sf.openSession();
//    	session1.beginTransaction();
//    	Query<Student> q1 = session1.createQuery("from Student where rollId=1");
//    	q1.setCacheable(true);
//    	Student s1 = q1.uniqueResult();
//    	System.out.println(s1);
//    	
//    	session1.getTransaction().commit();
//    	session1.close();
//    	
//    	
//    	
//    	
//    	
//    	Session session2 = sf.openSession();
//    	session2.beginTransaction();
//    	Query<Student> q2 = session2.createQuery("from Student where rollId=1");
//    	q2.setCacheable(true);
//    	Student s2 = q2.uniqueResult();
//    	System.out.println(s2);
//    	
//    	session2.getTransaction().commit();
//    	session2.close();
    	
    	
    	
    	
    	// Inserting multiple datas into database
    	
    	Session session = sf.openSession();
    	session.beginTransaction();

//    	for(int i = 1; i < 51; i++) {
//    		Alien al = new Alien();
//    		al.setAid(i);
//    		al.setAname("Name "+ i);
//    		al.setColor("Blue");
//    		session.save(al);
//    		
//    	}
    	// if the result is surely expected as list then
    	Query<Alien> q1 = session.createQuery("from Alien"); // Alien is entity name not the table name
    	List<Alien> aliens = q1.list();
    	for(Alien a: aliens) {
    		System.out.println(a);
    	}
    	
    	// if the result is uniqe then
    	Query<Alien> q2 = session.createQuery("from Alien where aid = 7");
    	Alien a1 = q2.uniqueResult();
    	System.out.println("This is from the selected id " + a1);
    	
    	
    	// if the output is object
    	//     	Query q3 = session.createQuery("select aname, color from Alien where aid = 7");
    	// Or we can specify the value of id like this
    	int id = 7;
    	Query q3 = session.createQuery("select aname, color from Alien where id = :id");
    	q3.setParameter("id",id);
    	Object[] alien  = (Object[]) q3.uniqueResult();
    	for(Object o : alien) {
    		System.out.println(o);
    	}
    	
    	
    	// if the output is object
    	Query q4 = session.createQuery("select aname, color from Alien");
    	List<Object[]> als  = (List<Object[]>) q4.list();
    	for(Object[] al : als) {
    		System.out.println("Name : " + al[0] +" Color : " + al[1] );
    	}
    	
    	session.getTransaction().commit();
    	session.close();
    	
    }
}
