package net.slipp.junit;

public class WasRun extends TestCase {
	boolean wasRun = false;
	boolean wasSetUp = false;
	
	public WasRun(String name) {
		super(name);
	}
	
	protected void setUp() {
		wasSetUp = true;
	}
	
	public void testMethod() {
		this.wasRun = true;
	}
}