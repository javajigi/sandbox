package net.slipp.junit4;

public class TestCaseTest {
	public static void main(String[] args) throws Exception {
		TestResult result = runTest(new WasAnnotationRun());
		System.out.println(result.summary());
		assert ("1 run, 0 failed".equals(result.summary()));
		
		result = runTest(new FailedTest());
        assert ("1 run, 1 failed".equals(result.summary()));
	}
	
	private static TestResult runTest(Object test) {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(test);
		return testSuite.run();
	}
}
