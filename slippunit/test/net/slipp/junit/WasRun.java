package net.slipp.junit;

public class WasRun extends TestCase {
	String log = "";
	
	public WasRun(String name) {
		super(name);
	}
	
	protected void setUp() {
		log = "setUp ";
	}
	
	public void testMethod() {
		log += "testMethod ";
	}
	
	protected void tearDown() {
		log += "tearDown";
	}
}