package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().logOut();
        }
    }


    @Test
    public void loginSuccess(){
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm("miomi@gmail.com", "Mmiomi123$");
       app.getHelperUser().submitLogin();

       Assert.assertTrue(app.getHelperUser().isLoginRegistrationSucces());
    }
    @Test
    public void loginNegativeTestWrongPassword(){
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLoginRegistrationSucces());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }


}
