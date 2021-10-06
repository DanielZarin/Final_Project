import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Functionality_Tests {

	public static void main(String[] args) throws Exception {
WebDriver driver = new ChromeDriver();
		
		//********************************** Functionality Tests **********************************
		//Test #1
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
			driver.findElement(By.name("question")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			Thread.sleep(500);
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 2");
		}
		
		if(driver.getPageSource().contains("Mark the right one!")==false) {
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
	}

}
