package main.test.ru.miet.testing;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.ru.miet.testing.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    MainMock app;
    @Given("^I have entered first number (.*) into the calculator$")
    public void enterFirst(String arg1){
        app = new MainMock();
        app.setVisible(true);
        app.inputA.setText(arg1);
        //throw new PendingException();
    }
    @And("^I have entered second number (.*) into the calculator$")
    public void enterSecond(String arg1) {
        app.inputB.setText(arg1);
        //throw new PendingException();
    }
    @When("^I press plus$")
    public void pressPlus() {
        app.plus.doClick();
        //throw new PendingException();
    }
    @When("^I press minus$")
    public void pressMinus() {
        app.minus.doClick();
    }
    @When("^I press multiply$")
    public void pressMultiply() {
        app.multiply.doClick();
    }
    @When("^I press divide$")
    public void pressDivide() {
        app.divide.doClick();
    }
    @Then("^the result should be ([0-9.,-]+) on the screen$")
    public void result(double arg1){
        assertEquals(Double.toString(arg1), app.output.getText());
        //throw new PendingException();
    }
    //Вот эта хуйня в 4 лабе
    @Then("^Should be error (.*) on the screen")
    public void result(String arg1){
        assertEquals(arg1, app.error);
    }
}
