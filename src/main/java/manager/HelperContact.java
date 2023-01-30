package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase{


    private Object Contact;

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

    public int removeContact() {

        int countBefore = countOfContacts();
        if(!isCountListEmpty()){
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(1000);
        }

        int countAfter = countOfContacts();
        return countBefore-countAfter;


    }

    private boolean isCountListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    private int countOfContacts() {

        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
//        List<WebElement>list=wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
//        for(int i = 0; i < list.size(); i++){
//            click(By.cssSelector(".contact-item_card__2SOIM"));
//            click(By.xpath("//button[text()='Remove']"));
//            pause(1000);
//        }
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() !=0)
        {click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
                pause(1000);}
    }

    public void provideContactData() {
        if(wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() == 0) {
            while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() <4){
                addNewContact();}

        }
    }

    private void addNewContact() {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = models.Contact.builder()
                .name("John"+ index)
                .lastName("Ivanov")
                .phone("12345678"+index)
                .email("john"+index+"@gmail.com")
                .address("Rehovot")
                .description("The best friend")
                .build();
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        openContactForm();
        fillContactForm(contact);
        saveContact();
    }
}
