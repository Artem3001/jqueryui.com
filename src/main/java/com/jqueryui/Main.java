package com.jqueryui;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement draggablePage = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='sidebar']/aside/ul/li/a[contains(@href, 'draggable')]"))));
        draggablePage.click();

        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.id("draggable"));
        actions.dragAndDropBy(element, 150, 150).build().perform();
        driver.switchTo().defaultContent();

        WebElement droppablePage = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='sidebar']/aside/ul/li/a[contains(@href, 'droppable')]"))));
        droppablePage.click();
        driver.switchTo().frame(0);
        WebElement dragElem = driver.findElement(By.id("draggable"));
        WebElement dropElem = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(dragElem, dropElem).build().perform();
        driver.switchTo().defaultContent();


        WebElement tabsPage = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='sidebar']/aside/ul/li/a[contains(@href, 'tabs')]"))));
        tabsPage.click();
        driver.switchTo().frame(0);
        WebElement tabElem = driver.findElement(By.xpath("//div/ul/li[@aria-controls='tabs-2']"));
        tabElem.click();
        WebElement tabNewElem = driver.findElement(By.xpath("//div[@id='tabs-2']/p"));

        String tabText = tabNewElem.getText();
        Assert.assertEquals("Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.", tabText);
        System.out.println(tabText);
        driver.switchTo().defaultContent();

        driver.quit();
    }

}
