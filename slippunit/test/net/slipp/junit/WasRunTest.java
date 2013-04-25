package net.slipp.junit;

public class WasRunTest {
	public static void main(String[] args) {
		WasRun test = new WasRun("testMethod");
		assert !test.wasRun;
		test.run();
		assert test.wasRun;
	}
}
