package net.slipp.junit;

import java.lang.reflect.Method;

public class TestCase {
	private String name;

	public TestCase(String name) {
		this.name = name;
	}

	protected void setUp() {
	}

	protected void tearDown() {
	}

	public TestResult run() throws Exception {
		TestResult result = new TestResult();
		result.testStarted();
		setUp();
		try {
			Method method = this.getClass().getMethod(this.name);
			method.invoke(this);
		} catch (Exception e) {
			result.testFailed();
		}
		tearDown();
		return result;
	}
}