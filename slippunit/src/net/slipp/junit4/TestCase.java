package net.slipp.junit4;

import java.lang.reflect.Method;

public class TestCase {
	private TestResult result;

	private Object testCase;

	private Method beforeMethod = null;
	private Method afterMethod = null;
	private Method testMethod = null;

	public TestCase(Object testCase, Method beforeMethod, Method method,
			Method afterMethod) {
		this.testCase = testCase;
		this.beforeMethod = beforeMethod;
		this.testMethod = method;
		this.afterMethod = afterMethod;
	}

	private void invokeMethod(Method method, Object testCase) {
		if (method == null) {
			return;
		}

		try {
			method.invoke(testCase);
		} catch (Exception e) {
			result.testFailed();
			e.printStackTrace();
		}
	}

	public void run(TestResult result) {
		this.result = result;
		result.testStarted();
		invokeMethod(beforeMethod, testCase);
		invokeMethod(testMethod, testCase);
		invokeMethod(afterMethod, testCase);
	}
}
