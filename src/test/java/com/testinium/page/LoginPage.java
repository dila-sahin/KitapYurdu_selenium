package com.testinium.page;

import com.testinium.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
    Methods methods;
    public LoginPage(){
        methods = new Methods();
    }
    public void login(){
        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//*[@id='js-popup-accept-button']"));
        methods.waitBySeconds(3);
        methods.sendKeys(By.id("login-email"), "dila.sahin@testinium.com"); //id'si olduğu için direkt id girilebilir
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("login-password"), "Dila12345");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySeconds(7);
    }
}
