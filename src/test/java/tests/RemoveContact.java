package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().login(new User().withEmail("miomi@gmail.com").withPassword("Mmiomi123$"));
        }
        app.contact().provideContactData();
    }
    @Test(groups = {"web"},priority = 2)
    public void removeOneContact(){
        //count before

        Assert.assertEquals(app.contact().removeContact(),1);
        //count after
        //assert(before -after,1

    }


    @Test(priority = 1)
    public void removeAllContacts(){
        app.contact().removeAllContacts();


    }
}
