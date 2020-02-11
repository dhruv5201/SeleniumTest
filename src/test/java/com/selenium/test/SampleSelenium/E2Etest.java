package com.selenium.test.SampleSelenium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class E2Etest {
	WebDriver driver;
  @Test
  public void Login() {
	  System.out.println("Test Execution.............");
	  driver.get("https://demo.testfire.net/login.jsp");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id='uid']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@id='passw']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@name='btnSubmit']")).click();
	  SoftAssert sa=new SoftAssert();
	  if (driver.findElement(By.xpath("//font[contains(text(),'Sign Off')]")).isDisplayed()) {
		  String ValidationString= driver.findElement(By.xpath("//font[contains(text(),'Sign Off')]")).getText();
		  
		  sa.assertEquals(ValidationString, "Sign Off");
	  }
	  else {
		  System.out.println("Can not validate Login Success as Validation eliment not visisble..!");
	  }
	  sa.assertAll();
	  
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "src/main/geckodriver.exe");
	  driver = new FirefoxDriver();
	  
  }
  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }

}
