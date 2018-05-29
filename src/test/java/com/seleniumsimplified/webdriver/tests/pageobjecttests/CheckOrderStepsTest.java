package com.seleniumsimplified.webdriver.tests.pageobjecttests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumsimplified.webdriver.manager.Driver;

public class CheckOrderStepsTest {
	public static String orderNo = null;

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Go to order site and select some books and amount
	public void CheckOrderStep1() {
		System.out.println("------ step1 --------");

		// open web site
		WebDriver driver = Driver.get();
		driver.get("http://www.kodakan.se/OrderSw1.php");

		// select the checkbox
		if (!driver.findElement(By.name("book[]")).isSelected()) {
			driver.findElement(By.name("book[]")).click();
		}
		if (!driver.findElement(By.name("book[]38")).isSelected()) {
			driver.findElement(By.name("book[]38")).click();
		}
		if (!driver.findElement(By.name("book[]279")).isSelected()) {
			driver.findElement(By.name("book[]279")).click();
		}

		// Write test into box with name txtuserId and txtPassword
		WebElement nameBox1 = driver.findElement(By.name("qd1a"));
		nameBox1.sendKeys("2");
		WebElement nameBox2 = driver.findElement(By.name("qd6a"));
		nameBox2.sendKeys("2");
		WebElement nameBox3 = driver.findElement(By.name("qSagobok17"));
		nameBox3.sendKeys("2");

		// Wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("qSagobok17")));

		// Find button submit and click it
		WebElement LoginButton = driver.findElement(By.name("submit"));
		LoginButton.click();
		assertEquals(driver.getPageSource().contains("683"), true);

	}

	@Test
	// Go to order site and do next step
	public void CheckOrderStep2() {
		WebDriver driver = Driver.get();

		// Find button Submit and click it
		WebElement LoginButton2 = driver.findElement(By.name("submit"));
		LoginButton2.click();

		assertEquals(driver.getPageSource()
				.contains("Fel! fyll i korrekta uppgifter. Du måste fylla i alla fält som är med stjärna"), true);

		driver.navigate().back();
		// Find button Submit and click it
		WebElement LoginButton3 = driver.findElement(By.name("submit"));
		LoginButton3.click();

		// Check text
		assertEquals(driver.getPageSource()
				.contains("Fel! fyll i korrekta uppgifter. Du måste fylla i alla fält som är med stjärna."), true);
		driver.navigate().back();

		String[] elementName = { "BFnamn", "Bforetag", "Bepost", "Btel", "LFnamn", "Lgatuadress", "Lpostnr", "Lort",
				"Ltel", "FFnamn", "Fref", "Fgatuadress", "Fpostnr", "Fort", "Ftel" };
		String[] elementValue = { "Adam", "Blabla", "reklam@kodakan.se", "07223377", "Adam", "Testgatan 22", "932 11",
				"Testbro", "076262626", "Tyresö kommun", "2233", "Box 22", "137 22", "Tyresö", "08-7272772" };
		// Write test into box with name txtuserId and txtPassword
		for (int i = 0; i < elementName.length; i++) {
			WebElement orderForm = driver.findElement(By.name(elementName[i]));
			orderForm.sendKeys(elementValue[i]);
		}

		WebElement LoginButton4 = driver.findElement(By.name("submit"));
		LoginButton4.click();
	}

	@Test
	// Catch order nr
	public void CheckOrderStep3() {
		WebDriver driver = Driver.get();
		// WebDriverWait wait0 = new WebDriverWait(driver, 10);
		// wait0.until(ExpectedConditions.elementToBeClickable(By.name("xxxx")));
		// assertEquals(driver.getPageSource().contains("Tack för din beställning
		// Adam!"), true);

		// pick up order no
		WebElement e5 = driver.findElement(By.xpath("/html"));
		String a = e5.getText();
		String[] reader = a.split("\n");
		String[] readerFound = reader[1].split(" ");
		String[] readerFound1 = readerFound[2].split(":");
		orderNo = readerFound1[1];
		System.out.println(orderNo);

	}

