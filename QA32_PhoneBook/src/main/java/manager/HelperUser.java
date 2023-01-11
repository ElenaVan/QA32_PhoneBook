package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd){
        super(wd);
    }
    public void openLoginRegistrationForm(){
        click(By.cssSelector("a[href='/login']"));
    }
    public void fillLoginRegistrationForm(String email, String password){
        type(By.xpath("(//input[@placeholder='Email'])[1]"),email);
        type(By.xpath("(//input[@placeholder='Password'])[1]"), password);
    }
    public void fillLoginRegistrationForm(User user){
        type(By.xpath("(//input[@placeholder='Email'])[1]"), user.getEmail());
        type(By.xpath("(//input[@placeholder='Password'])[1]"), user.getPassword());
    }
    public void submitLogin(){
        click(By.cssSelector("button[name='login']"));
    }
    public void submitRegistration(){
        click(By.cssSelector("button[name='registration']"));
    }
    public boolean isLoginRegistrationSucces(){
        return isElementPresent(By.xpath("//button[normalize-space()='Sign Out']"));
    }

    public boolean isSignOutPresent() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logOut() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert==null){
            return false;
        }else {
            return true;
        }

    }

    public boolean isErrorWrongFormat() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert();
        String error = alert.getText();
        System.out.println(error);
        //ok
        alert.accept();
        // cancel
      //  alert.dismiss();
        //send message
       // alert.sendKeys("Hello");
        return error.contains("Wrong email or password");

    }
}
