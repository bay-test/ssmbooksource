package com.ssm.chapter4.service;

import com.ssm.chapter4.vo.Foo;

public class DefaultFooService implements FooService{

	 public Foo getFoo(String fooName) {
	        throw new UnsupportedOperationException();
	    }

	    public Foo getFoo(String fooName, String barName) {
	        throw new UnsupportedOperationException();
	    }

	    public void insertFoo(Foo foo) {
	        throw new UnsupportedOperationException();
	    }

	    public void updateFoo(Foo foo) {
	        throw new UnsupportedOperationException();
	    }
	    
	    public void deleteFoo(Foo foo){
	    	throw new UnsupportedOperationException();
	    }

}
