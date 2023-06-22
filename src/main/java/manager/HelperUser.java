package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class HelperUser extends HelperBase
{
    public HelperUser(WebDriver wd)
    {
        super(wd);
    }
    public boolean isLogged()
    {
        pause(2000);
        return isElementPresent(By.xpath("//*[.='Logged in success']"));
    }

    public boolean isLogged2()
    {
        pause(2000);
        return isElementPresent(By.cssSelector("div[class='header'] a:nth-child(1)"));
    }

    public void logout()
    {
        click(By.cssSelector("a[href$='/logout?url=%2Fsearch']"));
    }

    public void openLoginForm()
    {
        wd.findElement(By.xpath("//*[.=' Log in ']")).click();
    }

    public void fillLoginForm(String email, String password)
    {
        type(By.xpath("//*[@id=\"email\"]"), email);
        type(By.xpath("//*[@id=\"password\"]"), password);
    }
    public void fillLoginForm(User user)
    {
        type(By.xpath("//*[@id=\"email\"]"), user.getEmail());
        type(By.xpath("//*[@id=\"password\"]"), user.getPassword());
    }

    public void submitLogin()
    {
        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    public void successRegOkButton()
    {
        wd.findElement(By.xpath("//button[@type='button']")).click();
    }
}
