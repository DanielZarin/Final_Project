import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {

	@Test
	public void test1() {
// Enter 50 characters into question field
				WebDriver driver = new ChromeDriver();
				driver.get("https://shemsvcollege.github.io/Trivia/");
				driver.findElement(By.id("startB")).click();
				
				if(driver.getPageSource().contains("question number: 1")==true) {
					driver.findElement(By.name("question")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); //50
					driver.findElement(By.id("nextquest")).click();
					assertEquals(true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).isDisplayed());
				}
				else {
					fail("ERROR");
				}
	}
	
		@Test
		public void test2() {
//Enter 49 characters into question field + "?"			
			WebDriver driver = new ChromeDriver();
			driver.get("https://shemsvcollege.github.io/Trivia/");
			driver.findElement(By.id("startB")).click();
			
			if(driver.getPageSource().contains("question number: 1")==true) {
				driver.findElement(By.name("question")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa?"); //49+"?"
				driver.findElement(By.id("nextquest")).click();
				assertEquals(true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).isDisplayed());
			}
			else {
				fail("ERROR");
			}
		}
		
		@Test
		public void test3() {
//Click the Back button on the answers to question 1
			WebDriver driver = new ChromeDriver();
			driver.get("https://shemsvcollege.github.io/Trivia/");
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.id("backquest")).click();
			//assertEquals(!true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).isDisplayed());
			assertEquals(true, driver.getPageSource().contains("question number: 1")==true);
		}

		@Test
		public void test4() {
//Click the Back button on question 2

		}
}
