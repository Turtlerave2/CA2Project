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
  private LinkedList<Appointment> appointments;

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateJoined) {
        if(dateOfBirth.compareTo(LocalDate.now()) >=0 || dateJoined.compareTo(LocalDate.now())>=0){
        throw new IllegalArgumentException("dates cannot be after todays date.");
        }
        this.dateOfBirth = dateOfBirth;
        this.dateJoined = dateJoined;
        this.firstName = firstName;
        this.lastName = lastName;
        this.appointments = new LinkedList<>();
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

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public LinkedList<Appointment> getAppointments() {
        return appointments;
    }  

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateofBirth) {
        if(dateofBirth.compareTo(LocalDate.now() )>=0){
        throw new IllegalArgumentException("Birth cant be after todays date.");
        }
        this.dateOfBirth = dateofBirth;
    }

    public void setDateJoined(LocalDate dateJoined) {
        
        if(dateJoined.compareTo(LocalDate.now())>=0){
        throw new IllegalArgumentException("Joined date cant be after todays date.");
        }
        this.dateJoined = dateJoined;
    }
  
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        hash = 89 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Patient{" + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", dateJoined=" + dateJoined + ", appointments=" + appointments + '}';
    }
  
    
  
}
