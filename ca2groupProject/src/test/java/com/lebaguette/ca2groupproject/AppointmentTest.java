package com.lebaguette.ca2groupproject;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AppointmentTest {

    /**
     * Test the equality of two appointments with the same patient data, issue, and date.
     */
    @Test
    public void testEquals() {
        LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);
        LocalDate date = LocalDate.of(2023, 5, 7);

        Appointment appointment1 = new Appointment("John", "Doe", dateOfBirth,
                "Test issue", date, 3, "Dr. Smith");
        Appointment appointment2 = new Appointment("John", "Doe", dateOfBirth,
                "Test issue", date, 3, "Dr. Smith");

        assertTrue(appointment1.equals(appointment2));
    }

    /**
     * Test the inequality of two appointments with different patient data, issue, or date.
     */
    @Test
    public void testNotEquals() {
        LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);
        LocalDate date = LocalDate.of(2023, 5, 7);

        Appointment appointment1 = new Appointment("John", "Doe", dateOfBirth,
                "Test issue", date, 3, "Dr. Smith");
        Appointment appointment2 = new Appointment("Jane", "Smith", dateOfBirth,
                "Test issue", date, 3, "Dr. Smith");

        assertFalse(appointment1.equals(appointment2));

        appointment2.setFirstName("John");
        assertFalse(appointment1.equals(appointment2));

        appointment2.setLastName("Doe");
        assertFalse(appointment1.equals(appointment2));

        appointment2.setDateOfBirth(LocalDate.of(2000, 1, 2));
        assertFalse(appointment1.equals(appointment2));

        appointment2.setDate(LocalDate.of(2023, 5, 8));
        assertFalse(appointment1.equals(appointment2));
    }

    /**
     * Test the hashCode method.
     */
    @Test
    public void testHashCode() {
        LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);
        LocalDate date = LocalDate.of(2023, 5, 7);

        Appointment appointment1 = new Appointment("John", "Doe", dateOfBirth,
                "Test issue", date, 3, "Dr. Smith");
        Appointment appointment2 = new Appointment("John", "Doe", dateOfBirth,
                "Test issue", date, 3, "Dr. Smith");

        assertEquals(appointment1.hashCode(), appointment2.hashCode());
    }

    /**
     * Test the compareTo method.
     */
    @Test
    public void testCompareTo() {
        LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);
        LocalDate date = LocalDate.of(2023, 5, 7);

        Appointment appointment1 = new Appointment("John", "Doe", dateOfBirth,
                "Test issue", date, 3, "Dr. Smith");
        Appointment appointment2 = new Appointment("Jane", "Smith", dateOfBirth,
                "Test issue", date, 2, "Dr. Johnson");
        Appointment appointment3 = new Appointment("David", "Brown", dateOfBirth,
                "Test issue", date, 4, "Dr. Davis");

        assertTrue(appointment1.compareTo(appointment2) > 0);
        assertTrue(appointment2.compareTo(appointment1) < 0);
        assertEquals(0, appointment1.compareTo(appointment1));
        assertTrue(appointment2.compareTo(appointment3) < 0);
        assertTrue(appointment3.compareTo(appointment2) > 0);
    }
}
