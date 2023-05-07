/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.lebaguette.ca2groupproject;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author leoze
 */
public class Patient {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateJoined;
    private LinkedList appointments;

    /**
     * Constructs a new Patient with the passed arguments.
     *
     * @param firstName the first name of the patient
     * @param lastName the last name of the patient
     * @param dateOfBirth the date of birth of the patient
     * @param dateJoined the date when the patient joined the healthcare system
     * @throws IllegalArgumentException if the date of birth or date joined is
     * after the current date
     */
    public Patient(String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateJoined) {
        if (dateOfBirth.compareTo(LocalDate.now()) >= 0 || dateJoined.compareTo(LocalDate.now()) >= 0) {
            throw new IllegalArgumentException("dates cannot be after todays date.");
        }
        this.dateOfBirth = dateOfBirth;
        this.dateJoined = dateJoined;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name of the patient.
     *
     * @return the first name of the patient
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the patient.
     *
     * @return the last name of the patient
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the date of birth of the patient.
     *
     * @return the date of birth of the patient
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Returns the date when the patient joined.
     *
     * @return the date when the patient joined.
     */
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    /**
     * Returns the list of appointments for the patient.
     *
     * @return the list of appointments for the patient
     */
    public LinkedList getAppointments() {
        return appointments;
    }

    /**
     * Sets the first name of the patient.
     *
     * @param firstName the first name of the patient
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the patient.
     *
     * @param lastName the last name of the patient
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the date of birth of the patient.
     *
     * @param dateofBirth the date of birth for the patient
     * @throws IllegalArgumentException if the date of birth is after the
     * current date
     */
    public void setDateOfBirth(LocalDate dateofBirth) {
        if (dateofBirth.compareTo(LocalDate.now()) >= 0) {
            throw new IllegalArgumentException("Birth cant be after todays date.");
        }
        this.dateOfBirth = dateofBirth;
    }

    /**
     * Sets the date when the patient joined the healthcare system.
     *
     * @param dateJoined the date when the patient joined the healthcare system
     * @throws IllegalArgumentException if the date joined is after the current
     * date
     */
    public void setDateJoined(LocalDate dateJoined) {

        if (dateJoined.compareTo(LocalDate.now()) >= 0) {
            throw new IllegalArgumentException("Joined date cant be after todays date.");
        }
        this.dateJoined = dateJoined;
    }

    /**
     * Adds a new appointment for the patient
     *
     * @param ap the appointment to add
     */
    public void addAppointment(Appointment ap) {
        if (appointments == null) {
            appointments = new LinkedList();
        }
        appointments.add(ap);
    }

    /**
     * Returns a hash code value for this Patient object.
     *
     * @return the hash code value for this Patient object.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        hash = 89 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }

    /**
     * Indicates whether some other object is "equal to" this one. Patients are
     * considered equal if they have the same first name, surname and date of
     * birth fields.
     *
     * @param obj the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.dateOfBirth, other.dateOfBirth);
    }

    /**
     * Returns a string representation of Patient including all variables.
     *
     * @return a string representation of this Patient.
     */
    @Override
    public String toString() {
        return "Patient{" + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", dateJoined=" + dateJoined + ", appointments=" + appointments + '}';
    }

}
