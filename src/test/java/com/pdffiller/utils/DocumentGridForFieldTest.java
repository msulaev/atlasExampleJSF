package com.pdffiller.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DocumentGridForFieldTest {
    private Dimension dimension;

    @BeforeEach
    void createDimension() {
        dimension = new Dimension(816, 1020);
    }

    @Test
    void createGrid_less_10_fields() {
        int fieldCount = 5;
        int[][] actual = DocumentGridForField.createGrid(fieldCount, dimension);
        int expectedLength = fieldCount;
        int actualLength = actual.length;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    void createGrid_more_10_and_even_fields() {
        int fieldCount = 18;
        int[][] actual = DocumentGridForField.createGrid(fieldCount, dimension);
        int expectedLength = fieldCount;
        int actualLength = actual.length;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    void createGrid_more_10_and_odd_fields() {
        int fieldCount = 13;
        int[][] actual = DocumentGridForField.createGrid(fieldCount, dimension);
        int expectedLength = fieldCount + 1;
        int actualLength = actual.length;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    void createGrid_range_boundaries() {
        int fieldCount = 15;
        int[][] actual = DocumentGridForField.createGrid(fieldCount, dimension);
        boolean cellOverseasBorderDocument = false;
        for (int[] cell : actual) {
            if ((dimension.getWidth() - Math.abs(cell[0])) < 1) {
                cellOverseasBorderDocument = true;
            }
            if ((dimension.getHeight() - Math.abs(cell[1])) < 1) {
                cellOverseasBorderDocument = true;
            }
        }
        assertFalse(cellOverseasBorderDocument);
    }
}