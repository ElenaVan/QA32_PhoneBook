package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase{


    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"),contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"),contact.getDescription());
    }

    public void saveContact() {
        click(By.xpath("//b[text()='Save']"));
    }

    public boolean isContactByName(String name) {
        List < WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el: list) {
            if(el.getText().equals(name)){
                return true;
            }

        } return false;

    }

    public boolean isContactByPhone(String phone) {
        List < WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el: list) {
            if(el.getText().equals(phone)){
                return true;
            }

        }return false;

    }

}
