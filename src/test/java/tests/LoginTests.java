package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().logOut();
        }
    }


    @Test(dataProvider = "validLoginData",dataProviderClass = MyDataProvider.class)
    public void loginSuccess(String email, String password){
        logger.info("Test start with email: "+email+ " and password: "+password );
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm(email, password);
       app.getHelperUser().submitLogin();

       //Assert.assertTrue(app.getHelperUser().isLoginRegistrationSucces());
       logger.info("Test passed");
    }
    @Test (dataProvider = "validModelLogin", dataProviderClass = MyDataProvider.class)
    public void loginModelDataProvider(User user){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSucces());
    }

    @Test (dataProvider = "validModelCSV", dataProviderClass = MyDataProvider.class)
    public void loginModelDataProviderCSV(User user){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSucces());
    }



    @Test(groups = {"web"})
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
