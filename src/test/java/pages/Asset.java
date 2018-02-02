package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static helper.InitialSteps.driver;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Asset {
    public Asset(WebDriver driver){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//self::node()[contains(text(),'Наименование ФО')]")
    private WebElement FOName;

    public void checkFOName(String string){
        assertTrue(FOName.getText().contains(string));
    }

    @FindBy(how = How.XPATH, using = "//self::node()[contains(text(),'Тип актива функциональный')]")
    private WebElement assetType;

    public void checkAssetType(String string){
        assertTrue(assetType.getText().contains(string));
    }

    @FindBy(how = How.XPATH, using = "//input[@name='orgName']")
    private WebElement selectOrg;

    public void checkSelectOrg(){
        assertFalse(selectOrg.isEnabled());
    }

    @FindBy(how = How.XPATH, using = "//select[@name='assetFunctionalType']")
    private WebElement assetFunctionalType;

    public void checkAssetFunctionalType(){
        assertTrue(assetFunctionalType.isEnabled());
    }

    @FindBy(how = How.XPATH, using = "(//a[text()='Инвентаризация'])[2]")
    private WebElement inventoryName;

    public void checkInventoryName(String arg){
        assertTrue(inventoryName.getText().equalsIgnoreCase(arg));
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Связи с активами']")
    private WebElement assetConnectionName;

    public void checkAssetConnectionName(String arg){
        assertTrue(assetConnectionName.getText().equalsIgnoreCase(arg));
    }


    @FindBy(how = How.XPATH, using = "//div[@class = 'col-md-12']/button[text()='Сохранить']")
    private WebElement saveButtonName;

    public boolean pushSaveButtonName() throws InterruptedException {
        saveButtonName.click();
        Thread.sleep(1500);
        try {
            driver.findElement(By.xpath("//div[@class='modal-content']"));
        }
        catch (NoSuchElementException e){
            return true;
        }
        driver.findElement(By.xpath("//button[text()='Нет']")).click();
        return false;
    }

    @FindBy(how = How.XPATH, using = "//self::node()[@id='assetgrid_checkAll']")
    private WebElement checkboxAll;

    public void pushCheckboxAll() throws InterruptedException {
        Thread.sleep(1000);
        checkboxAll.click();
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Да']")
    private WebElement yesButton;

    public void pushYesButton() throws InterruptedException {
        yesButton.click();
        Thread.sleep(1000);
    }
}
