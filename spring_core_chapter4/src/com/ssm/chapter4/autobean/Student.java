package com.ssm.chapter4.autobean;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	 private String ID;  
	    private String name;  
	    private int age;  
	    private String sex;  
	  
	    public String getID() {  
	        return ID;  
	    }  
	  
	    public void setID(String iD) {  
	        ID = iD;  
	    }  
	  
	    public String getName() {  
	        return name;  
	    }  
	  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	  
	    public int getAge() {  
	        return age;  
	    }  
	  
	    public void setAge(int age) {  
	        this.age = age;  
	    }  
	  
	    public String getSex() {  
	        return sex;  
	    }  
	  
	    public void setSex(String sex) {  
	        this.sex = sex;  
	    } 
	    
	    public void print(){
	    	System.out.println("一个学生");
	    }
}

