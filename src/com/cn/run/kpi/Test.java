package com.cn.run.kpi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/*System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.class.path"));*/
		User user = new User(1, "light", "123456");
		Class<?> clazz = user.getClass();
		Method method = clazz.getMethod("getName");
		System.out.println(method.invoke(user).toString());
		
	}
}

class User {
	private int id;
	
	private String name;
	
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
}

