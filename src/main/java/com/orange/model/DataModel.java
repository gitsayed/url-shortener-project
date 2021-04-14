package com.orange.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DataModel {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
Long id;
String longurl;
@Column(name = "shorturl", nullable = false,  unique = true)
String shorturl;
String[] parameters=new String [2];
String ipaddress;
String devicename;
String browsername;
String osname;
public DataModel() {
	
}
public DataModel( String long_url, String short_url, String[] parameters, String ip_address, String device_name,
		String browser_name, String os_name) {
	
	
	this.longurl = long_url;
	this.shorturl = short_url;
	this.parameters = parameters;
	this.ipaddress = ip_address;
	this.devicename = device_name;
	this.browsername = browser_name;
	this.osname = os_name;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLongurl() {
	return longurl;
}
public void setLongurl(String long_url) {
	this.longurl = long_url;
}
public String getShorturl() {
	return shorturl;
}
public void setShorturl(String short_url) {
	this.shorturl = short_url;
}
public String[] getParameters() {
	return parameters;
}
public void setParameters(String[] parameters) {
	this.parameters = parameters;
}
public String getIpaddress() {
	return ipaddress;
}
public void setIpaddress(String ip_address) {
	this.ipaddress = ip_address;
}
public String getDevicename() {
	return devicename;
}
public void setDevicename(String device_name) {
	this.devicename = device_name;
}
public String getBrowsername() {
	return browsername;
}
public void setBrowsername(String browser_name) {
	this.browsername = browser_name;
}
public String getOsname() {
	return osname;
}
public void setOsname(String os_name) {
	this.osname = os_name;
}
@Override
public String toString() {
	return "Orange [id=" + id + ", long_url=" + longurl + ", short_url=" + shorturl + ", parameters="
			+ Arrays.toString(parameters) + ", ip_address=" + ipaddress + ", device_name=" + devicename
			+ ", browser_name=" + browsername + ", os_name=" + osname + "]";
}
	

}
