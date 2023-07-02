import manager.TestNgListener;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
public class RegistrationsTests extends TestBase
{
    @BeforeMethod
    public void preconditions()
    {
        if(app.getUser().isLogged())
        {
            app.getUser().logout();
        }
    }

    @Test
    public void registrationPositive()
    {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Vasya")
                .withLastName("Pupkin")
                .withEmail("vasya" + i + "@gmail.com")
                .withPassword("Act123456$");
        app.getUser().openRegistrationForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitLogin();
        logger.info("registrationPositive starts with credentials : login was - "
                + user.getEmail() +" " + "password was - " + user.getPassword());
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void registrationNegativeWrongEmail()
    {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Vasya")
                .withLastName("Pupkin")
                .withEmail("vasya" + i + "gmail.com")
                .withPassword("Act123456$");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @Test
    public void registrationNegativeWrongPassword()
    {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Vasya")
                .withLastName("Pupkin")
                .withEmail("vasya" + i + "@gmail.com")
                .withPassword("Act123456");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        //Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @AfterMethod
    public void postconditions()
    {
        app.getUser().successRegOkButton();
    }

}
