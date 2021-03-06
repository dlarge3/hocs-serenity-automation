package com.hocs.test.pages.create_case;

import com.hocs.test.pages.Page;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.annotations.Managed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SuccessfulCaseCreation extends Page {

    @Managed

    WebDriver driver;

    @FindBy(className = "govuk-panel--confirmation")
    private WebElementFacade confirmationPanel;

    @FindBy(className = "govuk-panel__title")
    private WebElementFacade panelTitle;

    @FindBy(className = "govuk-panel__body")
    private WebElementFacade createdCaseMessage;

    @FindBy(className = "govuk-back-link")
    private WebElementFacade successBackButton;

    public void clickSuccessfulCaseBackButton() {
        successBackButton.click();
    }

    public void assertCaseCreatedSuccess() {
        assertThat(panelTitle.getText(), is("Success"));
    }

    // Set Case Reference Number to session variable during case creation

    public String getCaseReference() {
        String wholeString = createdCaseMessage.getText();
        String to_remove="Created a new case: ";

        String caseReference = wholeString.replace(to_remove, "");
        Serenity.setSessionVariable("caseReference").to(caseReference);

        return caseReference;
    }

    // Call session variable and set it to linkText of a findElement.by

    public void clickSessionVariableViaLinkText() {
        String caseReferenceNumber
                = Serenity.sessionVariableCalled("caseReference").toString();
        System.out.println(caseReferenceNumber);
        WebElement thisReference = getDriver().findElement(By.linkText(caseReferenceNumber));
        System.out.println(thisReference);
        thisReference.click();
    }

    public void clickSessionVariableViaLinkTextAndStoreResultingElement(){
        String caseReferenceNumber
                = Serenity.sessionVariableCalled("caseReference").toString();
        System.out.println(caseReferenceNumber);
        WebElement thisReference = getDriver().findElement(By.linkText(caseReferenceNumber));
        System.out.println(thisReference);
        Serenity.setSessionVariable("assertCase").to(thisReference);
        thisReference.click();
    }
}
