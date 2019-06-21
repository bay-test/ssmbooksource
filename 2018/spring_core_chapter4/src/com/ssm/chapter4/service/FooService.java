package com.ssm.chapter4.service;

import com.ssm.chapter4.vo.Foo;

public interface FooService {
	
	 Foo getFoo(String fooName);

	 Foo getFoo(String fooName, String barName);

	 void insertFoo(Foo foo);

	 void updateFoo(Foo foo);

}
