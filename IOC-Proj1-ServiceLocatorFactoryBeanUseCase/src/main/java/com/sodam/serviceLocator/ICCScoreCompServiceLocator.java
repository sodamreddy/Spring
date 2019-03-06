package com.sodam.serviceLocator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

import com.sodam.external.ICCScoreComImpl;
import com.sodam.external.ICCScoreComp;

public class ICCScoreCompServiceLocator implements FactoryBean<ICCScoreComp> {
	private String jndiName;
	//cache
	private static Map<String,ICCScoreComp> cache= new HashMap();
	public ICCScoreCompServiceLocator(String jndiName) {
		this.jndiName=jndiName;
	}//constructor

	@Override
	public ICCScoreComp getObject() throws Exception {
		if(!cache.containsKey(jndiName)) {
			ICCScoreComp iccComp =new ICCScoreComImpl();
			cache.put(jndiName, iccComp);			
		}
		return cache.get(jndiName);
	}//getObject()

	@Override
	public Class<?> getObjectType() {	 
		return ICCScoreComp.class;
	}
	
	@Override
	public boolean isSingleton() {	
		return true;
	}
	
}//class
