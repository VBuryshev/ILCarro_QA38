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
        return isElementPresent(By.cssSelector("body > app-root > app-navigator > div.header > a:nth-child(5)"));
    }

    public void logout()
    {
        click(By.xpath("/html/body/app-root/app-navigator/div[1]/a[5]"));
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
}
