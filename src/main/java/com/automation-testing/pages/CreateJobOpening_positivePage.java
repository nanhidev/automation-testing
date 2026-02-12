package com.backend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.ElementUtils;
import org.junit.Assert;

public class CreateJobOpeningPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    public CreateJobOpeningPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "jobOpeningScreen")
    private WebElement jobOpeningScreen;

    @FindBy(id = "addJobOpeningButton")
    private WebElement addJobOpeningButton;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    @FindBy(id = "cancelButton")
    private WebElement cancelButton;

    @FindBy(id = "jobRoleDropdown")
    private WebElement jobRoleDropdown;

    @FindBy(id = "locationDropdown")
    private WebElement locationDropdown;

    @FindBy(id = "minExperienceInput")
    private WebElement minExperienceInput;

    @FindBy(id = "maxExperienceInput")
    private WebElement maxExperienceInput;

    @FindBy(id = "qualificationInput")
    private WebElement qualificationInput;

    @FindBy(id = "shortJobDescriptionInput")
    private WebElement shortJobDescriptionInput;

    @FindBy(id = "responsibilitiesInput")
    private WebElement responsibilitiesInput;

    @FindBy(id = "tagsInput")
    private WebElement tagsInput;

    @FindBy(id = "vendorDropdown")
    private WebElement vendorDropdown;

    @FindBy(id = "employmentTypeDropdown")
    private WebElement employmentTypeDropdown;

    @FindBy(id = "durationDropdown")
    private WebElement durationDropdown;

    @FindBy(id = "workModeDropdown")
    private WebElement workModeDropdown;

    @FindBy(id = "departmentInput")
    private WebElement departmentInput;

    @FindBy(id = "industryTypeInput")
    private WebElement industryTypeInput;

    @FindBy(id = "primarySkillsInput")
    private WebElement primarySkillsInput;

    @FindBy(id = "secondarySkillsInput")
    private WebElement secondarySkillsInput;

    @FindBy(id = "totalOpeningsInput")
    private WebElement totalOpeningsInput;

    @FindBy(id = "statusDropdown")
    private WebElement statusDropdown;

    public void loginAsRecruiter() {
        // Implementation for logging in as a recruiter
    }

    public void clickOnJobOpeningOption(String jobOpeningOption) {
        try {
            elementUtils.clickElement(driver.findElement(By.xpath("//a[text()='" + jobOpeningOption + "']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isJobOpeningScreenDisplayed() {
        return elementUtils.isElementDisplayed(jobOpeningScreen);
    }

    public boolean isButtonVisible(String buttonName) {
        WebElement button = driver.findElement(By.id(buttonName + "Button"));
        return elementUtils.isElementDisplayed(button);
    }

    public void clickOnAddJobOpeningButton() {
        try {
            elementUtils.clickElement(addJobOpeningButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isCreateNewJobOpeningFormOpened() {
        // Logic to determine if the form is opened
        return true; // Replace with actual condition
    }

    public void selectJobRole(String jobRole) {
        try {
            elementUtils.selectOptionInDropdown(jobRoleDropdown, jobRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectLocation(String location) {
        try {
            elementUtils.selectOptionInDropdown(locationDropdown, location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterMinimumExperience(String minExperience) {
        try {
            elementUtils.clearAndSendKeys(minExperienceInput, minExperience);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterMaximumExperience(String maxExperience) {
        try {
            elementUtils.clearAndSendKeys(maxExperienceInput, maxExperience);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterQualification(String qualification) {
        try {
            elementUtils.clearAndSendKeys(qualificationInput, qualification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterShortJobDescription(String shortJobDescription) {
        try {
            elementUtils.clearAndSendKeys(shortJobDescriptionInput, shortJobDescription);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterResponsibilities(String responsibilities) {
        try {
            elementUtils.clearAndSendKeys(responsibilitiesInput, responsibilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterTags(String tags) {
        try {
            elementUtils.clearAndSendKeys(tagsInput, tags);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectVendor(String vendor) {
        try {
            elementUtils.selectOptionInDropdown(vendorDropdown, vendor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectEmploymentType(String employmentType) {
        try {
            elementUtils.selectOptionInDropdown(employmentTypeDropdown, employmentType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectDuration(String duration) {
        try {
            elementUtils.selectOptionInDropdown(durationDropdown, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectWorkMode(String workMode) {
        try {
            elementUtils.selectOptionInDropdown(workModeDropdown, workMode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterDepartment(String department) {
        try {
            elementUtils.clearAndSendKeys(departmentInput, department);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterIndustryType(String industryType) {
        try {
            elementUtils.clearAndSendKeys(industryTypeInput, industryType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPrimarySkills(String primarySkills) {
        try {
            elementUtils.clearAndSendKeys(primarySkillsInput, primarySkills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterSecondarySkills(String secondarySkills) {
        try {
            elementUtils.clearAndSendKeys(secondarySkillsInput, secondarySkills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterTotalOpenings(String totalOpenings) {
        try {
            elementUtils.clearAndSendKeys(totalOpeningsInput, totalOpenings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectStatus(String status) {
        try {
            elementUtils.selectOptionInDropdown(statusDropdown, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isJobOpeningSavedSuccessfully() {
        // Logic to determine if job opening was saved successfully
        return true; // Replace with actual condition
    }

    public boolean isJobOpeningAvailableInList() {
        // Logic to check if job opening is available in the list
        return true; // Replace with actual condition
    }

    public boolean areSaveCancelButtonsDisplayed() {
        return elementUtils.isElementDisplayed(saveButton) && elementUtils.isElementDisplayed(cancelButton);
    }

    public void clicksSave() {
        try {
            elementUtils.clickElement(saveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}