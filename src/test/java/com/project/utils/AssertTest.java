
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.*;

public class AssertTest {

    @InjectMocks
    private Assert assertInstance;

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @Test
    void shouldAssertAll() {
        // This method does not require any stubbing or verification.
        Assert.assertAll();
    }

    @Test
    void shouldResetSoftAssert() {
        // This method does not require any stubbing or verification.
        Assert.resetSoftAssert();
    }

    @Test
    void shouldAssertTrue() {
        Assert.assertTrue(true, "Condition is true");
    }

    @Test
    void shouldAssertTrueSoft() {
        Assert.assertTrueSoft(true, "Soft assert true");
    }

    @Test
    void shouldAssertFalse() {
        Assert.assertFalse(false, "Condition is false");
    }

    @Test
    void shouldAssertFalseSoft() {
        Assert.assertFalseSoft(false, "Soft assert false");
    }

    @Test
    void shouldAssertEquals() {
        Assert.assertEquals("test", "test", "Strings should be equal");
    }

    @Test
    void shouldAssertNotEquals() {
        Assert.assertNotEquals("test", "different", "Strings should not be equal");
    }

    @Test
    void shouldAssertNotNull() {
        Assert.assertNotNull(element, "Element should not be null");
    }

    @Test
    void shouldAssertNull() {
        Assert.assertNull(null, "Value should be null");
    }

    @Test
    void shouldAssertContains() {
        Assert.assertContains("Hello World", "World", "String should contain substring");
    }

    @Test
    void shouldAssertNotContains() {
        Assert.assertNotContains("Hello World", "Java", "String should not contain substring");
    }

    @Test
    void shouldAssertElementVisible() {
        when(element.isDisplayed()).thenReturn(true);
        Assert.assertElementVisible(driver, element, "Element should be visible");
    }

    @Test
    void shouldAssertElementNotVisible() {
        when(element.isDisplayed()).thenReturn(false);
        Assert.assertElementNotVisible(driver, element, "Element should not be visible");
    }

    @Test
    void shouldAssertElementEnabled() {
        when(element.isEnabled()).thenReturn(true);
        Assert.assertElementEnabled(driver, element, "Element should be enabled");
    }

    @Test
    void shouldAssertElementDisabled() {
        when(element.isEnabled()).thenReturn(false);
        Assert.assertElementDisabled(driver, element, "Element should be disabled");
    }

    @Test
    void shouldAssertElementClickable() {
        when(element.isEnabled()).thenReturn(true);
        Assert.assertElementClickable(driver, element, "Element should be clickable");
    }

    @Test
    void shouldAssertElementText() {
        when(element.getText()).thenReturn("Expected Text");
        Assert.assertElementText(driver, element, "Expected Text", "Element text verification");
    }

    @Test
    void shouldAssertElementPresent() {
        when(driver.findElements(any())).thenReturn(java.util.Collections.singletonList(element));
        Assert.assertElementPresent(driver, null, "Element should be present in DOM");
    }

    @Test
    void shouldAssertElementNotPresent() {
        when(driver.findElements(any())).thenReturn(java.util.Collections.emptyList());
        Assert.assertElementNotPresent(driver, null, "Element should not be present in DOM");
    }
}
