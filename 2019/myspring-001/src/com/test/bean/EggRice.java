package com.test.bean;

import org.springframework.stereotype.Component;


public class EggRice implements Rice {

	@Override
	public void show() {
		System.out.println("蛋炒饭...");
	}

}
