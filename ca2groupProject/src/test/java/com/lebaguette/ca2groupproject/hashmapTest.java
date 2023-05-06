/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.lebaguette.ca2groupproject;

import java.time.LocalDate;
import static org.junit.Assert.*;

/**
 *
 * @author leoze
 */
public class hashmapTest {

    /**
     * Test of size method, of class hash map. empty map
     */
    @org.junit.Test
    public void testSizeEmptyMap() {
        hashmap instance = new hashmap();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class hash map. one value
     */
    @org.junit.Test
    public void testSizeNonEmptyMap() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        instance.put(2, a);
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);

        Patient c = instance.get(2);
        assertEquals(a, c);
    }

    /**
     * Test of size method, of class hash map. size after removing one
     */
    @org.junit.Test
    public void testSizeAfterRemoving() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 1, 1), LocalDate.now());
        instance.put(2, a);
        instance.put(3, b);
        instance.remove(2);
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);

        Patient c = instance.get(2);
        assertEquals(null, c);
    }

    /**
     * Test of size method, of class hash map. updating value
     */
    @org.junit.Test
    public void testSizeAddingDuplicate() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 1, 1), LocalDate.now());
        instance.put(2, a);
        instance.put(2, b);
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);

        Patient c = instance.get(2);
        assertEquals(b, c);
    }

    /**
     * Test of put method, of class hash map. putting value in
     */
    @org.junit.Test
    public void testPutValue() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        instance.put(2, a);
        Patient expResult = a;
        Patient result = instance.get(2);
        assertEquals(expResult, result);

        int sizeExp = 1;
        int sizeAct = instance.size();
        assertEquals(sizeExp, sizeAct);
    }

    /**
     * Test of put method, of class hash map. updating value
     */
    @org.junit.Test
    public void testPutUpdateValue() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 1, 1), LocalDate.now());

        instance.put(2, a);
        instance.put(2, b);
        Patient expResult = b;
        Patient result = instance.get(2);
        assertEquals(expResult, result);

        int sizeExp = 1;
        int sizeAct = instance.size();
        assertEquals(sizeExp, sizeAct);
    }

    /**
     * Test of put method, of class hash map. putting value in beginning
     */
    @org.junit.Test
    public void testPutaddBegining() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 1, 1), LocalDate.now());

        instance.put(1, a);
        instance.put(2, b);
        Patient expResult = a;
        Patient result = instance.get(1);
        assertEquals(expResult, result);

        int sizeExp = 2;
        int sizeAct = instance.size();
        assertEquals(sizeExp, sizeAct);
    }

    /**
     * Test of put method, of class hash map. putting value in the end
     */
    @org.junit.Test
    public void testPutaddEnd() {
        hashmap instance = new hashmap();
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 1, 1), LocalDate.now());

        instance.put(20, b);
        Patient expResult = b;
        Patient result = instance.get(20);
        assertEquals(expResult, result);

        int sizeExp = 1;
        int sizeAct = instance.size();
        assertEquals(sizeExp, sizeAct);
    }

    /**
     * Test of put method, of class hash map. putting empty value
     */
    @org.junit.Test
    public void testPutEmptyvalue() {
        hashmap instance = new hashmap();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.put(0, null);
        });
    }

    /**
     * Test of put method, of class hash map. putting empty value
     */
    @org.junit.Test
    public void testPutEmptyKey() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        assertThrows(IllegalArgumentException.class, () -> {
            instance.put(2, a);
        });
    }

    /**
     * Test of get method, of class hash map. with empty map
     */
    @org.junit.Test
    public void testGetEmpty() {
        hashmap instance = new hashmap();
        Patient a = instance.get(1);
        assertEquals(null, a);

    }

    /**
     * Test of get method, of class hash map. with some values
     */
    @org.junit.Test
    public void testGetwithValues() {
        hashmap instance = new hashmap();
        Patient a = new Patient("Liam", "john", LocalDate.of(2001, 1, 1), LocalDate.now());

        instance.put(1, a);
        Patient b = instance.get(1);
        assertEquals(b, a);

        int expectSize = 1;
        int actualSize = instance.size();
        assertEquals(expectSize, actualSize);
    }

    /**
     * Test of get method, of class hash map. with empty map
     */
    @org.junit.Test
    public void testGetKeyNull() {
        hashmap instance = new hashmap();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.get(0);
        });
    }

    /**
     * Test of remove method, of class hash map. removing from empty map
     */
    @org.junit.Test
    public void testRemoveEmpty() {
        hashmap instance = new hashmap();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.remove(1);
        });
    }

    /**
     * Test of remove method, of class hash map. removing from filled map
     */
    @org.junit.Test
    public void testRemoveValue() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 3, 1), LocalDate.now());
        Patient c = new Patient("adam", "john", LocalDate.of(2002, 3, 1), LocalDate.now());
        instance.put(1, a);
        instance.put(2, b);
        instance.put(3, c);

        Patient removed = instance.remove(1);
        assertEquals(removed, a);

        int excSize = 2;
        int actualSize = instance.size();

        assertEquals(excSize, actualSize);

        assertEquals(null, instance.get(1));
    }

    /**
     * Test of remove method, of class hash map. removing from filled map
     */
    @org.junit.Test
    public void testRemoveValuelast() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 3, 1), LocalDate.now());
        Patient c = new Patient("adam", "john", LocalDate.of(2002, 3, 1), LocalDate.now());
        instance.put(1, a);
        instance.put(2, b);
        instance.put(3, c);

        Patient removed = instance.remove(3);
        assertEquals(removed, a);

        int excSize = 2;
        int actualSize = instance.size();

        assertEquals(excSize, actualSize);

        assertEquals(null, instance.get(3));
    }

    /**
     * Test of containsKey method, of class hashmap.
     */
    @org.junit.Test
    public void testContainsKeyNull() {
        hashmap instance = new hashmap();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.containsKey(0);
        });

    }

    /**
     * Test of containsKey method, of class hashmap.
     */
    @org.junit.Test
    public void testContainsKeyEmpty() {
        hashmap instance = new hashmap();

        boolean expected = false;
        boolean actual = instance.containsKey(1);

        assertEquals(expected, actual);
    }

    /**
     * Test of containsKey method, of class hashmap.
     */
    @org.junit.Test
    public void testContainsKeyvalues() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 3, 1), LocalDate.now());
        instance.put(1, a);
        instance.put(2, b);
        
        boolean expected = true;
        boolean actual = instance.containsKey(1);

        
        assertEquals(expected, actual);
        
        assertEquals(a,instance.get(1));
        
        instance.remove(1);
        assertEquals(false,instance.containsKey(1));
        
    }

    /**
     * Test of getKeys method, of class hashmap.
     */
    @org.junit.Test
    public void testGetKeys() {
        hashmap instance = new hashmap();
        Patient a = new Patient("John", "Doe", LocalDate.of(2000, 1, 1), LocalDate.now());
        Patient b = new Patient("Liam", "john", LocalDate.of(2001, 3, 1), LocalDate.now());
        Patient c = new Patient("adam", "west", LocalDate.of(2003, 3, 1), LocalDate.now());
        instance.put(1, a);
        instance.put(2, b);
        instance.put(3, c);
        
        int [] expected = {1,2,3};
        int[] actual = instance.getKeys();
        
        assertArrayEquals(expected,actual);
       
        assertEquals(3,instance.size());
        
    }

    /**
     * Test of getValues method, of class hashmap.
     */
    @org.junit.Test
    public void testGetValues() {
        System.out.println("getValues");
        hashmap instance = new hashmap();
        Patient[] expResult = null;
        Patient[] result = instance.getValues();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
