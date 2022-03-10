package com.jqueryui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.BaseTest;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage extends BaseTest {

    public MainPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/");

        Actions actions = new Actions(driver);
        PageFactory.initElements(driver, this);

    }
}