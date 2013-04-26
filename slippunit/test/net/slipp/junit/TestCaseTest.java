package net.slipp.junit;

public class TestCaseTest extends TestCase {
	public TestCaseTest(String name) {
		super(name);
	}

	public void testTemplateMethod() throws Exception {
		WasRun test = new WasRun("testMethod");
		test.run();
		assert ("setUp testMethod tearDown".equals(test.log));
	}
	
	public void testResult() throws Exception {
		WasRun test = new WasRun("testMethod");
		TestResult result = test.run();
		assert ("1 run, 0 failed".equals(result.summary()));
	}
	
	public void testFailedResult() throws Exception {
		WasRun test = new WasRun("testBrokenMethod");
		TestResult result = test.run();
		assert ("1 run, 1 failed".equals(result.summary()));		
	}

	public static void main(String[] args) throws Exception {
		runTest("testTemplateMethod");
		runTest("testResult");
		runTest("testFailedResult");
	}

	private static void runTest(String testMethodName) throws Exception {
		TestCaseTest test = new TestCaseTest(testMethodName);
		test.run();
	}
}
