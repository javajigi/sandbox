package net.slipp.junit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test {
	private List<Test> tests = new ArrayList<Test>();

	public void add(Test test) {
		tests.add(test);
	}

	public void run(TestResult result) throws Exception {
		for (Test test : tests) {
			test.run(result);
		}
	}

	public void addTestSuite(Class<? extends Test> testSuite) {
		Method[] methods = testSuite.getDeclaredMethods();
		for (Method method : methods) {
			if (isTestMethod(method)) {
				addTestMethod(testSuite, method);
			}
		}
	}

	private boolean isTestMethod(Method method) {
		return method.getName().startsWith("test");
	}

	private void addTestMethod(Class<? extends Test> testSuite, Method method) {
		try {
			Test test = getConstructor(testSuite).newInstance(method.getName());
			add(test);
		} catch (Exception e) {
		}
	}

	@SuppressWarnings("rawtypes")
	private static Constructor<? extends Test> getConstructor(
			Class<? extends Test> theClass) {
		Class[] args = { String.class };
		Constructor<? extends Test> c = null;
		try {
			c = theClass.getConstructor(args);
		} catch (Exception e) {
		}
		return c;
	}
}
