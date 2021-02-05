package com.dilip.DemoHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class HardDisk {
@Id
private int hid;
private String type;
public int getHid() {
	return hid;
}
public void setHid(int hid) {
	this.hid = hid;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "HardDisk [hid=" + hid + ", type=" + type + "]";
}


}
