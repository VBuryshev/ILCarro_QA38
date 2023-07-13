import com.sun.tracing.Provider;
import manager.HelperUser;
import manager.ProviderData;
import manager.TestNgListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNgListener.class)

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
        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }

    @Test( dataProvider = "userDTO",dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user)
    {
//        User user = new User()
//                .withEmail("vasya@mail.com")
//                .withPassword("Act123456$");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }

    @AfterMethod
    public void postconditions()
    {
        app.getUser().successRegOkButton();
        app.getUser().pause(2000);
        app.getUser().logout();
    }

}
