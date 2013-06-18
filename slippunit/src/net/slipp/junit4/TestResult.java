package net.slipp.junit4;

public class TestResult {
	private int runCount = 0;
	private int failureCount = 0;
	
	public void testStarted() {
		runCount += 1;
	}
	
	public void testFailed() {
		failureCount += 1;
	}
	
	public String summary() {
		return String.format("%d run, %d failed", this.runCount, this.failureCount);
	}
}
