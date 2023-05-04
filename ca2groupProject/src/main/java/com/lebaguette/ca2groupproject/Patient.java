/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.lebaguette.ca2groupproject;

import java.time.LocalDate;
import java.util.LinkedList;
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
  
  
}
