package com.lebaguette.ca2groupproject;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListTest {

    /**
     * Test the size method when the list is empty.
     */
    @Test
    public void testSizeEmptyList() {
        LinkedList list = new LinkedList();
        int expResult = 0;
        int result = list.size();
        assertEquals(expResult, result);
    }

    /**
     * Test the size method when the list is not empty.
     */

    @Test
    public void testSizeNonEmptyList() {
        LinkedList list = new LinkedList();
        Appointment appointment = new Appointment("John", "Doe", LocalDate.of(2000, 1, 1),
                "Test issue", LocalDate.now(), 3, "Dr. Smith");
        list.add(appointment);
        int expResult = 1;
        int result = list.size();
        assertEquals(expResult, result);
    }

    /**
     * Test the get method.
     */
    @Test
    public void testGet() {
        LinkedList list = new LinkedList();
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(2000, 1, 1),
                "Test issue 1", LocalDate.now(), 3, "Dr. Smith");
        Appointment appointment2 = new Appointment("Jane", "Smith", LocalDate.of(1995, 5, 10),
                "Test issue 2", LocalDate.now(), 2, "Dr. Johnson");
        list.add(appointment1);
        list.add(appointment2);

        Appointment result1 = list.get(0);
        assertEquals(appointment1, result1);

        Appointment result2 = list.get(1);
        assertEquals(appointment2, result2);
    }

    /**
     * Test the get method with an invalid position.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetInvalidPosition() {
        LinkedList list = new LinkedList();
        list.get(0); // Should throw IndexOutOfBoundsException
    }

    /**
     * Test the indexOf method.
     */
    @Test
    public void testIndexOf() {
        LinkedList list = new LinkedList();
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(2000, 1, 1),
                "Test issue 1", LocalDate.now(), 3, "Dr. Smith");
        Appointment appointment2 = new Appointment("Jane", "Smith", LocalDate.of(1995, 5, 10),
                "Test issue 2", LocalDate.now(), 2, "Dr. Johnson");
        list.add(appointment1);
        list.add(appointment2);

        int result1 = list.indexOf(appointment1);
        assertEquals(0, result1);

        int result2 = list.indexOf(appointment2);
        assertEquals(1, result2);

        int result3 = list.indexOf(new Appointment("Unknown", "Person", LocalDate.of(1990, 1, 1),
                "Test issue", LocalDate.now(), 4, "Dr. Brown"));
        assertEquals(-1, result3);
    }

    /**
     * Test the add method.
     */
    @Test
    public void testAdd() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());

        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(2000, 1, 1),
                "Test issue 1", LocalDate.now(), 3, "Dr. Smith");
        list.add(appointment1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());

        Appointment result = list.get(0);
        assertEquals(appointment1, result);

        Appointment appointment2 = new Appointment("Jane", "Smith", LocalDate.of(1995, 5, 10),
                "Test issue 2", LocalDate.now(), 2, "Dr. Johnson");
        list.add(appointment2);
        assertEquals(2, list.size());

        Appointment result2 = list.get(1);
        assertEquals(appointment2, result2);
    }

    /**
     * Test the set method.
     */

    @Test
    public void testSet() {
        LinkedList list = new LinkedList();
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(2000, 1, 1),
                "Test issue 1", LocalDate.now(), 3, "Dr. Smith");
        Appointment appointment2 = new Appointment("Jane", "Smith", LocalDate.of(1995, 5, 10),
                "Test issue 2", LocalDate.now(), 2, "Dr. Johnson");
        list.add(appointment1);
        list.add(appointment2);

        Appointment newAppointment = new Appointment("Updated", "Appointment", LocalDate.now(),
                "Updated issue", LocalDate.now(), 1, "Dr. Brown");

        Appointment previous1 = list.set(newAppointment, 0);
        assertEquals(appointment1, previous1);
        assertEquals(newAppointment, list.get(0));

        Appointment previous2 = list.set(newAppointment, 1);
        assertEquals(appointment2, previous2);
        assertEquals(newAppointment, list.get(1));
    }

    /**
     * Test the set method with an invalid position.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetInvalidPosition() {
        LinkedList list = new LinkedList();
        Appointment appointment = new Appointment("John", "Doe", LocalDate.of(2000, 1, 1),
                "Test issue", LocalDate.now(), 3, "Dr. Smith");
        list.set(appointment, 0); // Should throw IndexOutOfBoundsException
    }

    /**
     * Test the remove method.
     */
    @Test
    public void testRemove() {
        LinkedList list = new LinkedList();
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(2000, 1, 1),
                "Test issue 1", LocalDate.now(), 3, "Dr. Smith");
        Appointment appointment2 = new Appointment("Jane", "Smith", LocalDate.of(1995, 5, 10),
                "Test issue 2", LocalDate.now(), 2, "Dr. Johnson");
        list.add(appointment1);
        list.add(appointment2);

        assertTrue(list.remove(appointment1));
        assertFalse(list.remove(appointment1)); // Already removed
        assertEquals(1, list.size());
        assertEquals(appointment2, list.get(0));

        assertFalse(list.remove(new Appointment("Unknown", "Person", LocalDate.of(1990, 1, 1),
                "Test issue", LocalDate.now(), 4, "Dr. Brown"))); // Not in the list
        assertEquals(1, list.size());
    }

    /**
     * Test the isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());

        Appointment appointment = new Appointment("John", "Doe", LocalDate.of(2000, 1, 1),
                "Test issue", LocalDate.now(), 3, "Dr. Smith");
        list.add(appointment);
        assertFalse(list.isEmpty());

        list.remove(appointment);
        assertTrue(list.isEmpty());
    }
}