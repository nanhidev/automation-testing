
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ExtendWith(MockitoExtension.class)
class WaitUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @Mock
    private WebElement anotherElement;

    @Mock
    private Alert alert;

    @Test
    void shouldReturnElementWhenVisible() {
        By locator = By.id("test");
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        when(driver.findElements(locator)).thenReturn(List.of(element));

        WebElement result = WaitUtils.waitForVisibility(driver, locator);
        assertNotNull(result);
        assertEquals(element, result);
    }

    @Test
    void shouldReturnElementWhenClickable() {
        By locator = By.id("test");
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        when(element.isEnabled()).thenReturn(true);
        when(driver.findElements(locator)).thenReturn(List.of(element));

        WebElement result = WaitUtils.waitForClickable(driver, locator);
        assertNotNull(result);
        assertEquals(element, result);
    }

    @Test
    void shouldReturnTrueWhenElementIsInvisible() {
        By locator = By.id("test");
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(false);

        boolean result = WaitUtils.waitForInvisibility(driver, locator);
        assertTrue(result);
    }

    @Test
    void shouldReturnAlertWhenPresent() {
        when(driver.switchTo().alert()).thenReturn(alert);
        when(alert.getText()).thenReturn("Test Alert");

        Alert result = WaitUtils.waitForAlert(driver);
        assertNotNull(result);
        assertEquals(alert, result);
    }

    @Test
    void shouldReturnTrueWhenUrlContainsText() {
        String text = "example";
        when(driver.getCurrentUrl()).thenReturn("http://example.com");

        boolean result = WaitUtils.waitForUrlContains(driver, text);
        assertTrue(result);
    }

    @Test
    void shouldReturnElementWhenVisibleWithTimeout() {
        By locator = By.id("test");
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        when(driver.findElements(locator)).thenReturn(List.of(element));

        WebElement result = WaitUtils.waitForVisibility(driver, locator, 5);
        assertNotNull(result);
        assertEquals(element, result);
    }

    @Test
    void shouldReturnTrueWhenNumberOfWindowsMatches() {
        int numberOfWindows = 2;
        when(driver.getWindowHandles()).thenReturn(List.of("1", "2"));

        boolean result = WaitUtils.waitForNumberOfWindows(driver, numberOfWindows);
        assertTrue(result);
    }

    @Test
    void shouldWaitForPageLoad() {
        when(driver.getCurrentUrl()).thenReturn("http://example.com");
        WaitUtils.waitForPageLoad(driver);
        verify(driver, times(1)).getCurrentUrl();
    }

    @Test
    void shouldReturnTrueWhenElementIsSelected() {
        when(element.isSelected()).thenReturn(true);
        boolean result = WaitUtils.waitForElementSelected(driver, element);
        assertTrue(result);
    }
}
