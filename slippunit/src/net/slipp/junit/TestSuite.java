package net.slipp.junit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
	private List<TestCase> tests = new ArrayList<TestCase>();

	public void add(TestCase test) {
		tests.add(test);
	}

	public TestResult run() throws Exception {
		TestResult result = new TestResult();
		for (TestCase test : tests) {
			test.run(result);
		}
		return result;
	}
}
