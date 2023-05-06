/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lebaguette.ca2groupproject;

import java.util.LinkedList;

/**
 * collision hash map
 *
 * @author leoze
 */
public class hashmap {

    private static final int INITIAL_CAPACITY = 20;
    private LinkedList<Entry>[] data;
    private int size;

    /**
     * Creates an empty hash map with initial capacity
     */
    public hashmap() {
        data = new LinkedList[INITIAL_CAPACITY];
    }
    
    /**
     * returns the number of key-values stored in the hash map
     * 
     * @return the number of key-values stored in the hash map
     */
    public int size() {
        return size;
    }
    
    /**
     * Creates the hash code for the passed key using built in hashCode method. 
     * hashCode is converted to positive int through calculating absolute method.
     * hashCode is then reduced by the modules of the data array size. 
     * 
     * @param key the key to calculate hash code.
     * @return the hash code for the passed key.
     */
    private int hashFunction(String key) {
        int hashCode = key.hashCode();

        hashCode = Math.abs(hashCode);
        hashCode = hashCode % data.length;
        return hashCode;

    }

    public Patient put(String key, Patient value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null");
        }

        int slot = hashFunction(key);

        if (data[slot] == null) {
            data[slot] = new LinkedList<>();
            Entry newEntry = new Entry(key, value);
            data[slot].add(newEntry);
            size++;
            return null;
        } else {

            for (Entry entry : data[slot]) {
                if (entry.key.equals(key)) {
                    Patient oldValue = entry.value;
                    entry.value = value;
                    return oldValue;
                }
            }
            Entry newEntry = new Entry(key, value);
            data[slot].add(newEntry);
            size++;
            return null;
        }
    }

    public Patient get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int slot = hashFunction(key);
        if (data[slot] != null) {
            for (Entry a : data[slot]) {
                if (a.key.equals(key)) {
                    return a.value;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public Patient remove(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int slot = hashFunction(key);
        if (data[slot] != null) {
            for (Entry entry : data[slot]) {
                if (entry.key.equals(key)) {
                    data[slot].remove(entry);
                    size--;
                    return entry.value;
                }
            }
        }
        return null;
    }

    public boolean containsKey(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int slot = hashFunction(key);
        if (data[slot] != null) {
            for (Entry entry : data[slot]) {
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String[] getKeys() {
        String[] keys = new String[size];
        int count = 0;

        for (LinkedList<Entry> entries : data) {
            if (entries != null) {
                for (Entry entry : entries) {
                    keys[count++] = entry.key;
                }
            }
        }
        return keys;
    }

    public Patient[] getValues() {
        Patient[] patientValues = new Patient[size];
        int count = 0;

        for (LinkedList<Entry> slot : data) {
            if (slot != null) {
                for (Entry entry : slot) {
                    patientValues[count] = entry.value;
                    count++;
                }
            }
        }
        return patientValues;
    }

    private static class Entry {

        private final String key;
        private Patient value;

        public Entry(String key, Patient value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Patient getValue() {
            return value;
        }

        public Patient updateValue(Patient newValue) {
            Patient oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }

}
