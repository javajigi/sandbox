package net.slipp.junit4;

public class ManyTest {
	@Before
	public void setUp() {
		System.out.println("setUp");
	}

	@Test
	public void testMethod1() {
		System.out.println("testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("testMethod2");
	}
	
	@After
	public void tearDown() {
		System.out.println("tearDown");
	}
}
