package net.slipp.junit;

public class AssertionFailedError extends Error {
	private static final long serialVersionUID = 4505387273461768440L;
	
	public AssertionFailedError () {
	}
	
	public AssertionFailedError (String message) {
		super (message);
	}
}