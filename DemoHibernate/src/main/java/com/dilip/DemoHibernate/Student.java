package com.dilip.DemoHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Student {
	@Id
	private int rollId;
	private String name;
	private int marks;
	@OneToOne
	private Laptop laptop;

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

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [rollId=" + rollId + ", name=" + name + ", marks=" + marks + ", laptop=" + laptop + "]";
	}

}
