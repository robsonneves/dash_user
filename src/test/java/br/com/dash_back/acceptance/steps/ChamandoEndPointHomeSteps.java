package br.com.dash_back.acceptance.steps;

import br.com.dash_back.controllers.HomeController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChamandoEndPointHomeSteps {

    HomeController homeController;
    String rs;

    @Given("uma url")
    public void uma_url() {
        homeController = new HomeController();
    }

    @When("ao chamar a url")
    public void ao_chamar_a_url() {
        rs = homeController.home();
    }

    @Then("entao retorna {string}")
    public void entao_retorna(String string) {
        Assert.assertEquals(rs, string);
    }

}
