package com.lebaguette.ca2groupproject;

import java.util.Comparator;

public class PriorityQueue extends LinkedList {
    private Comparator<Appointment> comparator;

    /**
     * Constructs an empty PriorityQueue with no specified Comparator.
     * The natural ordering of Appointments will be used.
     */
    public PriorityQueue() {
        super();
        this.comparator = null;
    }

    /**
     * Constructs an empty PriorityQueue with the specified Comparator.
     * The Comparator will be used to determine the priority of Appointments.
     *
     * @param comparator the Comparator to determine the priority of Appointments
     */
    public PriorityQueue(Comparator<Appointment> comparator) {
        super();
        this.comparator = comparator;
    }

    /**
     * Sets the Comparator used to determine the priority of Appointments in the
     * PriorityQueue.
     *
     * @param comparator the Comparator to set
     */
    public void setComparator(Comparator<Appointment> comparator) {
        this.comparator = comparator;
    }

    /**
     * Adds the specified Appointment to the PriorityQueue based on its priority.
     * If the PriorityQueue is empty or no Comparator is set, the Appointment is
     * added at the end.
     * Otherwise, the Appointment is inserted at the appropriate position determined
     * by the Comparator.
     *
     * @param appointment the Appointment to add
     */
    @Override
    public void add(Appointment appointment) {
        if (isEmpty() || comparator == null) {
            super.add(appointment);
        } else {
            Node newNode = new Node(appointment);
            Node current = head;
            Node prev = null;

            while (current != null && comparator.compare(appointment, current.appointment) >= 0) {
                prev = current;
                current = current.next;
            }

            newNode.next = current;
            if (prev != null) {
                prev.next = newNode;
            } else {
                head = newNode;
            }

            size++;
        }
    }

    // Additional methods with fail-fast behavior

    /**
     * Removes the first occurrence of the specified Appointment from the
     * PriorityQueue.
     * This method is not supported in PriorityQueue and always throws an
     * UnsupportedOperationException.
     *
     * @param appointment the Appointment to remove
     * @return true if the Appointment was found and removed, false otherwise
     * @throws UnsupportedOperationException always thrown, as remove() is not
     *                                       supported in PriorityQueue
     */
    @Override
    public boolean remove(Appointment appointment) {
        throw new UnsupportedOperationException("remove() is not supported in PriorityQueue");
    }

    /**
     * Replaces the Appointment at the specified position in the PriorityQueue with
     * the specified Appointment.
     * This method is not supported in PriorityQueue and always throws an
     * UnsupportedOperationException.
     *
     * @param appointment the new Appointment to set
     * @param position    the position at which to set the new Appointment
     * @return the previous Appointment at the specified position
     * @throws UnsupportedOperationException always thrown, as set() is not
     *                                       supported in PriorityQueue
     */
    @Override
    public Appointment set(Appointment appointment, int position) {
        throw new UnsupportedOperationException("set() is not supported in PriorityQueue");
    }

    /**
     * Removes the first occurrence of the specified Appointment from the
     * PriorityQueue.
     *
     * This method provides safe behavior by returning a boolean value indicating
     * whether the Appointment was found and removed, without throwing an exception.
     *
     * @param appointment the Appointment to remove
     * @return true if the Appointment was found and removed, false otherwise
     */
    public boolean safeRemove(Appointment appointment) {
        if (remove(appointment)) {
            return true;
        }
        return false;
    }

    /**
     * Replaces the Appointment at the specified position in the PriorityQueue with
     * the specified Appointment.
     * This method provides safe behavior by performing bounds checking to ensure
     * the position is valid.
     *
     * @param appointment the new Appointment to set
     * @param position    the position at which to set the new Appointment
     * @return the previous Appointment at the specified position
     * @throws IndexOutOfBoundsException if the position is invalid (less than 0 or
     *                                   greater than or equal to size)
     */
    public Appointment safeSet(Appointment appointment, int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return set(appointment, position);
    }
}
