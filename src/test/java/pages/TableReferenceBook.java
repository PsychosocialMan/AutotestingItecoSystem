package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class TableReferenceBook {

    public TableReferenceBook(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }


    @FindBy(how = How.XPATH, using = "//a[text()='План счетов  по КО']")
    private WebElement linkField;

    public void pushLinkField() {
        linkField.click();
    }


}
