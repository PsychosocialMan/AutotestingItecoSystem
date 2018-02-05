package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static helper.InitialSteps.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class HelpSteps {

    public static void userFillsFields(String name, String data) {
        WebElement element;
        (element = driver.findElement(By.xpath("//input[@name='" + name + "'] | //textarea[@name='" + name + "']"))).clear();
        element.sendKeys(data);
        element.sendKeys(Keys.TAB);
    }

    public static void pushElement(String element) {
        driver.findElement(By.xpath("//self::node()[text()='" + element + "']")).click();
    }

    public static void pushBar(String element) {
        driver.findElement(By.xpath("//li[contains(@class,'dropdown')]/a[contains(text(), '" + element + "')]")).click();
    }

    public static void checkLogoName(String element) {
        WebElement el = driver.findElement(By.xpath("//img[@title='" + element + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        el.isDisplayed();
    }

    public static void checkElement(String element) {
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + element + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        el.isDisplayed();
        assertTrue(el.getText().equalsIgnoreCase(element));
    }

    public static void pushOption(String element) {
        driver.findElement(By.xpath("//option[text()='" + element + "']")).click();
    }

    public static boolean checkPresenseOfElement(String element) throws InterruptedException {
        Thread.sleep(1000);
        boolean flag = false;
        List<WebElement> list = driver.findElements(By.xpath("//self::node()[text()='" + element + "']"));
        if (list.size() > 0) {
            flag = true;
        }
        assertTrue(flag);
        return flag;
    }

    public static void checkFormName(String element) throws InterruptedException {
        Thread.sleep(1000);
        WebElement el = driver.findElement(By.xpath("(//self::node()[text()='" + element + "'])[2]"));
        el.isDisplayed();
        assertTrue(el.getText().equalsIgnoreCase(element));
    }

    public static void checkNotEmptyTextField(String name) {
        WebElement el = driver.findElement(By.xpath("//self::node()[@name='" + name + "']"));
        assertFalse(el.getAttribute("value").isEmpty());
    }

    public static void checkEqualsTwoTextFields(String name1, String name2) {
        WebElement el1 = driver.findElement(By.xpath("//self::node()[@name='" + name1 + "']"));
        WebElement el2 = driver.findElement(By.xpath("//self::node()[@name='" + name2 + "']"));
        assertEquals(el1.getAttribute("value"), el2.getAttribute("value"));
    }

    public static void checkNotEmptySelect(String name) {
        WebElement el = driver.findElement(By.xpath("//self::node()[@name='" + name + "']"));
        Select element = new Select(el);
        assertFalse(element.getFirstSelectedOption().getText().isEmpty());
    }

    public static void pushElementContains(String name){
        driver.findElement(By.xpath("//self::node()[contains(text(),'" + name + "')]")).click();
    }

    public static void checkElementContains(String element) {
        WebElement el = driver.findElement(By.xpath("//self::node()[contains(text(),'" + element + "')]"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        el.isDisplayed();
        assertTrue(el.getText().contains(element));
    }

    public static void checkPresenceOfDocumentByDateAndNumber(String number, String date){
        WebElement tr = driver.findElement(By.xpath("//td[text()='" + number + "']/.."));
        assertTrue(tr.equals(driver.findElement(By.xpath("//td[text()='" + date + "']/.."))));
    }
}
