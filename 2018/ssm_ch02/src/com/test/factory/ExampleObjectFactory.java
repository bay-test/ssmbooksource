package com.test.factory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class ExampleObjectFactory extends DefaultObjectFactory {

	public Object create(Class type) {
		if (type.equals(Tiger.class)) {
			Tiger obj = (Tiger) super.create(type);
			obj.setAge(1000);
			obj.setName("test baynight chen");
			return obj;
		}
		return super.create(type);
	}

	public void setProperties(Properties properties) {
		Iterator iterator = properties.keySet().iterator();
		while (iterator.hasNext()) {
			String keyValue = String.valueOf(iterator.next());
			System.out.println(properties.getProperty(keyValue));
		}
		super.setProperties(properties);
	}

	public <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}
}
