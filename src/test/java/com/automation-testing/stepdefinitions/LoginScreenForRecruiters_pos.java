package com.automation-testing.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.automation-testing.pages.LoginScreenForRecruiters_posPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginScreenForRecruiters_pos extends DriverFactory {
LoginScreenForRecruiters_posPage loginPage = new LoginScreenForRecruiters_posPage(driver);
@Given("the user is on the Login Screen")
public void the_user_is_on_the_login_screen() {
driver = DriverFactory.getDriver();
loginPage.navigateToLoginScreen();
}
@When("I enter {string} in the Email ID field")
public void i_enter_email_in_the_email_id_field(String email) {
loginPage.enterEmail(email);
}
@When("I enter {string} in the Password field")
public void i_enter_password_in_the_password_field(String password) {
loginPage.enterPassword(password);
}
@When("I click on the 'Show Password' option to verify the password visibility")
public void i_click_on_show_password_option() {
loginPage.togglePasswordVisibility();
}
@When("I click the Login button")
public void i_click_the_login_button() {
loginPage.clickLoginButton();
}
@Then("the user should be redirected to the dashboard")
public void the_user_should_be_redirected_to_the_dashboard() {
loginPage.isDashboardDisplayed();
}
@Then("the dashboard loads successfully without errors")
public void the_dashboard_loads_successfully_without_errors() {
loginPage.isDashboardLoadedWithoutErrors();
}
@Then("the Login button should be disabled")
public void the_login_button_should_be_disabled() {
loginPage.isLoginButtonEnabled();
}
@Then("the Login button should be enabled")
public void the_login_button_should_be_enabled() {
loginPage.isLoginButtonEnabled();
}
@Then("the password should be visible")
public void the_password_should_be_visible() {
loginPage.isPasswordVisible();
}
@Then("the password should be hidden")
public void the_password_should_be_hidden() {
loginPage.isPasswordVisible();
}
@Then("the user can still log in successfully after toggling")
public void the_user_can_still_log_in_successfully_after_toggling() {
loginPage.isLoginSuccessfulAfterToggling();
}
@Then("an error message {string} is displayed")
public void an_error_message_is_displayed(String errorMessage) {
Assert.assertEquals(errorMessage, loginPage.getErrorMessage());
}
@Given("the user logs out and returns to the Login Screen")
public void the_user_logs_out_and_returns_to_the_login_screen() {
loginPage.logout();
loginPage.navigateToLoginScreen();
}
@When("I leave the Password field empty")
public void i_leave_the_password_field_empty() {
loginPage.leavePasswordFieldEmpty();
}
@When("the user enters a valid password {string}")
public void the_user_enters_a_valid_password(String password) {
loginPage.enterPassword(password);
}
@When("the user enters a valid email ID {string}")
public void the_user_enters_a_valid_email_id(String email) {
loginPage.enterEmail(email);
}
@When("the user enters {string}")
public void the_user_enters(String email) {
loginPage.enterEmail(email);
}
@Then("the user should be redirected to the dashboard successfully")
public void the_user_should_be_redirected_to_the_dashboard_successfully() {
loginPage.isDashboardDisplayed();
}
//    @Then("the user logs out and returns to the login screen")

@Given("I enter a valid password {string}")
public void i_enter_a_valid_password(String validPassword) {
loginScreenForRecruitersPage.enterPassword(validPassword);
}
@When("the user enters the password {string}")
public void the_user_enters_the_password(String password) {
loginScreenForRecruitersPage.enterPassword(password);
}
@When("I log out")
public void i_log_out() {
loginScreenForRecruitersPage.logOut();
}
@Given("I enter {string}")
public void i_enter(String input) {
loginScreenForRecruitersPage.enterInput(input);
}
@When("the user enters the correct password {string}")
public void the_user_enters_the_correct_password(String correctPassword) {
loginScreenForRecruitersPage.enterPassword(correctPassword);
}
@Given("I enter the correct password")
public void i_enter_the_correct_password() {
loginScreenForRecruitersPage.enterCorrectPassword();
}
@Then("the user is redirected to the dashboard successfully")
public void the_user_is_redirected_to_the_dashboard_successfully() {
loginScreenForRecruitersPage.isDashboardDisplayed();
}
@Then("the user should return to the login screen")
public void the_user_should_return_to_the_login_screen() {
loginScreenForRecruitersPage.isLoginScreenDisplayed();
}
@When("the user enters a password with {string} characters {string}")
public void the_user_enters_a_password_with_characters(String characterCount, String password) {
loginScreenForRecruitersPage.enterPasswordWithCharacterCount(characterCount, password);
}
@When("the user clicks the login button")
public void the_user_clicks_the_login_button() {
loginScreenForRecruitersPage.clickLoginButton();
}
@When("the user clicks on the 'hide password' option")
public void the_user_clicks_on_the_hide_password_option() {
loginScreenForRecruitersPage.clickHidePasswordOption();
}
@Given("I enter a valid email id {string}")
public void i_enter_a_valid_email_id(String emailId) {
loginScreenForRecruitersPage.enterEmailId(emailId);
}
@Then("an error message incorrect email id or password. is displayed")
public void an_error_message_incorrect_email_id_or_password_is_displayed() {
loginScreenForRecruitersPage.isErrorMessageDisplayed();
Assert.assertEquals("incorrect email id or password.", loginScreenForRecruitersPage.getErrorMessage());
}
@When("the user clicks on the 'show password' option")
public void the_user_clicks_on_the_show_password_option() {
loginScreenForRecruitersPage.clickShowPasswordOption();
}
}
}