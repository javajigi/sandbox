package net.slipp.junit;

public class WasRun extends TestCase {
	boolean wasRun = false;

	public WasRun(String name) {
		super(name);
	}

	public void testMethod() {
		this.wasRun = true;
	}
}