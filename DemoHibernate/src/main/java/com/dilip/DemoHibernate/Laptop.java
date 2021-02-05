package com.dilip.DemoHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private int lid;
	private String name;
	@OneToOne
	private HardDisk harddisk;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HardDisk getHarddisk() {
		return harddisk;
	}

	public void setHarddisk(HardDisk harddisk) {
		this.harddisk = harddisk;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", name=" + name + ", harddisk=" + harddisk + "]";
	}

	

	
}
