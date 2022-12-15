package exercises;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestNG {
	
	@BeforeSuite
	public void suiteSetup() {
		System.out.println("This will be printed before Suite");
	}
	@AfterSuite
	public void suiteTeardown() {
		System.out.println("This will be printed after Suite");
	}
	
	
	@BeforeClass
	public void classSetup() {
		System.out.println("This will be printed before Class");
	}
	
	@BeforeMethod
	public void methodSetup() {
		System.out.println("This will be printed before each Method");
	}
	
	@AfterClass
	public void classTeardon() {
		System.out.println("This will be printed after Class");
	}
	
	@AfterMethod
	public void methodTeardown() {
		System.out.println("This will be printed aftter each Method, in our case each Test case");
	}
	
	
	@Test
	public void test001() {
		System.out.println("test 1 execution");
	}
	
	@Test
	public void test002() {
		System.out.println("test 2 execution");
	}
	
	@Test
	public void test003() {
		System.out.println("test 2 execution");
	}
}


