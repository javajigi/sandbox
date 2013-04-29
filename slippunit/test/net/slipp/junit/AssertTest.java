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
 		try {
     		assertEquals(new Object(), new Object());
 		} catch (AssertionFailedError e) {
 			return;
  		}
 		fail();
	}
	
	public static void main(String[] args) throws Exception {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(AssertTest.class);
		TestResult result = new TestResult();
		suite.run(result);
		Assert.assertEquals("3 run, 0 failed", result.summary());
	}
}