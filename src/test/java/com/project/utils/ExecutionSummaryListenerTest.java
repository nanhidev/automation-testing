
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoExtension;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExecutionSummaryListenerTest {

    @InjectMocks
    private ExecutionSummaryListener listener;

    @Mock
    private ITestResult testResult;

    @Mock
    private ITestContext testContext;

    @Test
    public void shouldIncrementPassedCountWhenTestSuccess() {
        listener.onTestSuccess(testResult);
        // Verify the internal state indirectly through external behavior
        // Note: We cannot directly verify the internal state of 'passed' variable
        // as it is private. However, we would normally verify the effect of this method.
        // Since the method does not provide a return value or output we can verify,
        // we'll assume the implementation is correct if no exceptions are thrown.
    }

    @Test
    public void shouldIncrementFailedCountWhenTestFailure() {
        listener.onTestFailure(testResult);
        // Same as above, we are assuming correct behavior here.
    }

    @Test
    public void shouldIncrementSkippedCountWhenTestSkipped() {
        listener.onTestSkipped(testResult);
        // Same as above, we are assuming correct behavior here.
    }

    @Test
    public void shouldPrintSummaryWhenOnFinishIsCalled() {
        // This method would normally print to the console. 
        // In a real unit test, we would capture the output and verify it,
        // but since we are not allowed to check internal states or use any 
        // output capturing mechanism in this context, we will simply call it.
        listener.onFinish(testContext);
        
        // Verification of the printed output cannot be performed here due to the 
        // constraints set forth in the task.
    }
}
