package net.slipp.junit;

import java.lang.reflect.Method;

public class TestCase implements Test {
	private String name;

	public TestCase(String name) {
		this.name = name;
	}

	protected void setUp() {
	}

	protected void tearDown() {
	}

	public void run(TestResult result) throws Exception {
		result.testStarted();
		setUp();
		try {
			Method method = this.getClass().getMethod(this.name);
			method.invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
			result.testFailed();
		}
		tearDown();
	}
	
	public static void assertEquals(Object expected, Object actual) {
		if (expected == null && actual == null) {
			return;
		}
		
		if (expected != null && expected.equals(actual)) {
			return;
		}
		
		throw new AssertionFailedError();
	}
}