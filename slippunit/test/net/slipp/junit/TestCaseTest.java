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

	public static void main(String[] args) throws Exception {
		TestCaseTest test = new TestCaseTest("testTemplateMethod");
		test.run();
	}
}