	@Test
	// Go to login site
	public void CheckOrderStep4() {
		WebDriver driver = Driver.get();

		// open web site

		driver.get("http://www.kodakan.se/login.php");

		// Write test into box with name txtuserId and txtPassword
		WebElement nameBox = driver.findElement(By.name("txtUserId"));
		nameBox.sendKeys("jakob");

		WebElement nameBox11 = driver.findElement(By.name("txtPassword"));
		nameBox11.sendKeys("l...");

		// Wait
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.name("txtUserId")));

		// find button Login and click it
		WebElement LoginButton11 = driver.findElement(By.name("btnLogin"));
		LoginButton11.click();

		// Success if the page title not match the login page title
		// assertEquals("Assert initial page title", driver.getTitle(), "Dari language
		// educational software");
		// assertNotEquals("Assert initial page title", driver.getTitle(), "Dari
		// language educational software");
	}

	@Test
	// Find the order and deleted
	public void CheckOrderStep5() {
	WebDriver driver = Driver.get();

		// Put order no
		WebElement orderStatus = driver.findElement(By.name("order_nr"));
		orderStatus.sendKeys(orderNo);
		//System.out.println("Ordernr:"+ orderNo);
		
		// Submit
		WebElement LoginButton5 = driver.findElement(By.name("submit_ordernr"));
		LoginButton5.click();
				
		// Check if submitted
		//assertNotEquals("Assert initial page title", driver.getTitle(), "booksinfo");

		// Remove
		WebElement RemoveButton = driver.findElement(By.name("submit_tabort"));
		RemoveButton.click();
		System.out.println("-----------------------------------------------");
		
				
		// Check if submitted
		//assertNotEquals("Assert initial page title", driver.getTitle(), "Dari language educational software");

		
		
		// Check that order is deleted success
		//orderStatus.sendKeys(orderNo);
		//LoginButton5.click();

		// Check the page
		//assertNotEquals("Assert initial page title", driver.getTitle(), "booksinfo");

		// Go back to the pr page
		// driver.navigate().back();
		//driver.get("http://www.kodakan.se/OrderStatus.php");

		// Logout
		driver.get("http://www.kodakan.se/logout.php");
		//assertNotEquals("Assert initial page title", driver.getTitle(), "Login");

		// Wait
		// WebDriverWait wait111 = new WebDriverWait(driver, 10);
		// wait111.until(ExpectedConditions.elementToBeClickable(By.name("xxxx")));

		// Wait
		// WebDriverWait wait0 = new WebDriverWait(driver, 10);
		// wait0.until(ExpectedConditions.elementToBeClickable(By.name("xxxx")));

		// //Success if the page title not match the login page title
		// //assertEquals("Assert initial page title", driver.getTitle(), "Dari language
		// educational software");
		// assertNotEquals("Assert initial page title", driver.getTitle(), "Dari
		// language educational software");

	}

	/*
	 * @Test public void testClickAlertButtonAndAcceptAlert(){ //This test clicks OK
	 * on an alert
	 * 
	 * alertPage.get(); alertPage.clickAlertButton();
	 * assertEquals("Assert text change on drop", "I am an alert box!",
	 * alertPage.getAlertText()); alertPage.acceptAlert(); }
	 * 
	 * 
	 * @Test public void testClickConfirmButtonAndDismissAndAccept(){ //This test
	 * clicks OK and cancel on an alert
	 * 
	 * alertPage.get(); alertPage.clickConfirmButton();
	 * assertEquals("Assert text change on drop", "I am a confirm alert",
	 * alertPage.getAlertText()); alertPage.dismissAlert();
	 * assertEquals("Assert text change on dismiss", "false",
	 * alertPage.getConfirmReturnText()); alertPage.clickConfirmButton();
	 * alertPage.acceptAlert(); assertEquals("Assert text change on accept", "true",
	 * alertPage.getConfirmReturnText()); }
	 * 
	 * 
	 * @Test public void testClickPromptAndChangeText(){ //This test changes text on
	 * an alert
	 * 
	 * alertPage.get(); alertPage.clickPromptButton();
	 * assertEquals("Assert text on prompt", "I prompt you",
	 * alertPage.getAlertText()); alertPage.sendAlertKeys("this is new text");
	 * alertPage.acceptAlert(); assertEquals("Assert text change on accept",
	 * "this is new text", alertPage.getPromptReturnText()); }
	 */

	@AfterClass
	public static void afterTest() {
		System.out.println("running afterTest");
		 Driver.quit();
	}

}
