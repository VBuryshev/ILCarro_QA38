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

    }
//    @Test
//    public void loginPositive()
//    {
//        String email = "vasya@mail.com", password = "Act123456$";
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(email, password);
//        app.getUser().submitLogin();
//        app.getUser().pause(5000);
//        //Assert.assertTrue(app.getUser().isElementPresent(By.linkText("Logged in success")));
//        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("h1[class='title']")));
//        //Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("#mat-dialog-1 > app-error > div > div > button")));
//        app.getUser().logout();
//    }
    @Test
    public void loginPositiveUserData()
    {
        User user = new User()
                .withEmail("vasya@mail.com")
                .withPassword("Act123456");
        app.getUser().openLoginForm();
        app.getUser().pause(2000);
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
    }

    @AfterMethod
    public void postconditions()
    {

    }

}
