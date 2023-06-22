import manager.HelperUser;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    //HW_07_Task_1
    @BeforeMethod
    public void preconditions()
    {
        if(app.getUser().isLogged())
        {
            app.getUser().logout();
        }

//        if(app.getUser().isLogged2())              //kak sdelat` vtoroje uslovije proverki ???? esli tablichki net, chtoby proverit` po drugomu elementu
//        {
//            app.getUser().logout();
//        }
    }

    @Test
    public void loginPositiveUserData()
    {
        User user = new User()
                .withEmail("vasya@mail.com")
                .withPassword("Act123456$");
        app.getUser().openLoginForm();
        app.getUser().pause(3000);
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*['Loggedin']"))); //- pochemu eto RABOTAET ???? AHHHRRR, v teorii tut false i padajet. Ne pravilno propisan selectror , bez probela
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[contains(text(),'Logged in')]")));
        app.getUser().successRegOkButton();
    }

    @AfterMethod
    public void postconditions()
    {
        app.getUser().pause(5000);
        app.getUser().logout();
    }

}
