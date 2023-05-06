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

    public hashmap() {
        data = new LinkedList[INITIAL_CAPACITY];
    }

    public int size() {
        return size;
    }

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
            LinkedList<Entry> entries = data[slot];
            for (Entry entry : entries) {
                if (entry.key.equals(key)) {
                    Patient oldValue = entry.value;
                    entry.value = value;
                    return oldValue;
                }
            }
            Entry newEntry = new Entry(key, value);
            entries.add(newEntry);
            size++;
            return null;
        }
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
