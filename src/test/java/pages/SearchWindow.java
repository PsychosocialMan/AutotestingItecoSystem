package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SearchWindow {
    public SearchWindow(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//td[@class='data']/input[@type='text']")
    WebElement searchTextField;

    public void fillSearchTextField(String value) {
        searchTextField.clear();
        searchTextField.sendKeys(value);
    }

    @FindBy(how = How.XPATH, using = "//input[@value='+']")
    WebElement plus;

    public void pushPlus() {
        plus.click();
    }

    @FindBy(how = How.XPATH, using = "//span[@class='ui-icon fa fa-search fa-fw']")
    private WebElement searchIcon;

    public void pushSearchIcon() throws InterruptedException {
        Thread.sleep(4000);
        searchIcon.click();
    }
}
