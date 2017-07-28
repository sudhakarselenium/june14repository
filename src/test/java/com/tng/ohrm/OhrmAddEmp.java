package com.tng.ohrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OhrmAddEmp {
	WebDriver driver;

	@BeforeClass
	public void openApplication() {
		//first change
		System.out.println("this is first change");
		
		
		// configure driver exe
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");

		// open chrome browser
		driver = new ChromeDriver();

		// specify page load timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		// specify element wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// maximize window
		driver.manage().window().maximize();

		// navigate to url
		driver.get("http://opensource.demo.orangehrmlive.com/");

		System.out.println("Application is opened");
	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
		System.out.println("Application is closed");
	}

	@Test()
	public void Login() {
		// enter text on username
		driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");

		// enter text on password
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin");

		// click on login button
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

		System.out.println("Login to application");
	}

	@Test()
	public void OhrmAddEmployee() {
		// click on PIM link
		driver.findElement(By.xpath("//a[.='PIM']")).click();

		// click on add employee
		driver.findElement(By.xpath("//a[contains(text(),'Add Emp')]")).click();

		// enter first name
		driver.findElement(By.name("firstName")).sendKeys("sudhakar");

		// enter last name
		driver.findElement(By.name("lastName")).sendKeys("k");

		driver.findElement(By.cssSelector("#btnSave")).click();

		System.out.println("employee added");
	}
}
