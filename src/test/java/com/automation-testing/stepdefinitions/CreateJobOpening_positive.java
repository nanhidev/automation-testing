package com.automation-testing.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.automation-testing.pages.CreateJobOpeningPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class CreateJobOpening_positive extends DriverFactory {
CreateJobOpeningPage createJobOpeningPage = new CreateJobOpeningPage(driver);
@Given("the user is logged in as a recruiter on the dashboard")
public void the_user_is_logged_in_as_a_recruiter_on_the_dashboard() {
createJobOpeningPage.loginAsRecruiter();
}
@When("the user clicks on the {string} option in the side navigation")
public void the_user_clicks_on_the_option_in_the_side_navigation(String job_opening_option) {
createJobOpeningPage.clickOnJobOpeningOption(job_opening_option);
}
@Then("the Job Opening screen should be displayed")
public void the_job_opening_screen_should_be_displayed() {
"Job Opening screen is not displayed", createJobOpeningPage.isJobOpeningScreenDisplayed();
}
@And("the {string} button should be visible")
public void the_button_should_be_visible(String add_job_opening_button) {
add_job_opening_button + " button is not visible", createJobOpeningPage.isButtonVisible(add_job_opening_button);
}
@When("I click on the {string} button")
public void i_click_on_the_button(String action) {
createJobOpeningPage.clickOnAddJobOpeningButton(action);
}
@Then("the Create New Job Opening form should be opened")
public void the_create_new_job_opening_form_should_be_opened() {
"Create New Job Opening form is not opened", createJobOpeningPage.isCreateNewJobOpeningFormOpened();
}
@And("the {string} and {string} buttons should be displayed")
public void the_and_buttons_should_be_displayed(String saveButton, String cancelButton) {
saveButton + " button is not visible", createJobOpeningPage.isButtonVisible(saveButton);
cancelButton + " button is not visible", createJobOpeningPage.isButtonVisible(cancelButton);
}
@When("the recruiter selects a Job Role as {string}")
public void the_recruiter_selects_a_job_role_as(String job_role) {
createJobOpeningPage.selectJobRole(job_role);
}
@When("the recruiter selects a Location as {string}")
public void the_recruiter_selects_a_location_as(String location) {
createJobOpeningPage.selectLocation(location);
}
@When("the recruiter enters Minimum Experience as {string}")
public void the_recruiter_enters_minimum_experience_as(String min_experience) {
createJobOpeningPage.enterMinimumExperience(min_experience);
}
@When("the recruiter enters Maximum Experience as {string}")
public void the_recruiter_enters_maximum_experience_as(String max_experience) {
createJobOpeningPage.enterMaximumExperience(max_experience);
}
@When("the recruiter enters Qualification as {string}")
public void the_recruiter_enters_qualification_as(String qualification) {
createJobOpeningPage.enterQualification(qualification);
}
@When("the recruiter enters Short Job Description as {string}")
public void the_recruiter_enters_short_job_description_as(String short_job_description) {
createJobOpeningPage.enterShortJobDescription(short_job_description);
}
@When("the recruiter enters Responsibilities as {string}")
public void the_recruiter_enters_responsibilities_as(String responsibilities) {
createJobOpeningPage.enterResponsibilities(responsibilities);
}
@When("the recruiter clicks on {string}")
public void the_recruiter_clicks_on(String action) {
createJobOpeningPage.clickOnSave(action);
}
@Then("the job opening should be saved successfully")
public void the_job_opening_should_be_saved_successfully() {
"Job opening was not saved successfully", createJobOpeningPage.isJobOpeningSavedSuccessfully();
}
@Then("the job opening should be available in the Job Opening list")
public void the_job_opening_should_be_available_in_the_job_opening_list() {
"Job opening is not available in the list", createJobOpeningPage.isJobOpeningAvailableInList();
}
@When("the recruiter enters Tags as {string}")
public void the_recruiter_enters_tags_as(String tags) {
createJobOpeningPage.enterTags(tags);
}
@When("the recruiter selects Vendor as {string}")
public void the_recruiter_selects_vendor_as(String vendor) {
createJobOpeningPage.selectVendor(vendor);
}
@When("the recruiter selects Employment Type as {string}")
public void the_recruiter_selects_employment_type_as(String employment_type) {
createJobOpeningPage.selectEmploymentType(employment_type);
}
@When("the recruiter selects Duration as {string}")
public void the_recruiter_selects_duration_as(String duration) {
createJobOpeningPage.selectDuration(duration);
}
@When("the recruiter selects Work Mode as {string}")
public void the_recruiter_selects_work_mode_as(String work_mode) {
createJobOpeningPage.selectWorkMode(work_mode);
}
@When("the recruiter enters Department as {string}")
public void the_recruiter_enters_department_as(String department) {
createJobOpeningPage.enterDepartment(department);
}
@When("the recruiter enters Industry Type as {string}")
public void the_recruiter_enters_industry_type_as(String industry_type) {
createJobOpeningPage.enterIndustryType(industry_type);
}
@When("the recruiter enters Primary Skills as {string}")
public void the_recruiter_enters_primary_skills_as(String primary_skills) {
createJobOpeningPage.enterPrimarySkills(primary_skills);
}
@When("the recruiter enters Secondary Skills as {string}")
public void the_recruiter_enters_secondary_skills_as(String secondary_skills) {
createJobOpeningPage.enterSecondarySkills(secondary_skills);
}
@When("the recruiter enters Total Openings as {string}")
public void the_recruiter_enters_total_openings_as(String total_openings) {
createJobOpeningPage.enterTotalOpenings(total_openings);
}
@When("the recruiter selects Status as {string}")
public void the_recruiter_selects_status_as(String status) {
createJobOpeningPage.selectStatus(status);
}

@Given("I select {string} as the job role")
public void i_select_as_the_job_role(String jobRole) {
createJobOpeningPage.selectJobRole(jobRole);
}
@When("the recruiter enters {string} as minimum experience")
public void the_recruiter_enters_minimum_experience(String minExperience) {
createJobOpeningPage.enterMinimumExperience(minExperience);
}
@When("the user clicks on save")
public void the_user_clicks_on_save() {
createJobOpeningPage.clicksSave();
}
@When("the recruiter selects a location {string}")
public void the_recruiter_selects_a_location(String location) {
createJobOpeningPage.selectLocation(location);
}
@When("the recruiter enters secondary skills {string}")
public void the_recruiter_enters_secondary_skills(String secondarySkills) {
createJobOpeningPage.enterSecondarySkills(secondarySkills);
}
@When("the recruiter enters {string} as the maximum experience")
public void the_recruiter_enters_maximum_experience(String maxExperience) {
createJobOpeningPage.enterMaximumExperience(maxExperience);
}
@When("the recruiter enters responsibilities {string}")
public void the_recruiter_enters_responsibilities(String responsibilities) {
createJobOpeningPage.enterResponsibilities(responsibilities);
}
@When("the recruiter selects work mode {string}")
public void the_recruiter_selects_work_mode(String workMode) {
createJobOpeningPage.selectWorkMode(workMode);
}
@When("the recruiter selects duration {string}")
public void the_recruiter_selects_duration(String duration) {
createJobOpeningPage.selectDuration(duration);
}
@When("the user selects employment type")
public void the_user_selects_employment_type() {
createJobOpeningPage.selectEmploymentType();
}
@When("the recruiter enters department {string}")
public void the_recruiter_enters_department(String department) {
createJobOpeningPage.enterDepartment(department);
}
@When("I clickElement on the add job opening button")
public void i_click_on_the_add_job_opening_button() {
createJobOpeningPage.clickAddJobOpeningButton();
}
@When("the recruiter selects status {string}")
public void the_recruiter_selects_status(String status) {
createJobOpeningPage.selectStatus(status);
}
@When("the recruiter enters total openings {string}")
public void the_recruiter_enters_total_openings(String totalOpenings) {
createJobOpeningPage.enterTotalOpenings(totalOpenings);
}
@When("the recruiter enters {string} as the tags")
public void the_recruiter_enters_tags(String tags) {
createJobOpeningPage.enterTags(tags);
}
@When("the recruiter enters primary skills {string}")
public void the_recruiter_enters_primary_skills(String primarySkills) {
createJobOpeningPage.enterPrimarySkills(primarySkills);
}
@When("the recruiter selects {string} as the vendor")
public void the_recruiter_selects_vendor(String vendor) {
createJobOpeningPage.selectVendor(vendor);
}
@Then("the save cancel buttons should be displayed")
public void the_save_cancel_buttons_should_be_displayed() {
createJobOpeningPage.areSaveCancelButtonsDisplayed();
}
@When("the recruiter enters short job description {string}")
public void the_recruiter_enters_short_job_description(String shortDescription) {
createJobOpeningPage.enterShortJobDescription(shortDescription);
}
@When("the recruiter selects {string} as the location")
public void the_recruiter_selects_as_the_location(String location) {
createJobOpeningPage.selectLocation(location);
}
@When("the recruiter enters qualification {string}")
public void the_recruiter_enters_qualification(String qualification) {
createJobOpeningPage.enterQualification(qualification);
}
@When("the user enters maximum experience {string}")
public void the_user_enters_maximum_experience(String maxExperience) {
createJobOpeningPage.enterMaximumExperience(maxExperience);
}
@When("the user enters minimum experience {string}")
public void the_user_enters_minimum_experience(String minExperience) {
createJobOpeningPage.enterMinimumExperience(minExperience);
}
@When("the recruiter selects employment type {string}")
public void the_recruiter_selects_employment_type(String employmentType) {
createJobOpeningPage.selectEmploymentType(employmentType);
}
@When("the recruiter enters industry type {string}")
public void the_recruiter_enters_industry_type(String industryType) {
createJobOpeningPage.enterIndustryType(industryType);
}
@When("the recruiter selects vendors {string}")
public void the_recruiter_selects_vendors(String vendors) {
createJobOpeningPage.selectVendors(vendors);
}
}