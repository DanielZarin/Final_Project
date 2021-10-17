//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
	
	public static void main(String[] args) throws Exception {
		//********************************** Pre-Game SANITY **********************************
		String[][] ar1 = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"}};
		String[][] ar2 = {{"1", "2", "e"},{"2", "2", "f"}, {"3", "2", "g"},{"4", "2", "h"}};
		String[][] ar3 = {{"1", "2", "i"},{"2", "2", "j"}, {"3", "2", "k"},{"4", "2", "l"}};
		String globURL = "https://shemsvcollege.github.io/Trivia/";
		WebDriver driver = new ChromeDriver();
		driver.get(globURL);
		if(driver.getPageSource().contains("good luck!")==true) {
			driver.findElement(By.id("startB")).click();
		}
		else {
			throw new Exception("Error 1");
		}
		
		if(driver.getPageSource().contains("question number: 1")==true) {
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 2");
		}
		
		if(driver.getPageSource().contains("Mark the right one!")==true) {
			for (int i = 0; i < ar1.length; i++) {
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar1[i][0] +"]/div["+ ar1[i][1] +"]/input")).sendKeys(ar1[i][2]);
			}
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 3");
		}
		
		if(driver.getPageSource().contains("question number: 2")==true) {
			driver.findElement(By.name("question")).sendKeys("b");
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 4");	
		}
		
		if(driver.getPageSource().contains("Mark the right one!")==true) {
			for (int i = 0; i < ar2.length; i++) {
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar2[i][0] +"]/div["+ ar2[i][1] +"]/input")).sendKeys(ar2[i][2]);
			}
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 5");	
		}
		
		if(driver.getPageSource().contains("question number: 3")==true) {
			driver.findElement(By.name("question")).sendKeys("c");
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 6");	
		}
		
		if(driver.getPageSource().contains("Mark the right one!")==true) {
			for (int i = 0; i < ar3.length; i++) {
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar3[i][0] +"]/div["+ ar3[i][1] +"]/input")).sendKeys(ar3[i][2]);
			}
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
		}
		else {
			throw new Exception("Error 7");	
		}
		//********************************** End Pre-Game SANITY **********************************

		//********************************** Play SANITY **********************************
		if(driver.getPageSource().contains("play")==true) {
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
		}
		else {
			throw new Exception("Error 8");	
		}
		
		if(driver.getPageSource().contains("Test")==true) {
			driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		else {
			throw new Exception("Error 9");	
		}
		
		if(driver.getPageSource().contains("Test")==true) {
			driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		else {
			throw new Exception("Error 10");	
		}
		
		if(driver.getPageSource().contains("Test")==true) {
			driver.findElement(By.xpath("//*[@id=\"0\"]/input[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"btnnext\"]")).click();
		}
		else {
			throw new Exception("Error 11");	
		}

		if(driver.findElement(By.id("mark")).getText().equalsIgnoreCase("Sucsses")) {
			System.out.println("Sanity Test Passed Successfully");
		}
		else {
			throw new Exception("Error 12");	
		}
		//********************************** End Play SANITY **********************************
	}
}
