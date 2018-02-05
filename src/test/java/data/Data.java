package data;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "checkPageName")
    public Object[][] checkPageName() {
        return new Object[][]{
                {Options.formName}
        };
    }

    @DataProvider(name = "userFillsValidLogin")
    public Object[][] userFillsValidLogin() {
        return new Object[][]{
                {Options.loginName, Options.validLogin}
        };
    }

    @DataProvider(name = "userFillsValidPassword")
    public Object[][] userFillsValidPassword() {
        return new Object[][]{
                {Options.passwordName, Options.validPassword}
        };
    }

    @DataProvider(name = "userPushEnterButton")
    public Object[][] userPushEnterButton() {
        return new Object[][]{
                {Options.enterButton}
        };
    }

    @DataProvider(name = "checkModalWindowName")
    public Object[][] checkModalWindowName() {
        return new Object[][]{
                {Options.modalWindowName}
        };
    }

    @DataProvider(name = "userChooseOrganization")
    public Object[][] userChooseOrganization() {
        return new Object[][]{
                {Options.organizationName}
        };
    }

    @DataProvider(name = "checkOrganizationName")
    public Object[][] checkOrganizationName() {
        return new Object[][]{
                {Options.organizationName}
        };
    }

    @DataProvider(name = "pushChooseButton")
    public Object[][] pushChooseButton() {
        return new Object[][]{
                {Options.chooseButton}
        };
    }

    @DataProvider(name = "pushPreExitButton")
    public Object[][] pushPreExitButton() {
        return new Object[][]{
                {Options.preExitButton}
        };
    }

    @DataProvider(name = "pushExitButton")
    public Object[][] pushExitButton() {
        return new Object[][]{
                {Options.exitButton}
        };
    }

    @DataProvider(name = "checkLogoName")
    public Object[][] checkLogoName() {
        return new Object[][]{
                {Options.titleLogo}
        };
    }

    @DataProvider(name = "userFillsLoginFieldInvalid")
    public Object[][] userFillsLoginFieldInvalid() {
        return new Object[][]{
                {Options.loginName, Options.invalidLogin}
        };
    }

    @DataProvider(name = "userFillsPasswordFieldInvalid")
    public Object[][] userFillsPasswordFieldInvalid() {
        return new Object[][]{
                {Options.passwordName, Options.invalidPassword}
        };
    }

    @DataProvider(name = "checkWrongLoginOrPassword")
    public Object[][] checkWrongLoginOrPassword() {
        return new Object[][]{
                {Options.wrongLoginOrPassword}
        };
    }

    @DataProvider(name = "pushSettingsBar")
    public Object[][] pushSettingsBar() {
        return new Object[][]{
                {Options.settingsBar}
        };
    }

    @DataProvider(name = "pushReferenceBooks")
    public Object[][] pushReferenceBooks() {
        return new Object[][]{
                {Options.referenceBooks}
        };
    }

    @DataProvider(name = "pushAccountNumber")
    public Object[][] pushAccountNumber() {
        return new Object[][]{
                {}
        };
    }

    @DataProvider(name = "checkSearchWindow")
    public Object[][] checkSearchWindow() {
        return new Object[][]{
                {Options.searchWindowName}
        };
    }

    @DataProvider(name = "pushFirstSearchOption")
    public Object[][] pushFirstSearchOption() {
        return new Object[][]{
                {Options.firstSearchOption}
        };
    }

    @DataProvider(name = "pushSecondSearchOption")
    public Object[][] pushSecondSearchOption() {
        return new Object[][]{
                {Options.secondSearchOption}
        };
    }

    @DataProvider(name = "fillsSearchOption")
    public Object[][] fillsSearchOption() {
        return new Object[][]{
                {Options.thirdSearchOption}
        };
    }

    @DataProvider(name = "pushSearchButton")
    public Object[][] pushSearchButton() {
        return new Object[][]{
                {Options.searchButtonName}
        };
    }

    @DataProvider(name = "checkPresenseOfElements")
    public Object[][] checkPresenseOfElements() {
        return new Object[][]{
                {Options.thirdSearchOption}
        };
    }

    @DataProvider(name = "pushCollectionAndMaintenanceofData")
    public Object[][] pushCollectionAndMaintenanceofData() {
        return new Object[][]{
                {Options.collectionAndMaintenanceofDataBar}
        };
    }

    @DataProvider(name = "pushAssetList")
    public Object[][] pushAssetList() {
        return new Object[][]{
                {Options.assetList}
        };
    }

    @DataProvider(name = "pushCreateButton")
    public Object[][] pushCreateButton() {
        return new Object[][]{
                {Options.createButton}
        };
    }

    @DataProvider(name = "checkAssetListFirstStep")
    public Object[][] checkAssetListFirstStep() {
        return new Object[][]{
                {Options.assetListFirstStep}
        };
    }

    @DataProvider(name = "checkFOName")
    public Object[][] checkFOName() {
        return new Object[][]{
                {Options.FOName}
        };
    }

    @DataProvider(name = "checkAssetType")
    public Object[][] checkAssetType() {
        return new Object[][]{
                {Options.assetType}
        };
    }

    @DataProvider(name = "pushAssetFunctionalType")
    public Object[][] pushAssetFunctionalType() {
        return new Object[][]{
                {Options.assetFunctionalType}
        };
    }

    @DataProvider(name = "pushContinueButton")
    public Object[][] pushContinueButton() {
        return new Object[][]{
                {Options.continueButtonName}
        };
    }

    @DataProvider(name = "checkAssetListSecondStep")
    public Object[][] checkAssetListSecondStep() {
        return new Object[][]{
                {Options.assetListSecondStep}
        };
    }

    @DataProvider(name = "checkMainAssetLinks")
    public Object[][] checkMainAssetLinks() {
        String[] array = {
                Options.assetProperties,
                Options.acceptName,
                Options.planName,
                Options.courtName,
                Options.storageName,
                Options.rentName,
                Options.markName,
                Options.realisationName,
                Options.writeOffName,
                Options.utilizationName,
        };
        return new Object[][]{
                {array}
        };
    }

    @DataProvider(name = "checkInventoryName")
    public Object[][] checkInventoryName() {
        return new Object[][]{
                {Options.inventoryName}
        };
    }

    @DataProvider(name = "checkAssetConnectionName")
    public Object[][] checkAssetConnectionName() {
        return new Object[][]{
                {Options.assetConnection}
        };
    }

    @DataProvider(name = "userFillsAccountNumber")
    public Object[][] userFillsAccountNumber(){
        return new Object[][]{
                {Options.accountNumberName, Options.accountNumber}
        };
    }

    @DataProvider(name = "userFillsBalanceInitial")
    public Object[][] userFillsBalanceInitial(){
        return new Object[][]{
                {Options.balanceInitialName, Options.balanceInitial}
        };
    }

    @DataProvider(name = "userFillsAssetName")
    public Object[][] userFillsAssetName(){
        return new Object[][]{
                {Options.assetName, Options.asset}
        };
    }

    @DataProvider(name = "checkCurrency")
    public Object[][] checkCurrency(){
        return new Object[][]{
                {Options.currencyName}
        };
    }

    @DataProvider(name = "checkCurrentBalanceName")
    public Object[][] checkCurrentBalanceName(){
        return new Object[][]{
                {Options.balanceInitialName, Options.currentBalanceName}
        };
    }

    @DataProvider(name = "checkBalanceInitialCurrency")
    public Object[][] checkBalanceInitialCurrency(){
        return new Object[][]{
                {Options.balanceInitialCurrency}
        };
    }

    @DataProvider(name = "checkCurrentBalanceCurrency")
    public Object[][] checkCurrentBalanceCurrency(){
        return new Object[][]{
                {Options.currentBalanceCurrency}
        };
    }

    @DataProvider(name="pushReceivingButton")
    public Object[][] pushReceivingButton(){
        return new Object[][]{
                {Options.acceptName}
        };
    }

    @DataProvider(name="userFillsStartDate")
    public Object[][] userFillsStartDate(){
        return new Object[][]{
                {Options.startDateName, Options.startDate}
        };
    }

    @DataProvider(name="userFillsEndDate")
    public Object[][] userFillsEndDate(){
        return new Object[][]{
                {Options.endDateName, Options.endDate}
        };
    }

    @DataProvider(name = "pushFirstSearchOptionToCheck")
    public Object[][] pushFirstSearchOptionToCheck() {
        return new Object[][]{
                {Options.accountNumberField}
        };
    }

    @DataProvider(name = "fillsSearchOptionToCheck")
    public Object[][] fillsSearchOptionToCheck(){
        return new Object[][]{
                {Options.accountNumber}
        };
    }

    @DataProvider(name = "checkPresenseOfAsset")
    public Object[][] checkPresenseOfAsset(){
        return new Object[][]{
                {Options.accountNumber}
        };
    }

    @DataProvider(name = "pushDeleteButton")
    public Object[][] pushDeleteButton(){
        return new Object[][]{
                {Options.deleteButton}
        };
    }

    @DataProvider(name = "pushCloseButton")
    public Object[][] pushCloseButton(){
        return new Object[][]{
                {Options.closeButton}
        };
    }

    @DataProvider(name = "pushDocumentsDLKO")
    public Object[][] pushDocumentsDLKO(){
        return new Object[][]{
                {Options.documentsDLKO}
        };
    }

    @DataProvider(name = "pushFirstSearchOptionForDLKO")
    public Object[][] pushFirstSearchOptionForDLKO() {
        return new Object[][]{
                {Options.accountNumberFieldE}
        };
    }

    @DataProvider(name = "pushSecondSearchOptionForDLKO")
    public Object[][] pushSecondSearchOptionForDLKO() {
        return new Object[][]{
                {Options.equal}
        };
    }

    @DataProvider(name = "pushStorageButton")
    public Object[][] pushStorageButton() {
        return new Object[][]{
                {Options.storage}
        };
    }

    @DataProvider(name = "checkCreatingStrorageDocumentName")
    public  Object[][] checkCreatingStrorageDocumentName(){
        return new Object[][]{
                {Options.creatingStrorageDocument}
        };
    }

    @DataProvider(name = "checkFirstDisabled")
    public  Object[][] checkFirstDisabled(){
        return new Object[][]{
                {Options.storageDocument}
        };
    }

    @DataProvider(name = "checkSecondDisabled")
    public  Object[][] checkSecondDisabled(){
        return new Object[][]{
                {Options.documentWithBank}
        };
    }

    @DataProvider(name = "checkMainStorageDocumentFields")
    public Object[][] checkMainStorageDocumentFields() {
        String[] array = {
                Options.documentType,
                Options.documentTypeStorage,
                Options.documentNumber,
                Options.documentDate,
                Options.documentTime,
                Options.terminateDate,
                Options.storagePlace,
                Options.comment
        };
        return new Object[][]{
                {array}
        };
    }

    @DataProvider(name = "checkCheckboxesNames")
    public Object[][] checkCheckboxesNames() {
        String[] array = {
                Options.project,
                Options.сoncludedBeforeTheDateOfKP_L,
                Options.terminated
        };
        return new Object[][]{
                {array}
        };
    }

    @DataProvider(name = "checkBank")
    public  Object[][] checkBank(){
        return new Object[][]{
                {Options.bank}
        };
    }
