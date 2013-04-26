package net.slipp.junit;

public class TestCaseTest extends TestCase {
	private TestResult result;
	
	public TestCaseTest(String name) {
		super(name);
	}
	
	protected void setUp() {
		result = new TestResult();
	}

	public void testTemplateMethod() throws Exception {
		WasRun test = new WasRun("testMethod");
		test.run(result);
		assert ("setUp testMethod tearDown".equals(test.log));
	}
	
	public void testResult() throws Exception {
		WasRun test = new WasRun("testMethod");
		test.run(result);
		assert ("1 run, 0 failed".equals(result.summary()));
	}
	
	public void testFailedResult() throws Exception {
		WasRun test = new WasRun("testBrokenMethod");
		test.run(result);
		assert ("1 run, 1 failed".equals(result.summary()));		
	}
	
	public void testFailedResultFormatting() throws Exception {
		TestResult result = new TestResult();
		result.testStarted();
		result.testFailed();
		assert ("1 run, 1 failed".equals(result.summary()));
	}
	
	public void testSuite() throws Exception {
		TestSuite suite = new TestSuite();
		suite.add(new WasRun("testMethod"));
		suite.add(new WasRun("testBrokenMethod"));
		TestResult result = suite.run();
		assert ("2 run, 1 failed".equals(result.summary()));
	}

	public static void main(String[] args) throws Exception {
		TestSuite suite = new TestSuite();
		suite.add(new TestCaseTest("testTemplateMethod"));
		suite.add(new TestCaseTest("testResult"));
		suite.add(new TestCaseTest("testFailedResultFormatting"));
		suite.add(new TestCaseTest("testFailedResult"));
		suite.add(new TestCaseTest("testSuite"));
		suite.run();
	}
}
