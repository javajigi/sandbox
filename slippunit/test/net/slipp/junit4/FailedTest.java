package net.slipp.junit4;

public class FailedTest {
	@Test
	public void failed() {
		throw new NullPointerException();
	}
}
