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
		assertEquals("setUp testMethod tearDown", test.log);
	}
	
	public void testResult() throws Exception {
		WasRun test = new WasRun("testMethod");
		test.run(result);
		assertEquals("1 run, 0 failed", result.summary());
	}
	
	public void testFailedResult() throws Exception {
		WasRun test = new WasRun("testBrokenMethod");
		test.run(result);
		assertEquals("1 run, 1 failed", result.summary());
	}
	
	public void testFailedResultFormatting() throws Exception {
		TestResult result = new TestResult();
		result.testStarted();
		result.testFailed();
		assertEquals("1 run, 1 failed", result.summary());
	}
	
	public void testSuite() throws Exception {
		TestSuite suite = new TestSuite();
		suite.add(new WasRun("testMethod"));
		suite.add(new WasRun("testBrokenMethod"));
		suite.run(result);
		assertEquals("2 run, 1 failed", result.summary());
	}
	
	public void testAddTestSuite() throws Exception {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(WasRun.class);
		suite.run(result);
		assertEquals("2 run, 1 failed", result.summary());
	}

	public static void main(String[] args) throws Exception {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestCaseTest.class);
		TestResult result = new TestResult();
		suite.run(result);
		Assert.assertEquals("6 run, 0 failed", result.summary());
	}
}
