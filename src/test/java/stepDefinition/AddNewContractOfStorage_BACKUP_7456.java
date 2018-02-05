package stepDefinition;

import data.Data;
import helper.HelpSteps;
import helper.InitialSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewContractOfStorage extends InitialSteps {
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

    //---------------------------------------------------------------------
    //             Переход на страницу "Документы ДЛКО"
    //---------------------------------------------------------------------

    // Нажатие на пункт меню "Сбор и ведение данных"
    @Test(dependsOnMethods = "checkOrganizationName",
            dataProvider = "pushCollectionAndMaintenanceofData",
            dataProviderClass = Data.class)
    public void pushCollectionAndMaintenanceofData(String name) throws InterruptedException {
        HelpSteps.pushBar(name);
        Thread.sleep(3000);
    }

    // Нажатие на пункт "Документы ДЛКО"
    @Test(dependsOnMethods = "pushCollectionAndMaintenanceofData",
            dataProvider = "pushDocumentsDLKO",
            dataProviderClass = Data.class)
    public void pushDocumentsDLKO(String name) {
        HelpSteps.pushElement(name);
    }

    // Проверка страницы "Документы ДЛКО"
    @Test(dependsOnMethods = "pushDocumentsDLKO",
            dataProvider = "pushDocumentsDLKO",
            dataProviderClass = Data.class)
    public void checkDocumentsDLKO(String name) throws InterruptedException {
        HelpSteps.checkFormName(name);
    }

    //---------------------------------------------------------------------------
    //                Выбор необходимого актива на странице "Документы ДЛКО"
    //---------------------------------------------------------------------------

    // Открытие окна поиска
    @Test(dependsOnMethods = "checkDocumentsDLKO")
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

    // Ввод первой опции фильтра (значение "Номер лицевого счёта")
    @Test(dependsOnMethods = "checkSearchWindow",
            dataProvider = "pushFirstSearchOptionForDLKO",
            dataProviderClass = Data.class)
    public void pushFirstSearchOptionForDLKO(String name) {
        HelpSteps.pushOption(name);
    }

    // Ввод второй опции фильтра (значение "равно")
    @Test(dependsOnMethods = "pushFirstSearchOptionForDLKO",
            dataProvider = "pushSecondSearchOptionForDLKO",
            dataProviderClass = Data.class)
    public void pushSecondSearchOptionForDLKO(String name) {
        HelpSteps.pushOption(name);
    }

    // Ввод третьей опции фильтра (значение 20202810011223344332)
    @Test(dependsOnMethods = "pushSecondSearchOptionForDLKO",
            dataProvider = "fillsSearchOptionToCheck",
            dataProviderClass = Data.class)
    public void fillsSearchOptionForDLKO(String data) {
        searchWindow.fillSearchTextField(data);
    }

    // Нажатие на кнопку поиска
    @Test(dependsOnMethods = {"pushFirstSearchOptionForDLKO", "pushSecondSearchOptionForDLKO", "fillsSearchOptionForDLKO"},
            dataProvider = "pushSearchButton",
            dataProviderClass = Data.class)
    public void pushSearchButton(String name) {
        HelpSteps.pushElement(name);
    }

    // Проверка существования хотя бы одного элемента с указанными требованиями (значение 20202810011223344332)
    @Test(dependsOnMethods = "pushSearchButton",
            dataProvider = "checkPresenseOfAsset",
            dataProviderClass = Data.class)
    public void checkPresenseOfElements(String value) throws InterruptedException {
        HelpSteps.checkPresenseOfElement(value);
    }

    // Нажатие на чек-бокс, выбор актива
    @Test(dependsOnMethods = "checkPresenseOfElements")
    public void pushCheckBox() {
        dlko.pushCheckBox();
    }

    //-------------------------------------------------------------------
    //     Переход на страницу создания договора о хранении
    //-------------------------------------------------------------------

    // Нажатие на кнопку "Хранение"
    @Test(dependsOnMethods = "pushCheckBox",
            dataProvider = "pushStorageButton",
            dataProviderClass = Data.class)
    public void pushStorageButton(String name) {
        HelpSteps.pushElementContains(name);
    }

    // Наведение курсора на кнопку "Создать новый договор"
    @Test(dependsOnMethods = "pushStorageButton")
    public void mouseOnCreateDocumentButton() {
        dlko.mouseOnCreateDocumentButton();
    }

    // Нажатие на кнопку "Договор с банком (ответственное хранение)"
    @Test(dependsOnMethods = "mouseOnCreateDocumentButton")
    public void pushDocumentWithBank() {
        dlko.pushDocumentWithBank();
    }

    // Проверка страницы "Ввод договора хранения"
    @Test(dependsOnMethods = "pushDocumentWithBank",
            dataProvider = "checkCreatingStrorageDocumentName",
            dataProviderClass = Data.class)
    public void checkCreatingStrorageDocumentName(String name) throws InterruptedException {
        HelpSteps.checkFormName(name);
    }

    // Проверка неактивности полей "Тип документа" и "Тип документа хранения/учёта"
    @Test(dependsOnMethods = "checkCreatingStrorageDocumentName")
    public void checkFieldsDisabled() {
        dlko.checkFieldsDisabled();
    }

    // Проверка корректности автоматически заполненных данных
    @Test(dependsOnMethods = "checkFieldsDisabled",
            dataProvider = "checkFirstDisabled",
            dataProviderClass = Data.class)
    public void checkFirstDisabled(String value) throws InterruptedException {
        dlko.checkFirstElement(value);
    }

    //----------------------||---------------------
    @Test(dependsOnMethods = "checkFirstDisabled",
            dataProvider = "checkSecondDisabled",
            dataProviderClass = Data.class)
    public void checkSecondDisabled(String value) {
        dlko.checkSecondElement(value);
    }

    // Проверка наличия основных полей
    @Test(dependsOnMethods = "checkSecondDisabled",
            dataProviderClass = Data.class,
            dataProvider = "checkMainStorageDocumentFields")
    public void checkMainStorageDocumentFields(String[] args) {
        for (String item : args) {
            HelpSteps.checkElementContains(item);
        }
    }

    // Проверка наличия поля "Банк"
    @Test(dependsOnMethods = "checkMainStorageDocumentFields",
            dataProvider = "checkBank",
            dataProviderClass = Data.class)
    public void checkBank(String name) {
        HelpSteps.checkElement(name);
    }


    // Проверка наличия полей с типом "Checkbox"
    @Test(dependsOnMethods = "checkBank",
            dataProvider = "checkCheckboxesNames",
            dataProviderClass = Data.class)
    public void checkCheckboxesNames(String[] names) {
        dlko.checkCheckboxesNames(names);
    }

    //---------------------------------------------------------------------
    //                  Ввод значений для создания договора о хранении
    //---------------------------------------------------------------------

    // Ввод поля "Банк"
    @Test(dependsOnMethods = "checkCheckboxesNames",
            dataProvider = "pushBankName",
            dataProviderClass = Data.class)
    public void pushBankName(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Ввод поля "Номер договора"
    @Test(dependsOnMethods = "pushBankName",
            dataProvider = "pushDocumentNumberName",
            dataProviderClass = Data.class)
    public void pushDocumentNumberName(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Ввод поля "Дата договора"
    @Test(dependsOnMethods = "pushDocumentNumberName",
            dataProvider = "pushDocumentDateName",
            dataProviderClass = Data.class)
    public void pushDocumentDateName(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Ввод поля "Срок договора"
    @Test(dependsOnMethods = "pushDocumentDateName",
            dataProvider = "pushDocumentTimeName",
            dataProviderClass = Data.class)
    public void pushDocumentTimeName(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Ввод поля "Дата расторжения"
    @Test(dependsOnMethods = "pushDocumentTimeName",
            dataProvider = "pushTerminateDateName",
            dataProviderClass = Data.class)
    public void pushTerminateDateName(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Ввод поля "Комментарий"
    @Test(dependsOnMethods = "pushTerminateDateName",
            dataProvider = "pushCommentName",
            dataProviderClass = Data.class)
    public void pushCommentName(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Выбор всех чекбоксов
    @Test(dependsOnMethods = "pushCommentName")
    public void pushCheckboxes() {
        dlko.pushCheckbockes();
    }

    // Нажатие на кнопку "Выбрать адрес"
    @Test(dependsOnMethods = "pushCheckboxes",
            dataProvider = "pushChooseAdress",
            dataProviderClass = Data.class)
    public void pushChooseAdress(String name) {
        HelpSteps.pushElement(name);
    }

    // Проверить форму "Ввод адреса по КЛАДР"
    @Test(dependsOnMethods = "pushChooseAdress",
            dataProvider = "checkAddressForm",
            dataProviderClass = Data.class)
    public void checkAddressForm(String name) {
        HelpSteps.checkElement(name);
    }

    // Выбрать регион
    @Test(dependsOnMethods = "checkAddressForm",
            dataProvider = "pushState",
            dataProviderClass = Data.class)
    public void pushState(String name) {
        HelpSteps.pushOption(name);
    }

    // Выбрать район
    @Test(dependsOnMethods = "pushState",
            dataProvider = "fillRegion",
            dataProviderClass = Data.class)
    public void fillRegion(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

<<<<<<< HEAD
    // Выбрать город
    @Test(dependsOnMethods = "fillRegion",
            dataProvider = "fillCity",
            dataProviderClass = Data.class)
    public void fillCity(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Выбрать населенный пункт
    @Test(dependsOnMethods = "fillCity",
            dataProvider = "fillSettlement",
            dataProviderClass = Data.class)
    public void fillSettlement(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Выбрать улицу
    @Test(dependsOnMethods = "fillSettlement",
            dataProvider = "fillStreet",
            dataProviderClass = Data.class)
    public void fillStreet(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Выбрать дом
    @Test(dependsOnMethods = "fillStreet",
            dataProvider = "fillHome",
            dataProviderClass = Data.class)
    public void fillHome(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Выбрать индекс
    @Test(dependsOnMethods = "fillHome",
            dataProvider = "fillIndex",
            dataProviderClass = Data.class)
    public void fillIndex(String name, String value) {
        HelpSteps.userFillsFields(name, value);
    }

    // Нажать на кнопку сохранить
    @Test(dependsOnMethods = "fillIndex")
    public void pushSaveButton() {
        dlko.pushSaveButton();
    }

    // Нажать на кнопку сохранить глобально
    @Test(dependsOnMethods = "pushSaveButton")
    public void pushSaveButtonGlobal() throws InterruptedException {
        Thread.sleep(1000);
        dlko.pushSaveButtonGlobal();
    }

    //-----------------------------------------------------------------
    //    Проверка наличия созданного договора хранения
    //-----------------------------------------------------------------

    // Выбор необходимого актива
    @Test(dependsOnMethods = "pushSaveButtonGlobal",
            dataProvider = "checkPresenseOfAsset",
            dataProviderClass = Data.class)
    public void pushAssetName(String name) throws InterruptedException {
        Thread.sleep(1000);
        HelpSteps.pushElement(name);
    }

    // Выбор необходимого договора
    @Test(dependsOnMethods = "pushAssetName",
            dataProvider = "checkPresenceOfDocumentByDateAndNumber",
            dataProviderClass = Data.class)
    public void checkPresenceOfDocumentByDateAndNumber(String number, String date){
        HelpSteps.checkPresenceOfDocumentByDateAndNumber(number, date);
    }

    //-----------------------------------------------------------------
    //     Выход из приложения
    //-----------------------------------------------------------------

    // Нажатие на пункт "Права Все"
    @Test(dependsOnMethods = "checkPresenceOfDocumentByDateAndNumber",
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
=======

>>>>>>> master
}
