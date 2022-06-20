package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Common;

public class Steps {
	@Given("User should be on the amazon page")
	public void user_should_be_on_the_amazon_page() {
		Common.checkHomePage();
	}

	@When("^User enters the (.*)$")
	public void user_enters_the(String string) {
		Common.enterProduct(string);

	}

	@When("presses on search button")
	public void presses_on_search_button() {
		Common.clicksOnSearchButton();
	}

	@When("click on the product")
	public void click_on_the_product() {
		Common.viewProduct();
	}

	@When("click on buy now button")
	public void click_on_buy_now_button() {
		Common.BuyNow();
	}

	@When("able to enter username")
	public void able_to_enter_username() throws IOException {
		Common.sendUserName();
	}

	@When("able to enter password")
	public void able_to_enter_password() throws IOException {
		Common.sendPassword();
	}

	@Then("should be on check out page")
	public void should_be_on_check_out_page() {
		Common.assertPage();
	}

}
