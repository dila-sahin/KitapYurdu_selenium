package com.testinium.test;
import com.testinium.driver.BaseTest;
import com.testinium.methods.Methods;
import com.testinium.page.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductTest extends BaseTest {
    @Test
    public void productTest(){  //favorilere ekleme olarak değiştir.

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Methods methods = new Methods();
        methods.click(By.xpath("//div[@class='menu top login']"));
        methods.waitBySeconds(3);

        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.scrollWithAction(By.xpath("//a[@title='Emre ve Tahta Oyuncak']"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//div[@id='product-table']/div[3]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[4]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[5]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[6]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);

        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@id='product-table']/div[3]//i[@class='fa fa-heart red']")));
        //methods.waitBySeconds(2);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@id='product-table']/div[4]//i[@class='fa fa-heart red']")));
        //methods.waitBySeconds(2);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@id='product-table']/div[5]//i[@class='fa fa-heart red']")));
        //methods.waitBySeconds(2);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@id='product-table']/div[6]//i[@class='fa fa-heart red']")));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11682842/wh:dec2d77ad']"));
        methods.waitBySeconds(2);
    }

    @Test
    public void rating(){

        Methods methods = new Methods();
        methods.click(By.xpath("//div[@class='lvl1catalog']/a[.='Puan Kataloğu']"));
        methods.waitBySeconds(2);

        methods.scrollWithClick(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:4359433/wh:14a4e2d16']"));
        methods.waitBySeconds(2);

        methods.selectByText(By.xpath("//div[@class='sort']/select[1]"),"Yüksek Oylama");
        methods.waitBySeconds(5);

    }

    @Test
    public void hobbyTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Methods methods = new Methods();

        methods.click(By.xpath("/html/body/div[1]/div[4]/div[1]/ul/li[1]/div[2]/ul/li[3]/span"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("/html/body/div[1]/div[4]/div[1]/ul/li[1]/div[2]/ul/li[3]/div/div[1]/div/ul[2]/li[14]/a"));

        List<WebElement> productElements = driver.findElements(By.xpath("//ul[@class='product-grid jcarousel-skin-opencart']//li"));

        int randomIndex;
        Random random1 = new Random();
        randomIndex = random1.nextInt(productElements.size()); // 0 ile size() arasında random bir sayı üret

        WebElement randomProductElement = productElements.get(randomIndex); //Sayfadan random ürün seçimi yapılır sepete eklenir.
        methods.waitBySeconds(2);

        randomProductElement.click();
        methods.waitBySeconds(2);

        methods.scrollWithClick(By.xpath("//span[.='Sepete Ekle']"));
        methods.waitBySeconds(2);

    }

    @Test
    public void addFavorite(){   // Listelerim>Favorilerim gidilir. Favori Listesinde yer alan , 3.ürün silinir.
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Methods methods = new Methods();

        methods.click(By.xpath("//a[.='Listelerim']"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[.='Favorilerim']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//span[@class='sprite sprite-icon-list']"));
        methods.waitBySeconds(2);

        //List<WebElement> favoriteElements = driver.findElements(By.xpath("//div[@class='product-grid']"));
        //WebElement thirdElement = favoriteElements.get(2);

        methods.scrollWithClick(By.xpath("//div[@class='product-list']/div[3]//i[@class='fa fa-heart-o']"));
        methods.waitBySeconds(3);

    }

    @Test
    public void cart(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Methods methods = new Methods();

        methods.click(By.xpath("//h4[@class='common-sprite']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[@id='js-cart']"));
        methods.waitBySeconds(2);

        String value = methods.getValue(By.cssSelector(".cart-info tr:nth-of-type(1) [name='quantity']"));
        methods.waitBySeconds(2);

        int newValue = Integer.parseInt(value);
        newValue++;

        value = String.valueOf(newValue);

        WebElement element = methods.findElement(By.cssSelector(".cart-info tr:nth-of-type(1) [name='quantity']"));
        element.clear();
        methods.waitBySeconds(2);

        methods.sendKeys(By.cssSelector(".cart-info tr:nth-of-type(1) [name='quantity']"), value);
        methods.waitBySeconds(2);

        methods.click(By.xpath("//div[@class='cart-info']//tr[1]//i[@class='fa fa-refresh green-icon']"));
        methods.waitBySeconds(2);

        methods.scrollWithClick(By.xpath("//div[@class='right']/a[contains(.,'Satın Al')]"));
        methods.waitBySeconds(3);

        methods.click(By.xpath("//a[.='Yeni bir adres kullanmak istiyorum.']"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[@id='address-firstname-companyname']"), "Dila");
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[@id='address-lastname-title']"), "Sahin");
        methods.waitBySeconds(2);
        methods.selectByText(By.xpath("//select[@id='address-zone-id']"),"İstanbul");
        methods.waitBySeconds(2);
        methods.selectByText(By.xpath("//select[@id='address-county-id']"),"ÜMRANİYE");
        methods.waitBySeconds(3);
        methods.sendKeys(By.xpath("//textarea[@id='address-address-text']"),"Umraniye" );
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[@id='address-mobile-telephone']"), "5234567890");
        methods.waitBySeconds(2);
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[@id='credit-card-owner']"), "Dila Sahin");
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//table[@class='form']//tr[5]//input[1]"), "1234");
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[2]"), "1234");
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[3]"), "1234");
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[4]"), "1234");
        methods.waitBySeconds(2);
        methods.selectByText(By.xpath("//select[@id='credit-card-expire-date-month']"), "03");
        methods.waitBySeconds(2);
        methods.selectByText(By.xpath("//select[@id='credit-card-expire-date-year']"), "2026");
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[@id='credit-card-security-code']"), "123");
        methods.waitBySeconds(2);
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//img[@alt='kitapyurdu.com']"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//a[.='Merhaba Dila Sahin']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[.='Çıkış']"));
        methods.waitBySeconds(2);

    }

    @Test
    public void getAttribute(){
        Methods methods = new Methods();
        String attribute = methods.getAttribute(By.cssSelector(".logo-text>a>img"),"title");
        System.out.println("Alınan text: " +attribute);
        methods.waitBySeconds(3);
    }
    @Test
    public void getTextTest(){
        Methods methods = new Methods();
        String text = methods.getText(By.cssSelector(".common-sprite"));
        System.out.println("Alınan text: " +text);
        methods.waitBySeconds(3);
    }
    @Test
    public void valueTest(){
        Methods methods = new Methods();
        methods.sendKeys(By.id("search-input"), "testinium");
        String value = methods.getValue(By.id("search-input"));
        System.out.println("Alınan text:" +value);
        Assert.assertEquals("testinium", value);
        methods.waitBySeconds(5);
    }
}
