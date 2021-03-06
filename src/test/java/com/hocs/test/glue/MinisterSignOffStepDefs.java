package com.hocs.test.glue;

import com.hocs.test.pages.Page;
import com.hocs.test.pages.data_input.DataInput;
import com.hocs.test.pages.homepage.Homepage;
import com.hocs.test.pages.minister.MinisterSignOff;
import com.hocs.test.pages.create_case.SuccessfulCaseCreation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Managed;

import org.openqa.selenium.WebDriver;

public class MinisterSignOffStepDefs {

    @Managed
    WebDriver driver;

    Page page;

    DataInput dataInput;

    Homepage homepage;

    MinisterSignOff minister;

    SuccessfulCaseCreation successfulCaseCreation;

    @When("^I complete the minister sign off stage$")
    public void completeTheMinisterSignOffStage(){
        dataInput.selectTeam1();
        successfulCaseCreation.clickSessionVariableViaLinkText();
        minister.clickMinisterSignOffAcceptRadioButton();
        page.clickFinishButton();
    }

}
