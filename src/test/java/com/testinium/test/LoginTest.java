package com.testinium.test;
import com.testinium.driver.BaseTest;
import com.testinium.methods.Methods;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        Methods methods = new Methods();

        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySeconds(3);
        methods.sendKeys(By.id("login-email"), "dila.sahin@testinium.com"); //id'si olduğu için direkt id girilebilir
        methods.waitBySeconds(5);
        methods.sendKeys(By.id("login-password"), "Dila12345");
        methods.waitBySeconds(5);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));   //1.yöntem
        //methods.click(By.xpath("//button[@class='ky-btn ky-btn-orange w-100 ky-login-btn']")); //2.yöntem
        methods.waitBySeconds(10);
    }
}

