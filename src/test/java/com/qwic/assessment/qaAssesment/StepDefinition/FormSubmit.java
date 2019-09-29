package com.qwic.assessment.qaAssesment.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.qwic.assessment.qaAssesment.TestBase.Base;
import com.qwic.assessment.qaAssesment.Util.Driver;

public class FormSubmit {

    @Given("^I navigate to the localhost$")
    public void i_navigate_to_the_localhost() {
        Base.beforeSuite();
    }

    @When("^I select the  brand \"([^\"]*)\"$")
    public void i_select_the_brand(String carBrand) {
        Select brand = new Select(Driver.driver.findElement(By.xpath("//*[@id=\'S1\']")));
        brand.selectByVisibleText(carBrand);
    }


    @When("^I select the model \"([^\"]*)\"$")
    public void i_select_the_model(String carModel) {
        Select model = new Select(Driver.driver.findElement(By.xpath("//*[@id=\'S2\']")));
        model.selectByVisibleText(carModel);

    }

    @Then("^I submit the form$")
    public void i_submit_the_form() {
        WebElement submit = Driver.driver.findElement(By.xpath("//*[@id=\"B\"]"));
        submit.click();
    }

    @Then("^close the browser$")
    public void close_the_browser() throws InterruptedException {
        Thread.sleep(4000);
        Base.afterSuite();
    }

    @Then("^I enter the \"([^\"]*)\"$")
    public void i_enter_the(String searchText) {
        WebElement TextElement = Driver.driver.findElement(By.className("InputText"));
        TextElement.sendKeys(searchText);
    }


}
