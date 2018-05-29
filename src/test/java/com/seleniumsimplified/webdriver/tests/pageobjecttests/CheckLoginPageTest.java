package com.seleniumsimplified.webdriver.tests.pageobjecttests;

import com.seleniumsimplified.webdriver.manager.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class CheckLoginPageTest {
	// private WebDriver driver;

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Checking login button without using username and password
	public void testClickLoginButton1() {
		System.out.println("------ Checking login button without using username and password --------");

		// open web site
		WebDriver driver = Driver.get();
		driver.get("http://www.kodakan.se/login.php");

		// find button Login and click it
		WebElement LoginButton = driver.findElement(By.name("btnLogin"));
		LoginButton.click();

		// Success if the page title not match the login page title
		assertNotEquals("Assert initial page title", driver.getTitle(), "Dari language educational software");
	}

	@Test
	// Checking login button with only username
	public void testClickLoginButton2() {
		System.out.println("------ Checking login button with only  username --------");

		// open web site
		WebDriver driver = Driver.get();
		driver.get("http://www.kodakan.se/login.php");

		// Write test into box with name txtuserId and txtPassword
		WebElement nameBox = driver.findElement(By.name("txtUserId"));
		nameBox.sendKeys("aron");

		// Wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtUserId")));

		// find button Login and click it
		WebElement LoginButton = driver.findElement(By.name("btnLogin"));
		LoginButton.click();

		// Success if the page title not match the login page title
		assertNotEquals("Assert initial page title", driver.getTitle(), "Dari language educational software");
	}

	@Test
	// Checking login button with only password
	public void testClickLoginButton3() {
		System.out.println("------ Checking login button with only  password --------");

		// open web site
		WebDriver driver = Driver.get();
		driver.get("http://www.kodakan.se/login.php");

		// Write test into box with name txtuserId and txtPassword
		WebElement nameBox = driver.findElement(By.name("txtPassword"));
		nameBox.sendKeys("xxx");

		// Wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtPassword")));

		// find button Login and click it
		WebElement LoginButton = driver.findElement(By.name("btnLogin"));
		LoginButton.click();

		// Success if the page title not match the login page title
		assertNotEquals("Assert initial page title", driver.getTitle(), "Dari language educational software");
	}

	@Test
	// Checking login button with username and password
	public void testClickLoginButton4() {
		System.out.println("------ Checking login button with username and password --------");

		// open web site
		WebDriver driver = Driver.get();
		driver.get("http://www.kodakan.se/login.php");

		// Write test into box with name txtuserId and txtPassword
		WebElement nameBox = driver.findElement(By.name("txtUserId"));
		nameBox.sendKeys("aron");

		// Wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtUserId")));

		WebElement nameBox2 = driver.findElement(By.name("txtPassword"));
		nameBox2.sendKeys("l...");

		// Wait
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.name("txtUserId")));

		// find button Login and click it
		WebElement LoginButton = driver.findElement(By.name("btnLogin"));
		LoginButton.click();

		// Success if the page title not match the login page title
		// assertEquals("Assert initial page title", driver.getTitle(), "Dari language
		// educational software");
		assertNotEquals("Assert initial page title", driver.getTitle(), "Dari language educational software");
		// Wait
		 WebDriverWait wait0 = new WebDriverWait(driver, 10);
		 wait0.until(ExpectedConditions.elementToBeClickable(By.name("xxxx")));
	}

	@AfterClass
	public static void afterTest() {
		System.out.println("running afterTest");
		Driver.quit();
	}

}