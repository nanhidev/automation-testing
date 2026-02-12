
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ExtendWith(MockitoExtension.class)
public class ElementUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @InjectMocks
    private ElementUtils elementUtils;

    @Test
    public void shouldReturnRandomTime() {
        LocalTime randomTime = ElementUtils.getRandomTime();
        assertNotNull(randomTime);
    }

    @Test
    public void shouldCheckElementReadOnly() {
        when(element.getAttribute("disabled")).thenReturn("false");
        when(element.getAttribute("readonly")).thenReturn("true");

        boolean isReadOnly = elementUtils.isElementReadOnly(driver, element);
        assertFalse(isReadOnly);
    }

    @Test
    public void shouldClickElement() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        
        elementUtils.clickElement(element);
        verify(element).click();
    }

    @Test
    public void shouldClearAndSendKeys() throws InterruptedException {
        when(driver).thenReturn(driver);
        when(element.isDisplayed()).thenReturn(true);
        when(element.isEnabled()).thenReturn(true);
        
        elementUtils.clearAndSendKeys(element, "test");
        verify(element).clear();
        verify(element).sendKeys("test");
    }

    @Test
    public void shouldWaitForElement() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        
        WebElement result = elementUtils.waitForElement(element, 10);
        assertNotNull(result);
    }

    @Test
    public void shouldCheckFieldReadOnly() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        when(element.getAttribute("readonly")).thenReturn("true");

        elementUtils.checkFieldReadOnly(driver, By.id("testId"));
        verify(element).getAttribute("readonly");
    }

    @Test
    public void shouldCheckFieldNotReadOnly() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        when(element.getAttribute("readonly")).thenReturn(null);

        elementUtils.checkFieldNotReadOnly(driver, By.id("testId"));
        verify(element).getAttribute("readonly");
    }

    @Test
    public void shouldSelectOptionInDropdown() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        elementUtils.selectOptionInDropdown(element, "Option 1");
        verify(element).click();
    }

    @Test
    public void shouldVerifyDropdownOptions() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        List<String> expectedOptions = Collections.singletonList("Option 1");
        elementUtils.verifyDropdownOptions(element, expectedOptions, "Dropdown option count mismatch");
    }

    @Test
    public void shouldCheckElementDisplayed() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);

        boolean isDisplayed = elementUtils.isElementDisplayed(element);
        assertTrue(isDisplayed);
    }

    @Test
    public void shouldVerifyCellIsReadOnly() {
        when(cell.getAttribute("aria-readonly")).thenReturn("true");
        elementUtils.verifyCellIsReadOnly(cell);
        verify(cell).getAttribute("aria-readonly");
    }

    @Test
    public void shouldVerifyCellIsEditable() {
        when(cell.getAttribute("aria-readonly")).thenReturn(null);
        elementUtils.verifyCellIsEditable(cell);
        verify(cell).getAttribute("aria-readonly");
    }
}
