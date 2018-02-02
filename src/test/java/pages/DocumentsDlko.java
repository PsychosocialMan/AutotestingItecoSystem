package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static helper.InitialSteps.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DocumentsDlko {
    public DocumentsDlko(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//table[@id='dlko-docs-assets']//input[@name='checkCell']")
    WebElement checkBoxChooseAsset;

    // Возможно, следует переписать элемент в рармка Page
    public void pushCheckBox(){
        checkBoxChooseAsset.click();
    }

    @FindBy(how = How.XPATH, using = "//li[@class='dropdown-submenu']/*[text()='Создать новый договор']")
    WebElement createDocumentButton;

    public void mouseOnCreateDocumentButton(){
        Actions action = new Actions(driver);
        action.moveToElement(createDocumentButton).build().perform();
    }

    @FindBy(how = How.XPATH, using = "(//self::node()[contains(text(), 'Договор с банком (ответственное хранение)')])[1]")
    WebElement documentWithBank;

    public void pushDocumentWithBank(){
        documentWithBank.click();
    }

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='col-md-3']/*[@class='form-control ng-pristine ng-untouched ng-valid']"))
    List<WebElement> mustBeDisabled;

    public void checkFieldsDisabled(){
        for (WebElement item : mustBeDisabled) {
            assertFalse(item.isEnabled());
        }
    }

    public void checkFirstElement(String value) throws InterruptedException {
        Thread.sleep(1000);
        assertEquals(mustBeDisabled.get(0).getAttribute("value"), value);
    }

    public void checkSecondElement(String value){
        assertEquals(mustBeDisabled.get(1).getAttribute("value"), value);
    }

    @FindAll(@FindBy(how = How.XPATH, using = "//input[@type=\"checkbox\"]/.."))
    List<WebElement> checkBoxesProperties;

    public void checCheckboxesNames(String[] names){
        for (int i = 0; i < checkBoxesProperties.size(); i++) {
            assertTrue(checkBoxesProperties.get(i).getText().contains(names[i]));
        }
    }
}
