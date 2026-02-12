
package com.project.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilePathTest {

    @Test
    public void shouldReturnCorrectConfigPropertyFilePath() {
        // Act
        String result = FilePath.getConfigPropertyFilePath();

        // Assert
        assertEquals("/src/test/resources/com/project/config/config.properties", result);
    }
}
