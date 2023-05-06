/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.lebaguette.ca2groupproject;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leoze
 */
public class PatientTest {

    /**
     * Test of constructor method, of class Patient. date of birth greater than
     * current year
     */
    @Test
    public void testConstructorDateBirthBigger() {
        assertThrows(IllegalArgumentException.class, () -> {
            Patient b = new Patient("Liam", "john", LocalDate.of(2023, 1, 1), LocalDate.now());
        });
    }

    /**
     * Test of constructor method, of class Patient. date joined greater than
     * current year
     */
    @Test
    public void testConstructorDatejoinedBigger() {
        assertThrows(IllegalArgumentException.class, () -> {
            Patient b = new Patient("Liam", "john", LocalDate.of(2005, 1, 1), LocalDate.of(2024, 2, 5));
        });
    }

    /**
     * Test of setDateOfBirth method, of class Patient.
     */
    @Test
    public void testSetDateOfBirthaftercurrent() {
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 1, 1), LocalDate.now());

        assertThrows(IllegalArgumentException.class, () -> {
            b.setDateOfBirth(LocalDate.of(2024, 1, 1));
        });

    }

    /**
     * Test of setDateJoined method, of class Patient.
     */
    @Test
    public void testSetDateJoinedAftercurrent() {
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 1, 1), LocalDate.now());

        assertThrows(IllegalArgumentException.class, () -> {
            b.setDateJoined(LocalDate.of(2024, 1, 1));
        });
    }

}
