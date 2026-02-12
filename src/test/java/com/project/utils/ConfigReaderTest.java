
package com.project.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConfigReaderTest {

    @InjectMocks
    private ConfigReader configReader;

    @Mock
    private Properties properties;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("user.dir", "test/dir");
        File file = mock(File.class);
        FileInputStream fis = mock(FileInputStream.class);

        when(file.exists()).thenReturn(true);
        when(file.getPath()).thenReturn("test/path");
        when(properties.getProperty("browser")).thenReturn("chrome");
        when(properties.getProperty("url")).thenReturn("http://localhost");
        when(properties.getProperty("implicit.wait")).thenReturn("10");
        when(properties.getProperty("explicit.wait")).thenReturn("20");
        when(properties.getProperty("browser.headless")).thenReturn("false");
        when(properties.getProperty("environment")).thenReturn("development");
        when(properties.getProperty("framework.type")).thenReturn("cucumber-junit");
        when(properties.getProperty("test.runner")).thenReturn("junit");
        when(properties.getProperty("cucumber.tags")).thenReturn("@smoke");
        when(properties.getProperty("cucumber.features.path")).thenReturn("src/test/resources/features");
        when(properties.getProperty("cucumber.glue.path")).thenReturn("src/test/java/steps");
        when(properties.getProperty("report.path")).thenReturn("reports/");
        when(properties.getProperty("screenshot.on.failure")).thenReturn("true");
        when(properties.getProperty("playwright.enabled")).thenReturn("false");
        when(properties.getProperty("visual.regression.enabled")).thenReturn("false");
        when(properties.getProperty("playwright.browser")).thenReturn("chromium");
        
        // Simulate loading properties
        configReader = ConfigReader.getInstance();
        configReader.loadProperties();
    }

    @Test
    public void shouldReturnBrowserWhenGetBrowserCalled() {
        assertEquals("chrome", configReader.getBrowser());
    }

    @Test
    public void shouldReturnBaseUrlWhenGetBaseUrlCalled() {
        assertEquals("http://localhost", configReader.getBaseUrl());
    }

    @Test
    public void shouldReturnImplicitWaitWhenGetImplicitWaitCalled() {
        assertEquals(10, configReader.getImplicitWait());
    }

    @Test
    public void shouldReturnExplicitWaitWhenGetExplicitWaitCalled() {
        assertEquals(20, configReader.getExplicitWait());
    }

    @Test
    public void shouldReturnHeadlessWhenIsHeadlessCalled() {
        assertFalse(configReader.isHeadless());
    }

    @Test
    public void shouldReturnEnvironmentWhenGetEnvironmentCalled() {
        assertEquals("development", configReader.getEnvironment());
    }

    @Test
    public void shouldReturnFrameworkTypeWhenGetFrameworkTypeCalled() {
        assertEquals("cucumber-junit", configReader.getFrameworkType());
    }

    @Test
    public void shouldReturnTestRunnerWhenGetTestRunnerCalled() {
        assertEquals("junit", configReader.getTestRunner());
    }

    @Test
    public void shouldReturnCucumberTagsWhenGetCucumberTagsCalled() {
        assertEquals("@smoke", configReader.getCucumberTags());
    }

    @Test
    public void shouldReturnFeaturePathWhenGetFeaturePathCalled() {
        assertEquals("src/test/resources/features", configReader.getFeaturePath());
    }

    @Test
    public void shouldReturnGluePathWhenGetGluePathCalled() {
        assertEquals("src/test/java/steps", configReader.getGluePath());
    }

    @Test
    public void shouldReturnReportPathWhenGetReportPathCalled() {
        assertEquals("reports/", configReader.getReportPath());
    }

    @Test
    public void shouldReturnScreenshotOnFailureWhenIsScreenshotOnFailureCalled() {
        assertTrue(configReader.isScreenshotOnFailure());
    }

    @Test
    public void shouldReturnPlaywrightEnabledWhenIsPlaywrightEnabledCalled() {
        assertFalse(configReader.isPlaywrightEnabled());
    }

    @Test
    public void shouldReturnVisualRegressionEnabledWhenIsVisualRegressionEnabledCalled() {
        assertFalse(configReader.isVisualRegressionEnabled());
    }

    @Test
    public void shouldReturnPlaywrightBrowserWhenGetPlaywrightBrowserCalled() {
        assertEquals("chromium", configReader.getPlaywrightBrowser());
    }
}
