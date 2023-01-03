package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{




    @Test
    public void loginSuccess(){
        //open login form
        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));
        loginItem.click();
        //fill email
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("mio@gmail.com");
        //fill password
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Mio12345$");
        //click button Login
         wd.findElement(By.xpath("//*[text()=\" Login\"]")).click();

        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size()<=0);


    }
    @Test
    public void loginSuccessNew(){
        //open login form
        click(By.cssSelector("[href='/login']"));
        //fill email
        type(By.xpath("//input[1]"),"mio@gmail.com");
        type(By.xpath("//input[2]"), "Mio12335$");
        click(By.xpath("//*[text()=\" Login\"]"));

        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }

}
