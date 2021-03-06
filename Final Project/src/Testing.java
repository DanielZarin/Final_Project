import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
	String globURL = "https://shemsvcollege.github.io/Trivia/";
	@Test
	public void test1() {
	//Enter 50 characters into question field and click on Next - ERROR!
		WebDriver driver = new ChromeDriver();
		driver.get(globURL);
		driver.findElement(By.id("startB")).click();
		
			int maxChar = 50;
			for (int iLoopChar=0; iLoopChar < maxChar; iLoopChar++) {
				driver.findElement(By.name("question")).sendKeys("a"); 
			}
			driver.findElement(By.id("nextquest")).click();
			assertEquals(true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).isDisplayed());
			driver.close();
		}

	@Test
	public void test2() {
	//Enter 49 characters into question field + "?" and click on Next			
		WebDriver driver = new ChromeDriver();
		driver.get(globURL);
		driver.findElement(By.id("startB")).click();
					
			int maxChar = 49;
			for (int iLoopChar=0; iLoopChar < maxChar; iLoopChar++) {
				driver.findElement(By.name("question")).sendKeys("a"); 
			}
			driver.findElement(By.name("question")).sendKeys("?"); 
			driver.findElement(By.id("nextquest")).click();
			assertEquals(true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).isDisplayed());
			driver.close();
		}

		@Test
		public void test3() {
		//Click on the Back button on the answers to question 1
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.getPageSource().contains("question number: 1")==true);
			driver.close();
		}

		@Test
		public void test4() {
		//Click on the Back button on question 2
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"}};
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			for (int i = 0; i < ar.length; i++) {
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[i][0] +"]/div["+ ar[i][1] +"]/input")).sendKeys(ar[i][2]);
			}
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).isEnabled());
			driver.close();
		}
		
		@Test
		public void test5() {
		//Click on the Back button on the answers to question 2
			String[] qArr = {"a","b"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"}};
			int brakein = 4;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4;
						break;
					}
				}
			}
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.getPageSource().contains("question number: 2")==true);
			driver.close();
		}
		
		@Test
		public void test6() {
		//Click on the Back button on question 3 - ERROR!
			String[] qArr = {"a","b"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"}};
			int brakein = 4;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4;
						break;
					}
				}
			}
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.findElement(By.name("answer1")).isDisplayed());
			driver.close();
		}
		
		@Test
		public void test7() {
		//Click on the Back button on the answers to question 3
			String[] qArr = {"a","b"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"}};
			int brakein = 4;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4;
						break;
					}
				}	
			}
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.name("question")).sendKeys("c");
			driver.findElement(By.id("nextquest")).click();
			driver.findElement(By.id("backquest")).click();
			assertEquals(true, driver.findElement(By.name("question")).isDisplayed());
			driver.close();
		}
		
		@Test
		public void test8() {
		//Click on the Quit button after completing the preparation of the questions - ERROR!
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[2]")).click();
			assertEquals(false, driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[2]")).isDisplayed());
			driver.close();
		}
		
		@Test
		public void test9() {
		//Click on the Back button on the answers to the 2nd question in the game
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).click();
			driver.findElement(By.id("btnnext")).click();
			driver.findElement(By.id("btnback")).click();
			assertEquals(true, driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).isSelected());
			driver.close();
		}
		
		@Test
		public void test10() {
		//Click on the Back button on the answers to the 3rd question in the game			
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			String[][] arr = {{"2", "1"},{"1", "1"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.xpath("//*[@id="+ arr[i][0] +"]/input["+ arr[i][1] +"]")).click();
				driver.findElement(By.id("btnnext")).click();
			}
			driver.findElement(By.id("btnback")).click();
			assertEquals(true, driver.findElement(By.xpath("//*[@id=\"1\"]/input[1]")).isSelected());
			driver.close();
		}
		
		@Test
		public void test11() {
		//Click on the Try again button
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			String[][] arr = {{"2", "1"},{"1", "1"},{"0", "1"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.xpath("//*[@id="+ arr[i][0] +"]/input["+ arr[i][1] +"]")).click();
				driver.findElement(By.id("btnnext")).click();
			}
			driver.findElement(By.xpath("//*[@id=\"markpage\"]/center/button[1]")).click();	
			assertEquals(true, driver.findElement(By.id("btnnext")).isDisplayed());
			driver.close();
		}
		
		@Test
		public void test12() {
		//Click on the Quit button at the end of the game
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			String[][] arr = {{"2", "1"},{"1", "1"},{"0", "1"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.xpath("//*[@id="+ arr[i][0] +"]/input["+ arr[i][1] +"]")).click();
				driver.findElement(By.id("btnnext")).click();
			}
			driver.findElement(By.xpath("//*[@id=\"markpage\"]/center/button[2]")).click();	
			assertEquals(true, driver.findElement(By.xpath("/html/body")).isDisplayed());
			driver.close();
		}
		
		@Test
		public void test13() {
		//Enter 30 characters into answers fields and click on Next	
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"}};
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a"); 
			driver.findElement(By.id("nextquest")).click();
			int maxChar = 30;
				for (int iLoopChar=0; iLoopChar < maxChar; iLoopChar++) {
					for (int i = 0; i < ar.length; i++) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[i][0] +"]/div["+ ar[i][1] +"]/input")).sendKeys(ar[i][2]);
						}
			}
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();
			assertEquals(true, driver.findElement(By.name("question")).isDisplayed());
			driver.close();
		}
		
		@Test
		public void test14(){
		//Go through all the radio buttons in the answers to question 1
			String[][] ar = {{"1", "1"},{"2", "1"}, {"3", "1"},{"4", "1"}};
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			for (int i = 0; i < ar.length; i++) {
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[i][0] +"]/div["+ ar[i][1] +"]/input")).click();
				assertEquals(true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[i][0] +"]/div["+ ar[i][1] +"]/input")).isEnabled());
			}
			driver.close();
		}
		
		@Test
		public void test15() {
		//Go through all the radio buttons in the answers to question 2
			String[] qArr = {"a","b"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"}};
			String[][] arr = {{"1", "1"},{"2", "1"}, {"3", "1"},{"4", "1"}};
			int brakein = 4;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4;
						break;
					}
				}		
			}
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ arr[i][0] +"]/div["+ arr[i][1] +"]/input")).click();
				assertEquals(true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[i][0] +"]/div["+ ar[i][1] +"]/input")).isEnabled());
			}
			driver.close();
		}
		
		@Test
		public void test16() {
		//Go through all the radio buttons in the answers to question 3
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			String[][] arr = {{"1", "1"},{"2", "1"}, {"3", "1"},{"4", "1"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0 && qArr[i]!="c") {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ arr[i][0] +"]/div["+ arr[i][1] +"]/input")).click();
				assertEquals(true, driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[i][0] +"]/div["+ ar[i][1] +"]/input")).isEnabled());
			}
			driver.close();
		}
		
		@Test
		public void test17() {
		//Click the Next button without enter a question (Question 1)
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.id("nextquest")).click();
			assertEquals(true, driver.findElement(By.name("question")).isDisplayed());
			driver.close();
		}
		
		@Test
		public void test18() {
		//Click the Next button without enter a question (Question 2)
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"}};
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			driver.findElement(By.name("question")).sendKeys("a");
			driver.findElement(By.id("nextquest")).click();
			for (int i = 0; i < ar.length; i++) {
				driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[i][0] +"]/div["+ ar[i][1] +"]/input")).sendKeys(ar[i][2]);
			}
			driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
			driver.findElement(By.id("nextquest")).click();	
			driver.findElement(By.id("nextquest")).click();	
			assertEquals(true, driver.findElement(By.name("question")).isDisplayed());
			driver.close();
		}
		
		@Test
		public void test19() {
		//Click the Next button without enter a question (Question 3)	
			String[] qArr = {"a","b"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"}};
			int brakein = 4;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4;
						break;
					}
				}
			}
			driver.findElement(By.id("nextquest")).click();
			assertEquals(true, driver.findElement(By.name("question")).isDisplayed());
			driver.close();
		}
		
		@Test
		public void test20() {
		//Click the next button without marking an answer in preparation for answers to Question No. 1	
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			String alertMessage;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			driver.findElement(By.id("btnnext")).click();
			try {
				driver.switchTo().alert();
			}
			catch (NoAlertPresentException e) {
				fail("No alert");
			}
			alertMessage = driver.switchTo().alert().getText();
			assertEquals("You have to mark an answer!!", alertMessage);
			}
		
		@Test
		public void test21() {
		//Click the next button without marking an answer in preparation for answers to Question No. 2 - ERROR!
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			String alertMessage;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"2\"]/input[1]")).click();
			driver.findElement(By.id("btnnext")).click();	
			driver.findElement(By.id("btnnext")).click();
			try {
				driver.switchTo().alert();
			}
			catch (NoAlertPresentException e) {
				fail("No alert");
				driver.close();
			}
			alertMessage = driver.switchTo().alert().getText();
			assertEquals("You have to mark an answer!!", alertMessage);
		}
		
		@Test
		public void test22() {
		//Click the next button without marking an answer in preparation for answers to Question No. 3	
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			String[][] arr = {{"2", "1"},{"1", "1"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			String alertMessage;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.xpath("//*[@id="+ arr[i][0] +"]/input["+ arr[i][1] +"]")).click();
				driver.findElement(By.id("btnnext")).click();
			}
			driver.findElement(By.id("btnnext")).click();
			try {
				driver.switchTo().alert();
			}
			catch (NoAlertPresentException e) {
				fail("No alert");
			}
			alertMessage = driver.switchTo().alert().getText();
			assertEquals("You have to mark an answer!!", alertMessage);
		}
		
		@Test
		public void test23() {
		//Preparing a game and failing one question on purpose - ERROR!
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			String[][] arr = {{"2", "1"},{"1", "1"},{"0", "1"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.xpath("//*[@id="+ arr[i][0] +"]/input["+ arr[i][1] +"]")).click();
				driver.findElement(By.id("btnnext")).click();
			}
			assertEquals(driver.findElement(By.id("mark")).getText(), "Failed");
			driver.close();
		}	
		
		@Test
		public void test24() {
		//Preparing a game and failing two questions on purpose
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			String[][] arr = {{"2", "1"},{"1", "2"},{"0", "2"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.xpath("//*[@id="+ arr[i][0] +"]/input["+ arr[i][1] +"]")).click();
				driver.findElement(By.id("btnnext")).click();
			}
			assertEquals(driver.findElement(By.id("mark")).getText(), "Failed");
			driver.close();
		}
		
		@Test
		public void test25() {
		//Preparing a game and failing all questions on purpose
			String[] qArr = {"a","b","c"};
			String[][] ar = {{"1", "2", "a"},{"2", "2", "b"}, {"3", "2", "c"},{"4", "2", "d"},{"1","2","e"},{"2","2","f"},{"3","2","g"},{"4","2","h"},{"1","2","i"},{"2","2","j"},{"3","2","k"},{"4","2","l"}};
			String[][] arr = {{"2", "2"},{"1", "2"},{"0", "2"}};
			int brakein = 4;
			int loop = 1;
			int tmpIndx = 0;
			WebDriver driver = new ChromeDriver();
			driver.get(globURL);
			driver.findElement(By.id("startB")).click();
			for (int i = 0; i < qArr.length; i++) {
				driver.findElement(By.name("question")).sendKeys(qArr[i]);
				driver.findElement(By.id("nextquest")).click();
				
				for (int indx = tmpIndx; indx < ar.length; indx ++) {
					driver.findElement(By.xpath("//*[@id=\"answers\"]/div["+ ar[indx][0] +"]/div["+ ar[indx][1] +"]/input")).sendKeys(ar[indx][2]);
					
					if (((indx + 1) % brakein) == 0) {
						driver.findElement(By.xpath("//*[@id=\"answers\"]/div[1]/div[1]/input")).click();
						driver.findElement(By.id("nextquest")).click();
						tmpIndx = 4*loop;
						loop++;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//*[@id=\"secondepage\"]/center/button[1]")).click();
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.xpath("//*[@id="+ arr[i][0] +"]/input["+ arr[i][1] +"]")).click();
				driver.findElement(By.id("btnnext")).click();
			}
			assertEquals(driver.findElement(By.id("mark")).getText(), "Failed");
			driver.close();
		}
}
