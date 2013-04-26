package net.slipp.junit;

public class TestResult {
	private int runCount = 0;
	
	public void testStarted() {
		runCount += 1;
	}
	
	public String summary() {
		return String.format("%d run, 0 failed", this.runCount);
	}
}
