package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().login(new User().withEmail("miomi@gmail.com").withPassword("Mmiomi123$"));
        }
    }

    @Test(groups = {"web", "reg","quick"})
    public void addNewContactSuccess(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("John"+ index)
                .lastName("Ivanov")
                .phone("12345678"+index)
                .email("john"+index+"@gmail.com")
                .address("Rehovot")
                .description("The best friend")
                .build();
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();
        Assert.assertTrue(app.contact().isContactByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactByPhone(contact.getPhone()));
    }
    @Test (dataProvider = "validDataContact",dataProviderClass = MyDataProvider.class)
    public void addNewContactSuccessCSV(Contact contact){
        int index = (int)(System.currentTimeMillis()/1000)%3600;

        contact.setEmail("john"+index+"@gmail.com");
        contact.setPhone("12345678"+index);

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();
        Assert.assertTrue(app.contact().isContactByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactByPhone(contact.getPhone()));
    }


}
