package lesson3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNG {
	
	
	
	@BeforeClass
	public void classSetup() {
		System.out.println("This will be executed before Class");
	}

	@AfterClass
	public void classTearDown() {
		System.out.println("This will be executed afeter the Class");
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("This will be executed before each test");
	}
	
	
	@AfterMethod
	public void teardown() {
		System.out.println("This will be executed after each test");
	}
	
	
	
	@Test
	public void test1(){
		
		System.out.println("Test 1 execution");
		
	}
	
	@Test
	public void test2(){
		
		System.out.println("Test 2 execution");
		
	}
	
	@Test
	public void test3(){
		
		System.out.println("Test 3 execution");
		
	}
	
	
	
	
	
	
	

}
