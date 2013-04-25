package net.slipp.junit;

import java.lang.reflect.Method;

public class TestCase {
	private String name;

	public TestCase(String name) {
		this.name = name;
	}

	protected void setUp() {
	}

	public void run() throws Exception {
		setUp();
		Method method = this.getClass().getMethod(this.name);
		method.invoke(this);
	}
}