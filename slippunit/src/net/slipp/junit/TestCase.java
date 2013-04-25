package net.slipp.junit;

import java.lang.reflect.Method;

public class TestCase {
	private String name;

	public TestCase(String name) {
		this.name = name;
	}
	
	public void run() {
		try {
			Method method = this.getClass().getMethod(this.name);
			method.invoke(this);
		} catch (Exception e) {
		}
	}
}