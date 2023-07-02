package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverListener extends AbstractWebDriverEventListener
{
    Logger logger = LoggerFactory.getLogger(WebDriverListener.class);

    public WebDriverListener()
    {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver)
    {
        super.beforeFindBy(by, element, driver);
        logger.info("Start searching element ----->>>> " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver)
    {
        super.afterFindBy(by, element, driver);
        logger.info("Element with locator --->>> " + by + " is found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver)
    {
        super.onException(throwable, driver);
        logger.info("U have an ERROR: ");
        logger.info(throwable.getMessage());
        logger.info(throwable.fillInStackTrace().toString());
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String link = "src/test/screenshots/scrsht - " + i + ".jpg";
        HelperBase helperbase = new HelperBase(driver);
        helperbase.takeScreenshot(link);
        logger.info("To watch what happened open this link with error on screenshot --->> " + link);
    }

}