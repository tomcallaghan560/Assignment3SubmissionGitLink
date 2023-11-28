package com.colourtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTest {
    @Test
    void testConstructorWithValidPaletteSizeGreaterThan1() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1));
    }

    @Test
    void testConstructorWithValidPaletteSizeLessThan1025() {

        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025));
    }

    @Test
    void testConstructorWithValidPaletteSizePowerOfTwo() {
        int number = 2;
        while (number < 1025) {
            ColourTable colourTable = new ColourTable(number);
            assertNotNull(colourTable);
            number = number * 2;
        }
    }

    @Test
    void testConstructorWithInvalidPaletteSizeNotPowerOfTwo() {
        int number = 1;

        while (number < 1025) {
            // Check if the number is not a power of two
            if ((number & (number - 1)) != 0) {
                int finalNumber = number;
                assertThrows(IllegalArgumentException.class, () -> new ColourTable(finalNumber));
            }
            number++;
        }
    }

}



