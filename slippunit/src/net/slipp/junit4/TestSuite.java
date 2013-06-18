package net.slipp.junit4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestSuite {
	private TestResult result;
	
	private List<TestCase> tests = new ArrayList<TestCase>();
	
	public TestSuite() {
		result = new TestResult();
	}
	
	public void addTestSuite(Object testSuite) {
		Method beforeMethod = null;
		Method afterMethod = null;
		Method[] methods = testSuite.getClass().getMethods();
		for (Method method : methods) {
			Annotation[] annotations = method.getDeclaredAnnotations();
			for (Annotation annotation : annotations) {
				if (isBeforeMethod(annotation)) {
					beforeMethod = method;
					break;
				}
				
				if (isAfterMethod(annotation)) {
					afterMethod = method;
					break;
				}
			}
		}
		
		for (Method method : methods) {
			Annotation[] annotations = method.getDeclaredAnnotations();
			for (Annotation annotation : annotations) {
				if (isTestMethod(annotation)) {
					tests.add(new TestCase(testSuite, beforeMethod, method,
							afterMethod));
				}
			}
		}
	}

	private boolean isBeforeMethod(Annotation annotation) {
		return annotation instanceof Before ? true : false;
	}
	
	private boolean isTestMethod(Annotation annotation) {
		return annotation instanceof Test ? true : false;
	}
	
	private boolean isAfterMethod(Annotation annotation) {
		return annotation instanceof After ? true : false;
	}

	public TestResult run() {
		for (TestCase testCase : tests) {
			testCase.run(result);
		}
		
		return result;
	}
	
	
}
