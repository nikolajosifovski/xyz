package lesson6;

import org.testng.annotations.Test;

public class testIf {
	
	@Test
	public void test1() {
		int n = 14;
		
		if(n < 3) {
			System.out.println("case1");
		}
		else if(n < 7) {
			System.out.println("case2");
		}
		else{
			System.out.println("case3");
		}
	}
	
	

}
