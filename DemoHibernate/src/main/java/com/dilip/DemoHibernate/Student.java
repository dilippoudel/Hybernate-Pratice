package com.dilip.DemoHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	@Id
	private int rollId;
	private String name;
	private int marks;
	@OneToMany(mappedBy = "student")
	private List<Laptop> Laptop = new ArrayList<Laptop>();
	@ManyToMany(mappedBy = "student")
	private List<Courses> courses = new ArrayList<Courses>();

	public int getRollId() {
		return rollId;
	}

	public void setRollId(int rollId) {
		this.rollId = rollId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public List<Laptop> getLaptop() {
		return Laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		Laptop = laptop;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [rollId=" + rollId + ", name=" + name + ", marks=" + marks + ", Laptop=" + Laptop + "]";
	}

//	@ManyToMany(mappedBy = "courses")
//	private List<Courses> courses = new ArrayList<Courses>();

}
