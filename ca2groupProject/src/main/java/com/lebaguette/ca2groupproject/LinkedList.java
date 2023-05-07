package com.lebaguette.ca2groupproject;

import java.util.Objects;

/**
 * A LinkedList implementation that holds Appointment objects.
 */
public class LinkedList {
    protected Node head;
    protected int size;

    protected class Node {
        protected Appointment appointment;
        protected Node next;

        public Node(Appointment appointment) {
            this.appointment = appointment;
            this.next = null;
        }
    }

    /**
     * Constructs an empty LinkedList.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns the number of Appointments in the LinkedList.
     *
     * @return the number of Appointments in the LinkedList
     */
    public int size() {
        return size;
    }

    /**
     * Retrieves the Appointment at the specified position in the LinkedList.
     *
     * @param position the position of the Appointment to retrieve
     * @return the Appointment at the specified position
     * @throws IndexOutOfBoundsException if the position is out of range
     */
    public Appointment get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current.appointment;
    }

    /**
     * Returns the position of the specified Appointment in the LinkedList.
     *
     * @param appointment the Appointment to search for
     * @return the position of the Appointment, or -1 if not found
     */
    public int indexOf(Appointment appointment) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (Objects.equals(current.appointment, appointment)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    /**
     * Adds the specified Appointment to the end of the LinkedList.
     *
     * @param appointment the Appointment to add
     */
    public void add(Appointment appointment) {
        Node newNode = new Node(appointment);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    /**
     * Replaces the Appointment at the specified position in the LinkedList with the
     * specified Appointment.
     *
     * @param appointment the new Appointment to set
     * @param position    the position at which to set the new Appointment
     * @return the previous Appointment at the specified position
     * @throws IndexOutOfBoundsException if the position is out of range
     */
    public Appointment set(Appointment appointment, int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        Appointment previousAppt = current.appointment;
        current.appointment = appointment;
        return previousAppt;
    }

    /**
     * Removes the first occurrence of the specified Appointment from the
     * LinkedList.
     *
     * @param appointment the Appointment to remove
     * @return true if the Appointment was found and removed, false otherwise
     */
    public boolean remove(Appointment appointment) {
        if (head == null) {
            return false;
        }

        if (Objects.equals(head.appointment, appointment)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.appointment, appointment)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Checks if the LinkedList is empty.
     *
     * @return true if the LinkedList is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
