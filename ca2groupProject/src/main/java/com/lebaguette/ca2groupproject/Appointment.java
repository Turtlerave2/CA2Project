package com.lebaguette.ca2groupproject;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Rob
 */

public class Appointment implements Comparable<Appointment> {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String issue;
    private LocalDate date;
    private int triageLevel;
    private String doctorFullName;

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getIssue() {
        return issue;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
