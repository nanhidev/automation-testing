
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.Scenario;

@ExtendWith(MockitoExtension.class)
class CommonUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @Mock
    private Scenario scenario;

    @InjectMocks
    private CommonUtils commonUtils;

    @Test
    void shouldGenerateEmailWithTimestamp() {
        String email = CommonUtils.getEmailWithTimeStamp();
        assertTrue(email.startsWith("newemail") && email.endsWith("@gmail.com"));
    }

    @Test
    void shouldTakeScreenshot() {
        when(driver).thenReturn(driver);
        when(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)).thenReturn(new byte[0]);

        byte[] screenshot = CommonUtils.takeScreenShot(scenario, driver, "TestScenario");
        assertNotNull(screenshot);
    }

    @Test
    void shouldScrollToBottom() {
        when(driver).thenReturn(driver);
        when(((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight")).thenReturn(100L);

        CommonUtils.scrollToBottom(driver);
        verify((JavascriptExecutor) driver, atLeastOnce()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Test
    void shouldScrollToTop() {
        when(driver).thenReturn(driver);
        when(((JavascriptExecutor) driver).executeScript("return window.pageYOffset")).thenReturn(100L);

        CommonUtils.scrollToTop(driver);
        verify((JavascriptExecutor) driver, atLeastOnce()).executeScript("window.scrollBy(0, -1000);");
    }

    @Test
    void shouldVerifyDropdownSelectedOptionIndex() {
        Select mockSelect = mock(Select.class);
        WebElement mockOption = mock(WebElement.class);

        when(mockSelect.getFirstSelectedOption()).thenReturn(mockOption);
        when(mockSelect.getOptions()).thenReturn(Collections.singletonList(mockOption));
        when(mockOption.getText()).thenReturn("Option1");
        when(mockSelect.getOptions().indexOf(mockOption)).thenReturn(0);

        CommonUtils.DropdownSelectedOptionVerification(mockSelect, 0, "Dropdown index should match");
    }

    @Test
    void shouldCaptureScreenshot() throws IOException {
        File mockFile = mock(File.class);
        when(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)).thenReturn(mockFile);
        when(System.getProperty("user.dir")).thenReturn("/path/to/project");

        String path = CommonUtils.captureScreenshot(driver, "screenshot");
        assertEquals("/path/to/project/screenshots/screenshot.png", path);
    }

    @Test
    void shouldSwitchToNewWindow() {
        when(driver.getWindowHandle()).thenReturn("currentWindow");
        when(driver.getWindowHandles()).thenReturn(new ArrayList<>(Arrays.asList("currentWindow", "newWindow")));

        CommonUtils.switchToNewWindow(driver);
        verify(driver).switchTo().window("newWindow");
    }

    @Test
    void shouldSwitchToParentWindow() {
        when(driver.getWindowHandles()).thenReturn(new ArrayList<>(Arrays.asList("parentWindow", "childWindow")));

        CommonUtils.switchToParentWindow(driver);
        verify(driver).switchTo().window("parentWindow");
    }

    @Test
    void shouldUploadFileDirectly() {
        String filePath = "C:/path/to/file.txt";
        CommonUtils.uploadFile(element, filePath);
        verify(element).sendKeys(filePath);
    }

    @Test
    void shouldCheckIfAlertIsPresent() {
        when(driver.switchTo().alert()).thenReturn(null);
        boolean present = CommonUtils.isAlertPresent(driver);
        assertFalse(present);
    }

    @Test
    void shouldAcceptAlert() {
        Alert mockAlert = mock(Alert.class);
        when(driver.switchTo().alert()).thenReturn(mockAlert);

        CommonUtils.acceptAlert(driver);
        verify(mockAlert).accept();
    }

    @Test
    void shouldDismissAlert() {
        Alert mockAlert = mock(Alert.class);
        when(driver.switchTo().alert()).thenReturn(mockAlert);

        CommonUtils.dismissAlert(driver);
        verify(mockAlert).dismiss();
    }

    @Test
    void shouldWaitForElementVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
        verify(driver, times(1)).findElement(any());
    }

    @Test
    void shouldWaitForElementClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(element));
        verify(driver, times(1)).findElement(any());
    }

    @Test
    void shouldWaitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    @Test
    void shouldRefreshPage() {
        CommonUtils.refreshPage(driver);
        verify(driver).navigate().refresh();
    }

    @Test
    void shouldMaximizeWindow() {
        CommonUtils.maximizeWindow(driver);
        verify(driver).manage().window().maximize();
    }

    @Test
    void shouldSleep() throws InterruptedException {
        CommonUtils.sleep(1);
        // Sleep for 1 second
        verify(Thread.class, times(1)).sleep(1000);
    }
}
