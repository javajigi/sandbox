package net.slipp.junit4;

public class TestSuiteTest {
	public static void main(String[] args) throws Exception {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(new ManyTest());
		TestResult result = testSuite.run();
		assert ("2 run, 0 failed".equals(result.summary()));
	}
}