//------------------------------------
    @DataProvider(name = "pushBankName")
    public  Object[][] pushBankName(){
        return new Object[][]{
                {Options.bankName, Options.bankField}
        };
    }
    @DataProvider(name = "pushDocumentNumberName")
    public  Object[][] pushDocumentNumberName(){
        return new Object[][]{
                {Options.documentNumberName, Options.documentNumberField}
        };
    }
    @DataProvider(name = "pushDocumentDateName")
    public  Object[][] pushDocumentDateName(){
        return new Object[][]{
                {Options.documentDateName, Options.documentDateField}
        };
    }
    @DataProvider(name = "pushDocumentTimeName")
    public  Object[][] pushDocumentTimeName(){
        return new Object[][]{
                {Options.documentTimeName, Options.documentTimeField}
        };
    }
    @DataProvider(name = "pushTerminateDateName")
    public  Object[][] pushTerminateDateName(){
        return new Object[][]{
                {Options.terminateDateName, Options.terminateDateField}
        };
    }
    @DataProvider(name = "pushCommentName")
    public  Object[][] pushCommentName(){
        return new Object[][]{
                {Options.commentName, Options.commentField}
        };
    }
    @DataProvider(name = "pushChooseAdress")
    public Object[][] pushChooseAdress(){
        return new Object[][]{
                {Options.chooseAddress}
        };
    }

    @DataProvider(name = "checkAddressForm")
    public Object[][] checkAddressForm(){
        return new Object[][]{
                {Options.addressForm}
        };
    }

    @DataProvider(name = "pushState")
    public Object[][] pushState(){
        return new Object[][]{
                {Options.state}
        };
    }

    @DataProvider(name = "fillRegion")
    public Object[][] fillRegion(){
        return new Object[][]{
                {Options.regionName, Options.region}
        };
    }
    @DataProvider(name = "fillCity")
    public Object[][] fillCity(){
        return new Object[][]{
                {Options.cityName, Options.city}
        };
    }
    @DataProvider(name = "fillSettlement")
    public Object[][] fillSettlement(){
        return new Object[][]{
                {Options.settlementName, Options.settlement}
        };
    }
    @DataProvider(name = "fillStreet")
    public Object[][] fillStreet(){
        return new Object[][]{
                {Options.streetName, Options.street}
        };
    }
    @DataProvider(name = "fillHome")
    public Object[][] fillHome(){
        return new Object[][]{
                {Options.homeName, Options.home}
        };
    }
    @DataProvider(name = "fillIndex")
    public Object[][] fillIndex(){
        return new Object[][]{
                {Options.indexName, Options.index}
        };
    }

    @DataProvider(name= "checkPresenceOfDocumentByDateAndNumber")
    public Object[][] checkPresenceOfDocumentByDateAndNumber(){
        return new Object[][]{
                {Options.documentNumberField, Options.documentDateField}
        };
    }

}
