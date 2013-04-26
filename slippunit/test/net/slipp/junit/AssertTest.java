package net.slipp.junit;

public class AssertTest extends TestCase {
	public AssertTest(String name) {
		super(name);
	}
	
	public void testAssertEquals() {
		Object o= new Object();
		assertEquals(o, o);
	}
	
	public void testAssertEqualsNull() {
		assertEquals(null, null);
	}
	
	public void testAssertNotEquals() {
		Object o= new Object();
		Object o2 = new Object();
		assertEquals(o, o2);
	}
	
	public static void main(String[] args) throws Exception {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(AssertTest.class);
		TestResult result = new TestResult();
		suite.run(result);
		TestCase.assertEquals("3 run, 1 failed", result.summary());
	}
}