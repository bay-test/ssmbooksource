package com.test.bean;

public class People {

	Rice rice;
	String name;

	public People() {

	}

	public People(Rice meatRice, String name, Rice eggRice) {

		System.out.println(meatRice);
		System.out.println(name);
		System.out.println(eggRice);
	}

	//需要增强的方法
	public String eat(String name) {   
	 	//第二个空隙，已经进入了方法体内部但方法还未开始执行
		//可以用Around环绕通知对eat进行增强，这里可以操纵方法的传入参数	
		System.out.print("给" + name + "吃");
		rice.show();       
		//第三个空隙，方法已经返回
		//可以用AfterReturning返回通知对eat进行增强，这里可以获取方法返回的值	
		return name; 
		//第四个空隙，方法已经返回，流程还未退出方法体
       //可以用Around环绕通知对eat进行增强，这里可以获取方法参数和返回的值	
	}

	public Rice getRice() {
		return rice;
	}

	public void setRice(Rice rice) {
		this.rice = rice;
	}

	public String getName() {
		System.out.println("getName...");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
