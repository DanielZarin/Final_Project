import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {

	@Test
	public void test1() {
// Enter 50 characters into question field and click on Next
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
//Enter 49 characters into question field + "?" and click on Next			
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
//Click on the Back button on the answers to question 1
			WebDriver driver = new ChromeDriver();
			driver.get("https://shemsvcollege.github.io/Trivia/");
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.getPageSource().contains("question number: 1")==true);
		}

		@Test
		public void test4() {
//Click on the Back button on question 2
			WebDriver driver = new ChromeDriver();
			driver.get("https://shemsvcollege.github.io/Trivia/");
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("a");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("b");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("c");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("d");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).isEnabled());
		}
		
		@Test
		public void test5() {
//Click on the Back button on the answers to question 2
			WebDriver driver = new ChromeDriver();
			driver.get("https://shemsvcollege.github.io/Trivia/");
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("a");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("b");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("c");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("d");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.name("question")).sendKeys("b");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.getPageSource().contains("question number: 2")==true);
		}
		
		@Test
		public void test6() {
//Click on the Back button on question 3
			WebDriver driver = new ChromeDriver();
			driver.get("https://shemsvcollege.github.io/Trivia/");
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("a");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("b");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("c");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("d");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.name("question")).sendKeys("b");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("e");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("f");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("g");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("h");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.findElement(By.name("answer1")).isDisplayed());
			//assertEquals(true, driver.getPageSource().contains("Please enter 4 possible answers and Mark the right one!\r\n" + "question number: 2")==true);
		}
		
		@Test
		public void test7() {
//Click on the Back button on the answers to question 3
			WebDriver driver = new ChromeDriver();
			driver.get("https://shemsvcollege.github.io/Trivia/");
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("a");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("b");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("c");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("d");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.name("question")).sendKeys("b");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("e");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("f");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("g");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("h");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.name("question")).sendKeys("c");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.findElement(By.name("question")).isDisplayed());
		}
		
		@Test
		public void test8() {
//Click on the Quit button
			WebDriver driver = new ChromeDriver();
			driver.get("https://shemsvcollege.github.io/Trivia/");
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("a");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("b");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("c");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("d");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.name("question")).sendKeys("b");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("e");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("f");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("g");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("h");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.name("question")).sendKeys("c");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("i");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("j");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("k");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("l");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[2]")).click();
			assertEquals(false, driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[2]")).isDisplayed());
		}
}
