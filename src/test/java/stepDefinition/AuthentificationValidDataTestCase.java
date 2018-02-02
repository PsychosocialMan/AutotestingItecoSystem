package stepDefinition;

import data.Data;
import helper.HelpSteps;
import org.testng.Assert;
import org.testng.annotations.*;
import helper.InitialSteps;

import java.io.*;

public class AuthentificationValidDataTestCase extends InitialSteps {

    @BeforeClass
    public void waitSecond() throws InterruptedException, IOException {
        Thread.sleep(3000);
    }


    @Test(dataProvider = "userFillsValidLogin",
            dataProviderClass = Data.class,
            dependsOnMethods = {"checkPageName"})
    public void userFillsValidLogin(String name, String login) throws Throwable {
        HelpSteps.userFillsFields(name, login);
    }

    @Test(dataProvider = "userFillsValidPassword",
            dataProviderClass = Data.class,
            dependsOnMethods = {"userFillsValidLogin"})
    public void userFillsValidPassword(String name, String password) throws Throwable {
        HelpSteps.userFillsFields(name, password);
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

    @Test(dependsOnMethods = "pushChooseButton",
            dataProvider = "pushPreExitButton",
            dataProviderClass = Data.class)
    public void pushPreExitButton(String name) throws Throwable {
        HelpSteps.pushElement(name);
    }

    @Test(dependsOnMethods = "pushPreExitButton",
            dataProvider = "pushExitButton",
            dataProviderClass = Data.class)
    public void pushExitButton(String name) throws Throwable {
        HelpSteps.pushElement(name);
    }

}
