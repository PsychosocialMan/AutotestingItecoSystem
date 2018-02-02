package helper;


import data.Data;
import data.Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Asset;
import pages.DocumentsDlko;
import pages.SearchWindow;
import pages.TableReferenceBook;

public class InitialSteps {
    public static WebDriver driver;
    public static TableReferenceBook tableReferenceBook;
    public static SearchWindow searchWindow;
    public static Asset asset;
    public static DocumentsDlko dlko;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user.inv5423-pc\\Desktop\\driver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
            tableReferenceBook = new TableReferenceBook(driver);
            searchWindow = new SearchWindow(driver);
            asset = new Asset(driver);
            dlko = new DocumentsDlko(driver);
        }
        return driver;
    }

    @BeforeTest
    public void openBrowser() throws Throwable {
        driver = getDriver();
        driver.get(Options.url);
    }
    @Test(dataProvider = "checkPageName",
            dataProviderClass = Data.class)
    public void checkPageName(String string) throws Throwable {
        HelpSteps.checkElement(string);
    }

    @AfterTest
    public void closeBrowser()throws Throwable {
        driver.quit();
        driver=null;
    }

}
