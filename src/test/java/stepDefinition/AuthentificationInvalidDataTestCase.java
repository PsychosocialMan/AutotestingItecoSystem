package stepDefinition;

import data.Data;
import helper.HelpSteps;
import helper.InitialSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AuthentificationInvalidDataTestCase extends InitialSteps {
    @BeforeClass
    public void waitSecond() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test(dataProvider = "userFillsLoginFieldInvalid",
            dataProviderClass = Data.class,
            dependsOnMethods = {"checkPageName"})
    public void userFillsLoginFieldInvalid(String name, String login) throws InterruptedException {
        HelpSteps.userFillsFields(name, login);
    }

    @Test(dataProvider = "userFillsPasswordFieldInvalid",
            dataProviderClass = Data.class,
            dependsOnMethods = {"userFillsLoginFieldInvalid"})
    public void userFillsPasswordFieldInvalid(String id, String password) {
        HelpSteps.userFillsFields(id, password);
    }

    @Test(dependsOnMethods = {"userFillsPasswordFieldInvalid"},
            dataProvider = "userPushEnterButton",
            dataProviderClass = Data.class)
    public void userPushEnterButton(String element) throws Throwable {
        HelpSteps.pushElement(element);
    }

    @Test(dependsOnMethods = {"userPushEnterButton"},
            dataProvider = "checkWrongLoginOrPassword",
            dataProviderClass = Data.class)
    public void checkWrongLoginOrPassword(String message) {
        HelpSteps.checkElement(message);
    }

}

