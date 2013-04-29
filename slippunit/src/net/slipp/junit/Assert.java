package net.slipp.junit;

public class Assert {
	public static void assertEquals(Object expected, Object actual) {
		if (expected == null && actual == null) {
			return;
		}
		
		if (expected != null && expected.equals(actual)) {
			return;
		}
		
		fail();
	}
	
	public static void fail() {
		throw new AssertionFailedError();
	}
}
