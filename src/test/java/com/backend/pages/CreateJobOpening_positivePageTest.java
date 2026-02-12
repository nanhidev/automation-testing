
package com.backend.pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateJobOpeningPageTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement jobOpeningScreen;

    @Mock
    private WebElement addJobOpeningButton;

    @Mock
    private WebElement saveButton;

    @Mock
    private WebElement cancelButton;

    @Mock
    private WebElement jobRoleDropdown;

    @Mock
    private WebElement locationDropdown;

    @Mock
    private WebElement minExperienceInput;

    @Mock
    private WebElement maxExperienceInput;

    @Mock
    private WebElement qualificationInput;

    @Mock
    private WebElement shortJobDescriptionInput;

    @Mock
    private WebElement responsibilitiesInput;

    @Mock
    private WebElement tagsInput;

    @Mock
    private WebElement vendorDropdown;

    @Mock
    private WebElement employmentTypeDropdown;

    @Mock
    private WebElement durationDropdown;

    @Mock
    private WebElement workModeDropdown;

    @Mock
    private WebElement departmentInput;

    @Mock
    private WebElement industryTypeInput;

    @Mock
    private WebElement primarySkillsInput;

    @Mock
    private WebElement secondarySkillsInput;

    @Mock
    private WebElement totalOpeningsInput;

    @Mock
    private WebElement statusDropdown;

    @InjectMocks
    private CreateJobOpeningPage createJobOpeningPage;

    @BeforeEach
    public void setUp() {
        when(driver.findElement(By.id("jobOpeningScreen"))).thenReturn(jobOpeningScreen);
        when(driver.findElement(By.id("addJobOpeningButton"))).thenReturn(addJobOpeningButton);
        when(driver.findElement(By.id("saveButton"))).thenReturn(saveButton);
        when(driver.findElement(By.id("cancelButton"))).thenReturn(cancelButton);
        when(driver.findElement(By.id("jobRoleDropdown"))).thenReturn(jobRoleDropdown);
        when(driver.findElement(By.id("locationDropdown"))).thenReturn(locationDropdown);
        when(driver.findElement(By.id("minExperienceInput"))).thenReturn(minExperienceInput);
        when(driver.findElement(By.id("maxExperienceInput"))).thenReturn(maxExperienceInput);
        when(driver.findElement(By.id("qualificationInput"))).thenReturn(qualificationInput);
        when(driver.findElement(By.id("shortJobDescriptionInput"))).thenReturn(shortJobDescriptionInput);
        when(driver.findElement(By.id("responsibilitiesInput"))).thenReturn(responsibilitiesInput);
        when(driver.findElement(By.id("tagsInput"))).thenReturn(tagsInput);
        when(driver.findElement(By.id("vendorDropdown"))).thenReturn(vendorDropdown);
        when(driver.findElement(By.id("employmentTypeDropdown"))).thenReturn(employmentTypeDropdown);
        when(driver.findElement(By.id("durationDropdown"))).thenReturn(durationDropdown);
        when(driver.findElement(By.id("workModeDropdown"))).thenReturn(workModeDropdown);
        when(driver.findElement(By.id("departmentInput"))).thenReturn(departmentInput);
        when(driver.findElement(By.id("industryTypeInput"))).thenReturn(industryTypeInput);
        when(driver.findElement(By.id("primarySkillsInput"))).thenReturn(primarySkillsInput);
        when(driver.findElement(By.id("secondarySkillsInput"))).thenReturn(secondarySkillsInput);
        when(driver.findElement(By.id("totalOpeningsInput"))).thenReturn(totalOpeningsInput);
        when(driver.findElement(By.id("statusDropdown"))).thenReturn(statusDropdown);
    }

    @Test
    public void shouldDisplayJobOpeningScreenWhenInitialized() {
        assertTrue(createJobOpeningPage.isJobOpeningScreenDisplayed());
    }

    @Test
    public void shouldClickOnAddJobOpeningButton() {
        createJobOpeningPage.clickOnAddJobOpeningButton();
        verify(addJobOpeningButton).click();
    }

    @Test
    public void shouldReturnTrueWhenJobOpeningFormIsOpened() {
        assertTrue(createJobOpeningPage.isCreateNewJobOpeningFormOpened());
    }

    @Test
    public void shouldSelectJobRole() {
        createJobOpeningPage.selectJobRole("Developer");
        verify(jobRoleDropdown).click(); // Assuming click is the required action
    }

    @Test
    public void shouldEnterMinimumExperience() {
        createJobOpeningPage.enterMinimumExperience("2");
        verify(minExperienceInput).clear();
        verify(minExperienceInput).sendKeys("2");
    }

    @Test
    public void shouldEnterMaximumExperience() {
        createJobOpeningPage.enterMaximumExperience("5");
        verify(maxExperienceInput).clear();
        verify(maxExperienceInput).sendKeys("5");
    }

    @Test
    public void shouldEnterQualification() {
        createJobOpeningPage.enterQualification("Bachelor's Degree");
        verify(qualificationInput).clear();
        verify(qualificationInput).sendKeys("Bachelor's Degree");
    }

    @Test
    public void shouldEnterShortJobDescription() {
        createJobOpeningPage.enterShortJobDescription("Short description");
        verify(shortJobDescriptionInput).clear();
        verify(shortJobDescriptionInput).sendKeys("Short description");
    }

    @Test
    public void shouldEnterResponsibilities() {
        createJobOpeningPage.enterResponsibilities("Responsibility 1");
        verify(responsibilitiesInput).clear();
        verify(responsibilitiesInput).sendKeys("Responsibility 1");
    }

    @Test
    public void shouldEnterTags() {
        createJobOpeningPage.enterTags("tag1, tag2");
        verify(tagsInput).clear();
        verify(tagsInput).sendKeys("tag1, tag2");
    }

    @Test
    public void shouldSelectVendor() {
        createJobOpeningPage.selectVendor("Vendor A");
        verify(vendorDropdown).click(); // Assuming click is the required action
    }

    @Test
    public void shouldSelectEmploymentType() {
        createJobOpeningPage.selectEmploymentType("Full-time");
        verify(employmentTypeDropdown).click(); // Assuming click is the required action
    }

    @Test
    public void shouldSelectDuration() {
        createJobOpeningPage.selectDuration("6 months");
        verify(durationDropdown).click(); // Assuming click is the required action
    }

    @Test
    public void shouldSelectWorkMode() {
        createJobOpeningPage.selectWorkMode("Remote");
        verify(workModeDropdown).click(); // Assuming click is the required action
    }

    @Test
    public void shouldEnterDepartment() {
        createJobOpeningPage.enterDepartment("IT");
        verify(departmentInput).clear();
        verify(departmentInput).sendKeys("IT");
    }

    @Test
    public void shouldEnterIndustryType() {
        createJobOpeningPage.enterIndustryType("Software");
        verify(industryTypeInput).clear();
        verify(industryTypeInput).sendKeys("Software");
    }

    @Test
    public void shouldEnterPrimarySkills() {
        createJobOpeningPage.enterPrimarySkills("Java, Selenium");
        verify(primarySkillsInput).clear();
        verify(primarySkillsInput).sendKeys("Java, Selenium");
    }

    @Test
    public void shouldEnterSecondarySkills() {
        createJobOpeningPage.enterSecondarySkills("TestNG, JUnit");
        verify(secondarySkillsInput).clear();
        verify(secondarySkillsInput).sendKeys("TestNG, JUnit");
    }

    @Test
    public void shouldEnterTotalOpenings() {
        createJobOpeningPage.enterTotalOpenings("3");
        verify(totalOpeningsInput).clear();
        verify(totalOpeningsInput).sendKeys("3");
    }

    @Test
    public void shouldSelectStatus() {
        createJobOpeningPage.selectStatus("Open");
        verify(statusDropdown).click(); // Assuming click is the required action
    }

    @Test
    public void shouldCheckIfSaveCancelButtonsAreDisplayed() {
        when(saveButton.isDisplayed()).thenReturn(true);
        when(cancelButton.isDisplayed()).thenReturn(true);
        assertTrue(createJobOpeningPage.areSaveCancelButtonsDisplayed());
    }

    @Test
    public void shouldClickSave() {
        createJobOpeningPage.clicksSave();
        verify(saveButton).click();
    }
}
