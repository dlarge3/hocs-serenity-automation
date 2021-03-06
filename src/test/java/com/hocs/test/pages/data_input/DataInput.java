package com.hocs.test.pages.data_input;

import com.hocs.test.pages.Page;
import com.hocs.test.pages.homepage.Homepage;
import com.hocs.test.pages.create_case.SuccessfulCaseCreation;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DataInput extends Page {

    Homepage homepage;
    SuccessfulCaseCreation successfulCaseCreation;

    // Elements

    @FindBy(xpath = "//span[text()='TEAM 1']")
    private WebElementFacade team1DataInput;

    @FindBy(xpath = "//span[text()='1111']")
    private WebElementFacade team1111Markup;

    @FindBy(css = "label[for='OriginalChannel-EMAIL']")
    private WebElementFacade emailOriginalChannelRadioButton;

    @FindBy(css = "label[for='OriginalChannel-POST']")
    private WebElementFacade postOriginalChannelRadioButton;

    @FindBy(css = "label[for='OriginalChannel-PHONE']")
    private WebElementFacade phoneOriginalChannelRadioButton;

    @FindBy(css = "label[for='OriginalChannel-NO10']")
    private WebElementFacade numberTenOriginalChannelRadioButton;

    @FindBy(id = "DateOfCorrespondence-day")
    private WebElementFacade dateCorrespondenceSentDayField;

    @FindBy(id = "DateOfCorrespondence-month")
    private WebElementFacade dateCorrespondenceSentMonthField;

    @FindBy(id = "DateOfCorrespondence-year")
    private WebElementFacade dateCorrespondenceSentYearField;

    @FindBy(id = "DateReceived-day")
    private WebElementFacade dateCorrespondenceReceivedDayField;

    @FindBy(id = "DateReceived-month")
    private WebElementFacade dateCorrespondenceReceivedMonthField;

    @FindBy(id = "DateReceived-year")
    private WebElementFacade dateCorrespondenceReceivedYearField;

    @FindBy(id = "")
    private WebElementFacade correspondentDropdown;

    @FindBy(id = "")
    private WebElementFacade referenceTextField;

    @FindBy(css = ".govuk-fieldset > a:nth-child(3)")
    private WebElementFacade addCorrespondentLink;

    @FindBy(id = "")
    private WebElementFacade primaryCorrespondent;

    @FindBy(css = "label[for='CorrespondentIsMember-FALSE']")
    private WebElementFacade correspondentMemberNoRadioButton;

    @FindBy(css = "label[for='CorrespondentIsMember-TRUE']")
    private WebElementFacade correspondentMemberYesRadioButton;

    @FindBy(css = "label[for='CopyNumberTen-TRUE']")
    private WebElementFacade sendCopyToNumberTenTickBox;

    @FindBy(css = "label[for='AdditionalCorrespondent-FALSE']")
    private WebElementFacade addCorrespondentNoRadioButton;

    @FindBy(css = "label[for='AdditionalCorrespondent-TRUE']")
    private WebElementFacade addCorrespondentYesRadioButton;


    // Basic Methods


    public void clickAddCorrespondentLink() {
        addCorrespondentLink.click();
    }

    public void clickCorrespondentIsAMember() {
        correspondentMemberYesRadioButton.click();
    }

    public void clickCorrespondentIsNotAMember() {
        correspondentMemberNoRadioButton.click();
    }

    public void clickEmailCorrespondenceChannelRadioButton() {
        emailOriginalChannelRadioButton.click();
    }

    public void clickPostCorrespondenceChannelRadioButton() {
        postOriginalChannelRadioButton.click();
    }

    public void clickNo10CorrespondenceChannelRadioButton() {
        numberTenOriginalChannelRadioButton.click();
    }

    public void clickPhoneCorrespondenceChannelRadioButton() {
        phoneOriginalChannelRadioButton.click();
    }

    public void selectTeam1() {
        team1DataInput.click();
    }

    public void selectTeam1111() {
        team1111Markup.click();
    }


    public void tickSendCopyToNumber10() {
        sendCopyToNumberTenTickBox.click();
    }

    // Multi Step Methods

    public void dataInputFullFlow() {
        selectTeam1();
        System.out.println(" I have selected the teamview and am viewing the Data Input Cases");
        successfulCaseCreation.clickSessionVariableViaLinkText();
        System.out.println("I have found and selected the case reference");
        System.out.println("Attempting to fill mandatory fields.");
        fillAllMandatoryFields();
        clickContinueButton();
        clickFinishButton();
    }

    public void clearDateCorrespondenceReceived() {
        dateCorrespondenceReceivedDayField.clear();
        dateCorrespondenceReceivedMonthField.clear();
        dateCorrespondenceReceivedYearField.clear();
    }

    public void clearDateCorrespondenceSent() {
        dateCorrespondenceSentDayField.clear();
        dateCorrespondenceSentMonthField.clear();
        dateCorrespondenceSentYearField.clear();
    }

    private void enterDayOfCorrespondenceReceived(String day) {
        dateCorrespondenceReceivedDayField.clear();
        dateCorrespondenceReceivedDayField.sendKeys(day);
    }

    private void enterMonthOfCorrespondenceReceived(String month) {
        dateCorrespondenceReceivedMonthField.clear();
        dateCorrespondenceReceivedMonthField.sendKeys(month);
    }

    private void enterYearOfCorrespondenceReceived(String year) {
        dateCorrespondenceReceivedYearField.clear();
        dateCorrespondenceReceivedYearField.sendKeys(year);
    }

    private void enterDayOfCorrespondenceSent(String day) {
        dateCorrespondenceSentDayField.clear();
        dateCorrespondenceSentDayField.sendKeys(day);
    }

    private void enterMonthOfCorrespondenceSent(String month) {
        dateCorrespondenceSentMonthField.clear();
        dateCorrespondenceSentMonthField.sendKeys(month);
    }

    private void enterYearOfCorrespondenceSent(String year) {
        dateCorrespondenceSentYearField.clear();
        dateCorrespondenceSentYearField.sendKeys(year);
    }

    public void enterReferenceText() {
        referenceTextField.clear();
        referenceTextField.sendKeys("");
    }

    public void fillAllMandatoryFields() {
        emailOriginalChannelRadioButton.click();
        enterDayOfCorrespondenceSent(todayPlusNDaysGetDay(-2));
        enterMonthOfCorrespondenceSent(todayPlusNDaysGetMonth(-2));
        enterYearOfCorrespondenceSent(todayPlusNDaysGetYear(-2));
        enterDayOfCorrespondenceReceived(getCurrentDay());
        enterMonthOfCorrespondenceReceived(getCurrentMonth());
        enterYearOfCorrespondenceReceived(getCurrentYear());
    }

    public void invalidCorrespondenceReceivedDate() {
        enterDayOfCorrespondenceReceived("32");
        enterMonthOfCorrespondenceReceived(getCurrentMonth());
        enterYearOfCorrespondenceReceived(getCurrentYear());
    }

    public void invalidCorrespondenceSentDate() {
        enterDayOfCorrespondenceSent("32");
        enterMonthOfCorrespondenceSent(getCurrentMonth());
        enterYearOfCorrespondenceSent(getCurrentYear());
    }

    // Assertions

    public void assertPageTitle() {
        assertTitle("Record Correspondence Details");
    }

    public void addACorrespondentLinkIsDisplayed() {
        addCorrespondentLink.isDisplayed();
    }

}
