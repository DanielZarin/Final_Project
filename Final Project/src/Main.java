//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		
		//********************************** Pre-Game SANITY **********************************
		driver.get("https://shemsvcollege.github.io/Trivia/");
		Thread.sleep(500);
		if(driver.getPageSource().contains("good luck!")==true) {
			driver.findElement(By.id("startB")).click();
		}
		else {
			throw new Exception("Error 1");
		}
		
		if(driver.getPageSource().contains("question number: 1")==true) {
			Thread.sleep(500);
			driver.findElement(By.name("question")).sendKeys("a");
			Thread.sleep(500);
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 2");
		}
		
		if(driver.getPageSource().contains("Mark the right one!")==true) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("a");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("b");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("c");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("d");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			Thread.sleep(500);
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 3");
		}
		
		if(driver.getPageSource().contains("question number: 2")==true) {
			Thread.sleep(500);
			driver.findElement(By.name("question")).sendKeys("b");
			Thread.sleep(500);
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 4");	
		}
		
		if(driver.getPageSource().contains("Mark the right one!")==true) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("e");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("f");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("g");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("h");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			Thread.sleep(500);
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 5");	
		}
		
		if(driver.getPageSource().contains("question number: 3")==true) {
			Thread.sleep(500);
			driver.findElement(By.name("question")).sendKeys("c");
			Thread.sleep(500);
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 6");	
		}
		
		if(driver.getPageSource().contains("Mark the right one!")==true) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[2]/input")).sendKeys("i");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[2]/input")).sendKeys("j");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[3]/div[2]/input")).sendKeys("k");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[4]/div[2]/input")).sendKeys("l");
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			Thread.sleep(500);
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 7");	
		}
		//********************************** End Pre-Game SANITY **********************************

		//********************************** Play SANITY **********************************
		if(driver.getPageSource().contains("play")==true) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
		}
		else {
			throw new Exception("Error 8");	
		}
		
		if(driver.getPageSource().contains("Test")==true) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		else {
			throw new Exception("Error 9");	
		}
		
		if(driver.getPageSource().contains("Test")==true) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		else {
			throw new Exception("Error 10");	
		}
		
		if(driver.getPageSource().contains("Test")==true) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		else {
			throw new Exception("Error 11");	
		}
		
		if(driver.getPageSource().contains("Sucsses")==true) {
			System.out.println("Sanity Test Passed Successfully");
		}
		else {
			throw new Exception("Error 12");	
		}
		//********************************** End Play SANITY **********************************
	}
}
