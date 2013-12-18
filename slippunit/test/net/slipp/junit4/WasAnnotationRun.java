package net.slipp.junit4;


public class WasAnnotationRun {
	String log = "";

	@Before
	public void setUp() {
		this.log += "setUp ";
	}

	@Test
	public void testMethod() {
		this.log += "testMethod ";
	}
	
	@After
	public void tearDown() {
		this.log += "tearDown";
	}
}
