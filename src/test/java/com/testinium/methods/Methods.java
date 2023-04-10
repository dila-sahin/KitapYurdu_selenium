package com.testinium.methods;

import com.testinium.driver.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;
public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;  //try catchlerin yerine kullanılır
    JavascriptExecutor jsdriver; //sayfalarda interaktif hareketler yapmamız gerekecek, ekranın dışında kalan bir element aradığımızda hata alırız sayfanın altında kalan elementlerden birine ulaşmak için scroll metodunu kullanmak için oluşturuldu.

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);  //sayfa yüklenemediğinde ya da element bulunamadığında nasıl davranılacağının tanımlanması için, global olarak timeoutun tüm waitler için 30 sn olarak tanımlanması, quit edilmezse bile kapat kendini demek.
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) { //element yüklenene kadar bekle
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) { //elementi bulunca click
        findElement(by).click();
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By by) { //fluent wait tipinde wait yaratıldı, fluent wait içindeki until metodunu kullanarak elementin sayfa içinde located olarak bekle işlemini yapmak için metod oluşturulmuştu.// bu bloğa geldiğinde selenium bizim verdiğim time parametresi geçerli olmak kaldıysa 30 sn boyunca elementin sayfa içinde görünür olmaısnı bekliycez, 300 msde bir kontrol edicek 30 sn içinde bulursa
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver); //sayfadaki aksiyonlar için action sınıfı kullanılır.
        actions.moveToElement(findElement(by)).build().perform();
    }
    public void scrollWithClick(By by){
        this.scrollWithAction(by);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.click(by);
    }

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }
    public String getValue(By by){
        return jsdriver.executeScript("return arguments[0].value", findElement(by)).toString();
    }


}


