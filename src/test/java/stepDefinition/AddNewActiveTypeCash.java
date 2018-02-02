package stepDefinition;

import data.Data;
import helper.HelpSteps;
import helper.InitialSteps;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewActiveTypeCash extends InitialSteps {

    @BeforeClass
    public void waitSecond() throws InterruptedException {
        Thread.sleep(3000);
    }

    //------------------------------------------------------------------------
    //                  Ввод валидных логина-пароля и выбор организации
    //------------------------------------------------------------------------


    // Ввод валидного логина
    @Test(dataProvider = "userFillsValidLogin",
            dataProviderClass = Data.class,
            dependsOnMethods = {"checkPageName"})
    public void userFillsValidLogin(String name, String login) throws Throwable {
        HelpSteps.userFillsFields(name, login);
    }

    // Ввод валидного пароля
    @Test(dataProvider = "userFillsValidPassword",
            dataProviderClass = Data.class,
            dependsOnMethods = {"userFillsValidLogin"})
    public void userFillsValidPassword(String name, String password) throws Throwable {
        HelpSteps.userFillsFields(name, password);
    }

    // Нажатие на кнопку "Войти"
    @Test(dependsOnMethods = {"userFillsValidPassword"},
            dataProvider = "userPushEnterButton",
            dataProviderClass = Data.class
    )
    public void userPushEnterButton(String element) throws Throwable {
        HelpSteps.pushElement(element);
        Thread.sleep(1000);
    }

    // Проверка открытия модального окна с выбором организации
    @Test(dependsOnMethods = {"userPushEnterButton"},
            dataProvider = "checkModalWindowName",
            dataProviderClass = Data.class)
    public void checkModalWindowName(String name) throws InterruptedException {
        HelpSteps.checkElement(name);
    }

    // Выбор организации
    @Test(dependsOnMethods = {"checkModalWindowName"},
            dataProvider = "userChooseOrganization",
            dataProviderClass = Data.class
    )
    public void userChooseOrganization(String element) throws Throwable {
        HelpSteps.pushElement(element);
    }

    // Нажатие на кнопку "Выбрать"
    @Test(dependsOnMethods = {"userChooseOrganization"},
            dataProvider = "pushChooseButton",
            dataProviderClass = Data.class)
    public void pushChooseButton(String name) throws Throwable {
        HelpSteps.pushElement(name);
    }

    // Проверка логотипа компании
    @Test(dependsOnMethods = {"pushChooseButton"},
            dataProvider = "checkLogoName",
            dataProviderClass = Data.class)
    public void checkLogoName(String logo) {
        HelpSteps.checkLogoName(logo);
    }

    // Проверка имени компании
    @Test(dataProvider = "checkOrganizationName",
            dataProviderClass = Data.class,
            dependsOnMethods = {"pushChooseButton"})
    public void checkOrganizationName(String name) {
        HelpSteps.checkElement(name);
    }

    //-------------------------------------------------------------------------------------
    //                      Проверка номера счета
    //-------------------------------------------------------------------------------------

    // Нажатие на пункт меню "Настройка"
    @Test(dependsOnMethods = "checkOrganizationName",
            dataProvider = "pushSettingsBar",
            dataProviderClass = Data.class)
    public void pushSettingsBar(String name) {
        HelpSteps.pushBar(name);
    }

    // Нажатие на пункт "Справочники" в меню "Настройка"
    @Test(dependsOnMethods = "pushSettingsBar",
            dataProvider = "pushReferenceBooks",
            dataProviderClass = Data.class)
    public void pushReferenceBooks(String name) throws InterruptedException {
        Thread.sleep(3000);
        HelpSteps.pushElement(name);
    }

    // Проверка страницы "Справочники"
    @Test(dependsOnMethods = "pushReferenceBooks",
            dataProvider = "pushReferenceBooks",
            dataProviderClass = Data.class)
    public void checkDictionaryName(String name) throws Throwable {
        HelpSteps.checkFormName(name);
    }

    // Переход на страницу "План счетов по КО"
    @Test(dependsOnMethods = "checkDictionaryName")
    public void pushAccountNumber() {
        tableReferenceBook.pushLinkField();
    }

    // Нажатие на иконку "Поиск"
    @Test(dependsOnMethods = "pushAccountNumber")
    public void pushSearchIcon() throws InterruptedException {
        searchWindow.pushSearchIcon();
    }

    // Проверка окна поиска
    @Test(dependsOnMethods = "pushSearchIcon",
            dataProvider = "checkSearchWindow",
            dataProviderClass = Data.class)
    public void checkSearchWindow(String name) {
        HelpSteps.checkElement(name);
    }

    // Ввод первой опции фильтра (значение "Номер счета второго порядка")
    @Test(dependsOnMethods = "checkSearchWindow",
            dataProvider = "pushFirstSearchOption",
            dataProviderClass = Data.class)
    public void pushFirstSearchOption(String name) {
        HelpSteps.pushOption(name);
    }

    // Ввод второй опции фильтра (значение "начинается с")
    @Test(dependsOnMethods = "pushFirstSearchOption",
            dataProvider = "pushSecondSearchOption",
            dataProviderClass = Data.class)
    public void pushSecondSearchOption(String name) {
        HelpSteps.pushOption(name);
    }

    // Ввод третьей опции фильтра (значение 202)
    @Test(dependsOnMethods = "pushSecondSearchOption",
            dataProvider = "fillsSearchOption",
            dataProviderClass = Data.class)
    public void fillsSearchOption(String data) {
        searchWindow.fillSearchTextField(data);
    }

    // Нажатие на кнопку поиска
    @Test(dependsOnMethods = {"pushFirstSearchOption", "pushSecondSearchOption", "fillsSearchOption"},
            dataProvider = "pushSearchButton",
            dataProviderClass = Data.class)
    public void pushSearchButton(String name) {
        HelpSteps.pushElement(name);
    }

    // Проверка существования хотя бы одного элемента с указанными требованиями (счета 202хх)
    @Test(dependsOnMethods = "pushSearchButton",
            dataProvider = "checkPresenseOfElements",
            dataProviderClass = Data.class)
    public void checkPresenseOfElements(String value) throws InterruptedException {
        HelpSteps.checkPresenseOfElement(value);
    }

    //---------------------------------------------------------------------------------
    //                        Создание актива типа "Денежные средства"
    //---------------------------------------------------------------------------------

    // Нажатие на пункт меню "Сбор и ведение данных"
    @Test(dependsOnMethods = "checkPresenseOfElements",
            dataProvider = "pushCollectionAndMaintenanceofData",
            dataProviderClass = Data.class)
    public void pushCollectionAndMaintenanceofData(String name) throws InterruptedException {
        HelpSteps.pushBar(name);
        Thread.sleep(1000);
    }

    // Нажатие на пункт "Список активов"
    @Test(dependsOnMethods = "pushCollectionAndMaintenanceofData",
            dataProvider = "pushAssetList",
            dataProviderClass = Data.class)
    public void pushAssetList(String name){
        HelpSteps.pushElement(name);
    }

    // Проверка страницы "Список активов"
    @Test(dependsOnMethods = "pushAssetList",
            dataProvider = "pushAssetList",
            dataProviderClass = Data.class)
    public void checkAssetListName(String name) throws InterruptedException {
        HelpSteps.checkFormName(name);
    }

    // Нажатие кнопки "Создать"
    @Test(dependsOnMethods = "checkAssetListName",
            dataProvider = "pushCreateButton",
            dataProviderClass = Data.class)
    public void pushCreateButton(String name) {
        HelpSteps.pushElement(name);
    }

    // Проверка страницы "Создание актива (первый этап)"
    @Test(dependsOnMethods = "pushCreateButton",
            dataProvider = "checkAssetListFirstStep",
            dataProviderClass = Data.class)
    public void checkAssetListFirstStep(String name) {
        HelpSteps.checkElement(name);
    }

    // Проверка наличия поля "Наименование ФО"
    @Test(dependsOnMethods = "pushCreateButton",
            dataProvider = "checkFOName",
            dataProviderClass = Data.class)
    public void checkFOName(String name) {
        asset.checkFOName(name);
    }

    // Проверка наличия поля "Тип актива"
    @Test(dependsOnMethods = "pushCreateButton",
            dataProvider = "checkAssetType",
            dataProviderClass = Data.class)
    public void checkAssetType(String name) {
        asset.checkAssetType(name);
    }

    // Проверка выпадающих стисков на доступность
    @Test(dependsOnMethods = "pushCreateButton")
    public void checkSelectOrg() {
        asset.checkSelectOrg();
    }

    //------||-----
    @Test(dependsOnMethods = "pushCreateButton")
    public void checkAssetFunctionalType() {
        asset.checkAssetFunctionalType();
    }

    // Выбор значения для поля "Тип актива функциональный"
    @Test(dependsOnMethods = "checkAssetFunctionalType",
            dataProvider = "pushAssetFunctionalType",
            dataProviderClass = Data.class)
    public void pushAssetFunctionalType(String value) {
        HelpSteps.pushOption(value);
    }

    // Нажатие на кнопку "Далее"
    @Test(dependsOnMethods = "pushAssetFunctionalType",
            dataProvider = "pushContinueButton",
            dataProviderClass = Data.class)
    public void pushContinueButton(String name) {
        HelpSteps.pushElement(name);
    }

    // Проверка страницы "Создание актива (второй этап)"
    @Test(dependsOnMethods = "pushContinueButton",
            dataProvider = "checkAssetListSecondStep",
            dataProviderClass = Data.class)
    public void checkAssetListSecondStep(String name) throws InterruptedException {
        Thread.sleep(1000);
        HelpSteps.checkElement(name);
    }

    // Проверка основных ссылок на странице
    @Test(dependsOnMethods = "checkAssetListSecondStep",
            dataProvider = "checkMainAssetLinks",
            dataProviderClass = Data.class)
    public void checkMainAssetLinks(String[] params) {
        for (String item : params) {
            HelpSteps.checkElement(item);
        }
    }

    // Проверка ссылки "Инвентаризация"
    @Test(dependsOnMethods = "checkAssetListSecondStep",
            dataProvider = "checkInventoryName",
            dataProviderClass = Data.class)
    public void checkInventoryName(String name) {
        asset.checkInventoryName(name);
    }

    // Проверка ссылки "Связи с активами"
    @Test(dependsOnMethods = "checkAssetListSecondStep",
            dataProvider = "checkAssetConnectionName",
            dataProviderClass = Data.class)
    public void checkAssetConnectionName(String name) {
        asset.checkAssetConnectionName(name);
    }

    // Заполнение поля "Номер счета"
    @Test(dependsOnMethods = "checkMainAssetLinks",
            dataProvider = "userFillsAccountNumber",
            dataProviderClass = Data.class)
    public void userFillsAccountNumber(String name, String data) {
        HelpSteps.userFillsFields(name, data);
    }

    // Заполнение поля "Начальная балансовая стоимость"
    @Test(dependsOnMethods = "checkMainAssetLinks",
            dataProvider = "userFillsBalanceInitial",
            dataProviderClass = Data.class)
    public void userFillsBalanceInitial(String name, String data) {
        HelpSteps.userFillsFields(name, data);
    }


    // Заполнение поля "Название актива"
    @Test(dependsOnMethods = "checkMainAssetLinks",
            dataProvider = "userFillsAssetName",
            dataProviderClass = Data.class)
    public void userFillsAssetName(String name, String data) {
        HelpSteps.userFillsFields(name, data);
    }

    // Проверка выпадающего списка "Валюта"
    @Test(dependsOnMethods = "userFillsAccountNumber",
            dataProvider = "checkCurrency",
            dataProviderClass = Data.class)
    public void checkCurrency(String name) {
        HelpSteps.checkNotEmptySelect(name);
    }

    // Проверка эквивалентности полей "Начальная балансовая стоимость" и "Текущая балансовая стоимость"
    @Test(dependsOnMethods = "userFillsBalanceInitial",
            dataProvider = "checkCurrentBalanceName",
            dataProviderClass = Data.class)
    public void checkCurrentBalanceName(String name1, String name2) {
        HelpSteps.checkEqualsTwoTextFields(name1, name2);
    }

    // Проверка полей "В валюте счета" на непустое значение
    @Test(dependsOnMethods = {"userFillsBalanceInitial", "userFillsAccountNumber"},
            dataProvider = "checkBalanceInitialCurrency",
            dataProviderClass = Data.class)
    public void checkBalanceInitialCurrency(String name) {
        HelpSteps.checkNotEmptyTextField(name);
    }

    //-------------||----------
    @Test(dependsOnMethods = {"checkCurrentBalanceName", "userFillsAccountNumber"},
            dataProvider = "checkCurrentBalanceCurrency",
            dataProviderClass = Data.class)
    public void checkCurrentBalanceCurrency(String name) {
        HelpSteps.checkNotEmptyTextField(name);
    }

    // Нажатие на ссылку "Прием"
    @Test(dependsOnMethods = {"userFillsAssetName", "userFillsAccountNumber", "userFillsBalanceInitial"},
            dataProvider = "pushReceivingButton",
            dataProviderClass = Data.class)
    public void pushReceivingButton(String name) {
        HelpSteps.pushElement(name);
    }

    // Ввод даты начала дейсвия актива
    @Test(dependsOnMethods = "pushReceivingButton",
            dataProviderClass = Data.class,
            dataProvider = "userFillsStartDate")
    public void userFillsStartDate(String name, String data) throws InterruptedException {
        Thread.sleep(1000);
        HelpSteps.userFillsFields(name, data);
    }

    // Ввод даты окончания действия актива
    @Test(dependsOnMethods = "userFillsStartDate",
            dataProviderClass = Data.class,
            dataProvider = "userFillsEndDate")
    public void userFillsEndDate(String name, String data) {
        HelpSteps.userFillsFields(name, data);
    }

    // Нажатие на кнопку сохранить
    @Test(dependsOnMethods = {"userFillsStartDate", "userFillsEndDate"})
    public void pushSaveButton() throws InterruptedException {
        asset.pushSaveButtonName();
    }

    //----------------------------------------------------------------
    //                  Проверка создания актива
    //---------------------------------------------------------------

    // Нажатие на пункт меню "Сбор и ведение данных"
    @Test(dependsOnMethods = "pushSaveButton",
            dataProvider = "pushCollectionAndMaintenanceofData",
            dataProviderClass = Data.class)
    public void pushCollectionAndMaintenanceofDataToCheck(String name) throws InterruptedException {
        Thread.sleep(1000);
        HelpSteps.pushBar(name);
    }

    // Нажатие на пункт "Список активов"
    @Test(dependsOnMethods = "pushCollectionAndMaintenanceofDataToCheck",
            dataProvider = "pushAssetList",
            dataProviderClass = Data.class)
    public void pushAssetListToCheck(String name){
        HelpSteps.pushElement(name);
    }

    // Нажатие на иконку "Поиск"
    @Test(dependsOnMethods = "pushAssetListToCheck")
    public void pushSearchIconToCheck() throws InterruptedException {
        searchWindow.pushSearchIcon();
    }

    // Проверка окна поиска
    @Test(dependsOnMethods = "pushSearchIconToCheck",
            dataProvider = "checkSearchWindow",
            dataProviderClass = Data.class)
    public void checkSearchWindowToCheck(String name) {
        HelpSteps.checkElement(name);
    }

    // Ввод первой опции фильтра (значение "Номер лицевого счета")
    @Test(dependsOnMethods = "checkSearchWindowToCheck",
            dataProvider = "pushFirstSearchOptionToCheck",
            dataProviderClass = Data.class)
    public void pushFirstSearchOptionToCheck(String name) {
        HelpSteps.pushOption(name);
    }

    // Ввод второй опции фильтра (значение "начинается с")
    @Test(dependsOnMethods = "pushFirstSearchOptionToCheck",
            dataProvider = "pushSecondSearchOption",
            dataProviderClass = Data.class)
    public void pushSecondSearchOptionToCheck(String name) {
        HelpSteps.pushOption(name);
    }

    // Ввод третьей опции фильтра (значение 202)
    @Test(dependsOnMethods = "pushSecondSearchOptionToCheck",
            dataProvider = "fillsSearchOptionToCheck",
            dataProviderClass = Data.class)
    public void fillsSearchOptionToCheck(String data) {
        searchWindow.fillSearchTextField(data);
    }

    // Нажатие на кнопку поиска
    @Test(dependsOnMethods = {"pushFirstSearchOptionToCheck", "pushSecondSearchOptionToCheck", "fillsSearchOptionToCheck"},
            dataProvider = "pushSearchButton",
            dataProviderClass = Data.class)
    public void pushSearchButtonToCheck(String name) {
        HelpSteps.pushElement(name);
    }

    // Проверка по номеру счета создание нового актива
    @Test(dependsOnMethods = "pushSearchButtonToCheck",
            dataProvider = "checkPresenseOfAsset",
            dataProviderClass = Data.class)
    public void checkPresenseOfAsset(String value) throws InterruptedException {
        HelpSteps.checkPresenseOfElement(value);
    }

    //-----------------------------------------------------------------
    //                  Удаление тестовых данных
    //-----------------------------------------------------------------

    // Выбор чекбокса для последующего удаления записей
    @Test(dependsOnMethods = "checkPresenseOfAsset")
    public void pushCheckboxToDelete() throws InterruptedException {
        asset.pushCheckboxAll();
    }

    // Нажатие на кнопку "Удалить"
    @Test(dependsOnMethods = "pushCheckboxToDelete",
    dataProvider = "pushDeleteButton",
    dataProviderClass = Data.class)
    public void pushDeleteButton(String name){
        HelpSteps.pushElement(name);
    }

    // Нажатие на кнопку "Да"
    @Test(dependsOnMethods = "pushDeleteButton")
    public void pushYesButton() throws InterruptedException {
        asset.pushYesButton();
    }

    // Нажатие на кнопку "Закрыть"
    @Test(dependsOnMethods = "pushYesButton",
    dataProvider = "pushCloseButton",
    dataProviderClass = Data.class)
    public void pushCloseButton(String name){
        HelpSteps.pushElement(name);
    }


    //-----------------------------------------------------------------
    //                  Выход из учетной записи
    //-----------------------------------------------------------------


    // Нажатие на пункт "Права Все"
    @Test(dependsOnMethods = "pushYesButton",
            dataProvider = "pushPreExitButton",
            dataProviderClass = Data.class)
    public void pushPreExitButton(String name) throws Throwable {
        Thread.sleep(1000);
        HelpSteps.pushElement(name);
    }

    // Нажатие на кнопку "Выход"
    @Test(dependsOnMethods = "pushPreExitButton",
            dataProvider = "pushExitButton",
            dataProviderClass = Data.class)
    public void pushExitButton(String name){
        HelpSteps.pushElement(name);
    }

}
