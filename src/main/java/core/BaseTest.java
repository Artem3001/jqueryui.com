package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
     protected WebDriver driver;

     @Before
     public void setUp(){
          System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
          BasePage.setDriver(driver);
     }
}