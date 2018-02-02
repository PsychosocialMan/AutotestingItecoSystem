package stepDefinition;

import data.Data;
import helper.HelpSteps;
import helper.InitialSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckAccountNumberBegins extends InitialSteps {
    @BeforeClass
    public void waitSecond() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test(dataProvider = "userFillsValidLogin",
            dataProviderClass = Data.class,
            dependsOnMethods = {"checkPageName"})
    public void userFillsValidLogin(String id, String login) throws Throwable {
        HelpSteps.userFillsFields(id, login);
    }

    @Test(dataProvider = "userFillsValidPassword",
            dataProviderClass = Data.class,
            dependsOnMethods = {"userFillsValidLogin"})
    public void userFillsValidPassword(String id, String password) throws Throwable {
        HelpSteps.userFillsFields(id, password);
    }

    @Test(dependsOnMethods = {"userFillsValidPassword"},
            dataProvider = "userPushEnterButton",
            dataProviderClass = Data.class
    )
    public void userPushEnterButton(String element) throws Throwable {
        HelpSteps.pushElement(element);
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"userPushEnterButton"},
            dataProvider = "checkModalWindowName",
            dataProviderClass = Data.class)
    public void checkModalWindowName(String name) throws InterruptedException {
        HelpSteps.checkElement(name);
    }

    @Test(dependsOnMethods = {"checkModalWindowName"},
            dataProvider = "userChooseOrganization",
            dataProviderClass = Data.class
    )
    public void userChooseOrganization(String element) throws Throwable {
        HelpSteps.pushElement(element);
    }

    @Test(dependsOnMethods = {"userChooseOrganization"},
            dataProvider = "pushChooseButton",
            dataProviderClass = Data.class)
    public void pushChooseButton(String name) throws Throwable {
        HelpSteps.pushElement(name);
    }

    @Test(dependsOnMethods = {"pushChooseButton"},
            dataProvider = "checkLogoName",
            dataProviderClass = Data.class)
    public void checkLogoName(String logo) {
        HelpSteps.checkLogoName(logo);
    }

    @Test(dataProvider = "checkOrganizationName",
            dataProviderClass = Data.class,
            dependsOnMethods = {"pushChooseButton"})
    public void checkOrganizationName(String name) {

        HelpSteps.checkElement(name);
    }

    @Test(dependsOnMethods = "checkOrganizationName",
            dataProvider = "pushSettingsBar",
            dataProviderClass = Data.class)
    public void pushSettingsBar(String name) {
        HelpSteps.pushBar(name);
    }

    @Test(dependsOnMethods = "pushSettingsBar",
            dataProvider = "pushReferenceBooks",
            dataProviderClass = Data.class)
    public void pushReferenceBooks(String name) throws InterruptedException {
        Thread.sleep(3000);
        HelpSteps.pushElement(name);
    }

    @Test(dependsOnMethods = "pushReferenceBooks",
            dataProvider = "pushReferenceBooks",
            dataProviderClass = Data.class)
    public void checkDictionaryName(String name) throws Throwable {
        HelpSteps.checkFormName(name);
    }

    @Test(dependsOnMethods = "checkDictionaryName")
    public void pushAccountNumber() {
        tableReferenceBook.pushLinkField();
    }

    @Test(dependsOnMethods = "pushAccountNumber")
    public void pushSearchIcon() throws InterruptedException {
        searchWindow.pushSearchIcon();
    }

    @Test(dependsOnMethods = "pushSearchIcon",
            dataProvider = "checkSearchWindow",
            dataProviderClass = Data.class)
    public void checkSearchWindow(String name) {
        HelpSteps.checkElement(name);
    }

    @Test(dependsOnMethods = "checkSearchWindow",
            dataProvider = "pushFirstSearchOption",
            dataProviderClass = Data.class)
    public void pushFirstSearchOption(String name) {
        HelpSteps.pushOption(name);
    }

    @Test(dependsOnMethods = "checkSearchWindow",
            dataProvider = "pushSecondSearchOption",
            dataProviderClass = Data.class)
    public void pushSecondSearchOption(String name) {
        HelpSteps.pushOption(name);
    }

    @Test(dependsOnMethods = "checkSearchWindow",
            dataProvider = "fillsSearchOption",
            dataProviderClass = Data.class)
    public void fillsSearchOption(String data) {
        searchWindow.fillSearchTextField(data);
    }

    @Test(dependsOnMethods = {"pushFirstSearchOption", "pushSecondSearchOption", "fillsSearchOption"},
            dataProvider = "pushSearchButton",
            dataProviderClass = Data.class)
    public void pushSearchButton(String name) {
        HelpSteps.pushElement(name);
    }

    @Test(dependsOnMethods = "pushSearchButton",
            dataProvider = "checkPresenseOfElements",
            dataProviderClass = Data.class)
    public void checkPresenseOfElements(String value) throws InterruptedException {
        HelpSteps.checkPresenseOfElement(value);
    }
    //-----------------------------------------------------------------
    //                  Выход из учетной записи
    //-----------------------------------------------------------------

    // Нажатие на пункт "Права Все"
    @Test(dependsOnMethods = "checkPresenseOfElements",
            dataProvider = "pushPreExitButton",
            dataProviderClass = Data.class)
    public void pushPreExitButton(String name) throws Throwable {
        HelpSteps.pushElement(name);
    }

    // Нажатие на кнопку "Выход"
    @Test(dependsOnMethods = "pushPreExitButton",
            dataProvider = "pushExitButton",
            dataProviderClass = Data.class)
    public void pushExitButton(String name) throws Throwable {
        HelpSteps.pushElement(name);
    }

}
