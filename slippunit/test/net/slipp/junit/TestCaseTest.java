package net.slipp.junit;

public class TestCaseTest extends TestCase {
	public TestCaseTest(String name) {
		super(name);
	}

	private WasRun test;

	protected void setUp() {
		test = new WasRun("testMethod");
	}

	public void testSetUp() throws Exception {
		test.run();
		assert test.wasSetUp;
	}

	public void testRun() throws Exception {
		test.run();
		assert test.wasRun;
	}

	public static void main(String[] args) throws Exception {
		runTest("testSetUp");
		runTest("testRun");
	}

	private static void runTest(String testMethodName) throws Exception {
		TestCaseTest test = new TestCaseTest(testMethodName);
		test.run();
	}
}
