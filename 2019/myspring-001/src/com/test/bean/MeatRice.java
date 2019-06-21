package com.test.bean;

import org.springframework.stereotype.Component;

@Component
public class MeatRice implements Rice {

	@Override
	public void show() {
		System.out.println("肉炒饭...");
	}

}
