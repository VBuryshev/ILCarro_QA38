package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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

    public void logout()
    {
        click(By.cssSelector("a[href$='/logout?url=%2Fsearch']"));
    }

    public void openLoginForm()
    {
        wd.findElement(By.xpath("//*[.=' Log in ']")).click();
    }
    public void openRegistrationForm()
    {
        wd.findElement(By.xpath("//*[.=' Sign up ']")).click();
    }

    public void fillLoginForm(String email, String password)
    {
        type(By.xpath("//*[@id=\"email\"]"), email);
        //type(By.xpath("//*[@id=\"password\"]"), password);
        type(By.xpath("*[@id=\"password\"]"), password);
    }
    public void fillLoginForm(User user)
    {
        type(By.xpath("//*[@id=\"email\"]"), user.getEmail());
        //type(By.xpath("//*[@id=\"password\"]"), user.getPassword());
        type(By.xpath("//*[@id=\"password\"]"), user.getPassword());

    }
    public void fillRegistrationForm(User user)
    {
        type(By.xpath("//*[@id=\"name\"]"), user.getName());
        type(By.xpath("//*[@id=\"lastName\"]"), user.getLastName());
        type(By.xpath("//*[@id=\"email\"]"), user.getEmail());
        type(By.xpath("//*[@id=\"password\"]"), user.getPassword());
        clickCheckBox();
    }

    public void clickCheckBox()
    {
        System.out.println("Clicked checkbox");
//        //variant 1
//        click(By.cssSelector("label[for='terms-of-use']"));
        //variant 2
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use').click()");
        //variant 3
        Rectangle rect = wd.findElement(By.cssSelector("div.checkbox-container")).getRect();
        int x = rect.getX() + 5;
        int y = rect.getY() + rect.getHeight() / 4;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x, y).click().perform();
    }
    public void submitLogin()
    {
        pause(3000);
        wd.findElement(By.xpath("//button[@type='submit']")).submit();
        //wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void successRegOkButton()
    {
        wd.findElement(By.xpath("//button[@type='button']")).click();
    }

    public boolean isLoggedSuccess()
    {
        return isElementPresent(By.xpath("//*[contains(text(),'success')]"));
    }

    public void login(User user)
    {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        successRegOkButton();
    }
}
