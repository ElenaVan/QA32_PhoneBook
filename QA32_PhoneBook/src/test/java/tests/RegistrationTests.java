package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().logOut();
        }
    }




    @Test(groups = {"web"})
    public void registrationSuccess() {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("miomi"+index+"@gmail.com", "Mmiomi123$");
        System.out.println("miomi"+index+"@gmail.com");
        logger.info("miomi"+index+"@gmail.com");
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSucces());
    }




}
