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

    //the initial capapcity of the hashmap
    private static final int INITIAL_CAPACITY = 50;
    //the array linkedlist used to store the key-value pairs
    private LinkedList<Entry>[] data;
    //the number of pairs stored in the hashmap
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
     * hashCode is converted to positive int through calculating absolute
     * method. hashCode is then reduced by the modules of the data array size.
     *
     * @param key the key to calculate hash code slot.
     * @return the hash code for the passed key.
     */
    private int hashFunction(int key) {
       
        int hashCode = Integer.hashCode(key);
        hashCode = Math.abs(hashCode);
        hashCode = hashCode % data.length;
        return hashCode;

    }

    /**
     * Method to put the value for the associating key. If the map already
     * contains the key the old value is replaced by the new value. Returns the
     * old value if updated. If the slot was empty then no old value is returned
     * only null.
     *
     * @param key the key to calculate hash code slot.
     * @param value to be linked with the key.
     * @return the old value in the slot or null if the slot was null
     * @throws IllegalArgumentException if either key or value parameter's are
     * null
     *
     */
    public Patient put(int key, Patient value) {
        if (key == 0 || value == null) {
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
                if (entry.getKey() == key) {
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

    /**
     * Returns the value to which the key is mapped to, will return null if map
     * doesn't contain it.
     *
     * @param key the key linked to the value to be returned.
     * @return the value to where the key is mapped, or null if doesn't contain
     * it.
     * @throws IllegalArgumentException if key parameter is null
     */
    public Patient get(int key) {
        if (key == 0) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int slot = hashFunction(key);
        if (data[slot] != null) {
            for (Entry a : data[slot]) {
                if (a.getKey() == key) {
                    return a.value;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * removes the patient suing the parameter key from the map and returns
     * their value. If the key is not in the map it returns null.
     *
     * @param key the key for the patient to remove from the map
     * @return the value of the patient to be removed, or returns null if key
     * wasn't found.
     * @throws IllegalArgumentException if key parameter is null
     */
    public Patient remove(int key) {
        if (key == 0) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int slot = hashFunction(key);
        if (data[slot] != null) {
            for (Entry entry : data[slot]) {
                if (entry.getKey() == key) {
                    data[slot].remove(entry);
                    size--;
                    return entry.value;
                }
            }
        }
        return null;
    }

    /**
     * Searches through the map to see if the passed key is in the map. will
     * return true if found otherwise false.
     *
     * @param key the key to search for in the map.
     * @return true if the key is found in the map, false otherwise.
     * @throws IllegalArgumentException if key parameter is null
     */
    public boolean containsKey(int key) {
        if (key == 0) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int slot = hashFunction(key);
        if (data[slot] != null) {
            for (Entry entry : data[slot]) {
                if (entry.getKey() == key) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * returns an array of all the keys in the map.
     *
     * @return an array of all keys in the map.
     */
    public int[] getKeys() {
        int[] keys = new int[size];
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

    /**
     * returns an Patient array of all the values in the map.
     *
     * @return an array of all values in the map.
     */
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

    /**
     * class entry represents an entry in hash table, based on key-value pair.
     * the key is string and the value is patient object.
     *
     */
    private static class Entry {

        //key associated with the entry
        private final int key;
        //value associated with the entry
        private Patient value;

        /**
         * Constructs a new entry with the key and value parameters passed.
         *
         * @param key the key for the entry.
         * @param value the value for the entry.
         */
        public Entry(int key, Patient value) {
            this.key = key;
            this.value = value;
        }

        /**
         * returns the key linked with the entry.
         *
         * @return the key linked with the entry.
         */
        public int getKey() {
            return key;
        }

        /**
         * returns the value linked with the entry.
         *
         * @return the value linked with the entry.
         */
        public Patient getValue() {
            return value;
        }

        /**
         * Updates the value linked to the entry to the given value. Returns the
         * old value.
         *
         * @param newValue the new value to link with the entry
         * @return the old value linked with the entry.
         */
        public Patient updateValue(Patient newValue) {
            Patient oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }

}
