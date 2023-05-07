package com.lebaguette.ca2groupproject;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Rob
 */

/**
 * Represents an appointment with the specified information.
 * Appointments are made up of the patient's details, issue, date, triage level,
 * and doctor's full name.
 * Two appointments are considered equal if they have the same patient data,
 * issue, and date.
 * The natural order for appointments is based on the triage level, where 1 has
 * a higher priority than 5.
 */
public class Appointment implements Comparable<Appointment> {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String issue;
    private LocalDate date;
    private int triageLevel;
    private String doctorFullName;

    /**
     * Constructs an Appointment object with the specified information.
     *
     * @param firstName      the patient's first name
     * @param lastName       the patient's last name
     * @param dateOfBirth    the patient's date of birth
     * @param issue          the issue for the appointment
     * @param date           the date of the appointment
     * @param triageLevel    the triage level of the appointment
     * @param doctorFullName the full name of the doctor
     */
    public Appointment(String firstName, String lastName, LocalDate dateOfBirth, String issue, LocalDate date,
            int triageLevel, String doctorFullName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.issue = issue;
        this.date = date;
        this.triageLevel = triageLevel;
        this.doctorFullName = doctorFullName;
    }

    /**
     * Sets the first name of the patient.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the patient.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the date of birth of the patient.
     *
     * @param dateOfBirth the date of birth to set
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets the issue description of the patient.
     *
     * @param issue the issue description to set
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * Sets the date of the appointment.
     *
     * @param date the date of the appointment to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Sets the triage level of the appointment.
     *
     * @param triageLevel the triage level to set
     */
    public void setTriageLevel(int triageLevel) {
        this.triageLevel = triageLevel;
    }

    /**
     * Sets the full name of the doctor for the appointment.
     *
     * @param doctorFullName the full name of the doctor to set
     */
    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    /**
     * Returns the patient's first name.
     *
     * @return the patient's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the patient's last name.
     *
     * @return the patient's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the patient's date of birth.
     *
     * @return the patient's date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Returns the issue for the appointment.
     *
     * @return the issue for the appointment
     */
    public String getIssue() {
        return issue;
    }

    /**
     * Returns the date of the appointment.
     *
     * @return the date of the appointment
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns the triage level of the appointment.
     *
     * @return the triage level of the appointment
     */
    public int getTriageLevel() {
        return triageLevel;
    }

    /**
     * Returns the full name of the doctor.
     *
     * @return the full name of the doctor
     */
    public String getDoctorFullName() {
        return doctorFullName;
    }

    /**
     * Checks if this appointment is equal to another object.
     * Two appointments are considered equal if they have the same patient data,
     * issue, and date.
     *
     * @param o the object to compare with
     * @return true if the appointments are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Appointment comp = (Appointment) o;
        return Objects.equals(firstName, comp.firstName) &&
                Objects.equals(lastName, comp.lastName) &&
                Objects.equals(dateOfBirth, comp.dateOfBirth) &&
                Objects.equals(issue, comp.issue) &&
                Objects.equals(date, comp.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, issue, date);
    }

    @Override
    public int compareTo(Appointment other) {
        return Integer.compare(triageLevel, other.triageLevel);
    }

}
