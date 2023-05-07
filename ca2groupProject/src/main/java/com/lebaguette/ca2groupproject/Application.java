/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lebaguette.ca2groupproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author leoze
 */
public class Application {

    public static void main(String[] args) throws IOException {
        MenuOptions menu = new MenuOptions();


        hashmap practice = new hashmap();
        Scanner kb = new Scanner(System.in);

        int choice = -1;
        
        do {
            menu.menu();
            try {
                choice = kb.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter patient details:");
                        System.out.print("First Name: ");
                        String firstName = kb.next();
                        System.out.print("Last Name: ");
                        String lastName = kb.next();
                        System.out.print("Date of Birth (dd-mm-yyyy): ");
                        String dobStr = kb.next();
                        LocalDate dateOfBirth = LocalDate.parse(dobStr);
                        LocalDate dateJoined = LocalDate.now();

                        // Check if the patient already exists in the practice
                        if (practice.containsKey(dateOfBirth.hashCode())) {
                            System.out.println("A patient with the same details already exists.");
                        } else {
                            Patient newPatient = new Patient(firstName, lastName, dateOfBirth, dateJoined);
                            practice.put(dateOfBirth.hashCode(), newPatient);
                            System.out.println("Patient added successfully.");
                        }

                        break;
                    case 2:
                        System.out.print("Enter the patient's date of birth (yyyy-mm-dd): ");
                        String dobToDelete = kb.next();
                        LocalDate dateOfBirthToDelete = LocalDate.parse(dobToDelete);

                        // Check if the patient exists in the practice
                        if (practice.containsKey(dateOfBirthToDelete.hashCode())) {
                            // Retrieve the patient from the hashmap
                            Patient patientToDelete = practice.get(dateOfBirthToDelete.hashCode());

                            // Remove the patient from the practice
                            practice.remove(dateOfBirthToDelete.hashCode());

                            // Remove any outstanding appointments for the patient
                            patientToDelete.clearAppointments();

                            System.out.println("Patient deleted successfully.");
                        } else {
                            System.out.println("Patient not found.");
                        }
                        break;
                    case 3:
                        Patient[] patients = practice.getValues();

                        for (Patient patient : patients) {
                            System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
                            System.out.println("Date of birth: " + patient.getDateOfBirth());
                            System.out.println("Date joined: " + patient.getDateJoined());
                            System.out.println();
                        }
                        break;
                    case 4:
                        System.out.print("Enter the patient's date of birth (yyyy-mm-dd): ");
                        String dobToAddAppointment = kb.next();
                        LocalDate dateOfBirthToAddAppointment = LocalDate.parse(dobToAddAppointment);

                        // Check if the patient exists in the practice
                        if (practice.containsKey(dateOfBirthToAddAppointment.hashCode())) {
                            // Retrieve the patient from the hashmap
                            Patient patientToAddAppointment = practice.get(dateOfBirthToAddAppointment.hashCode());

                            // Generate a random triage level between 1 and 5
                            int triageLevel = (int) (Math.random() * 5) + 1;

                            // Prompt the user to enter appointment details
                            System.out.print("Enter the issue: ");
                            String issue = kb.next();
                            System.out.print("Enter the appointment date (yyyy-mm-dd): ");
                            String appointmentDate = kb.next();
                            LocalDate date = LocalDate.parse(appointmentDate);
                            System.out.print("Enter the doctor's full name: ");
                            String doctorFullName = kb.next();

                            // Create a new appointment
                            Appointment newAppointment = new Appointment(patientToAddAppointment.getFirstName(),
                                    patientToAddAppointment.getLastName(), patientToAddAppointment.getDateOfBirth(),
                                    issue, date, triageLevel, doctorFullName);

                            // Add the appointment to the patient's queue
                            patientToAddAppointment.addAppointment(newAppointment);

                            System.out.println("New appointment created and added to the queue:");
                            System.out.println(newAppointment);
                        } else {
                            System.out.println("Patient not found.");
                        }
                        break;

                    case 5:
                        PriorityQueue que = new PriorityQueue();
                        if (que.isEmpty()) {
                            System.out.println("No patients waiting in queue");
                        } else {
                            LinkedList.Node next = que.head;
                            System.out.println("Next patient:");
                            System.out.println("name: " + next.appointment.getFirstName() + " " + next.appointment.getLastName());
                            System.out.println("Date of Birth: " + next.appointment.getDateOfBirth());
                            System.out.println("Date Joined: " + next.appointment.getDate());
                            System.out.println("Issue: " + next.appointment.getIssue());
                            System.out.println("With Doctor " + next.appointment.getDoctorFullName());
                            System.out.println();

                        }

                        break;
                    case 6:
                        try {
                        File input = new File("patients.txt");
                        Scanner KB = new Scanner(input);
                        int slotcount=1;
                        while (KB.hasNextLine()) {
                            String line = KB.nextLine();
                            String[] values = line.split(",");
                            String FirstName = values[0];
                            String LastName = values[1];
                            LocalDate dob = LocalDate.parse(values[2]);
                            LocalDate joinedDate = LocalDate.parse(values[4]);
                            Patient patient = new Patient(FirstName, LastName, dob, joinedDate);

                            for (int i = 3; i < values.length; i += 4) {
                                String issue = values[i];
                                LocalDate date = LocalDate.parse(values[i + 1]);
                                int triageLevel = Integer.parseInt(values[i + 2]);
                                String doctorName = values[i + 3];

                                Appointment ap = new Appointment(FirstName, LastName, dob, issue, date, triageLevel,
                                        doctorName);
                                patient.addAppointment(ap);
                            }
                            practice.put(slotcount++, patient);
                        }
                        KB.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File was not found");
                    }

                    try {
                        File input = new File("output.txt");
                        PrintWriter filewrite = new PrintWriter(input);
                        Patient[] patarray = practice.getValues();

                        for (Patient patient : patarray) {
                            filewrite.print(patient.getFirstName());
                            filewrite.print("," + patient.getLastName());
                            filewrite.print("," + patient.getDateOfBirth());
                            filewrite.print("," + patient.getDateJoined());

                            LinkedList appointments = patient.getAppointments();
                            if (!appointments.isEmpty()) {
                                for (int i = 0; i < appointments.size(); i++) {
                                    filewrite.print(appointments.get(i).getIssue());
                                    filewrite.print(" , " + appointments.get(i).getDate());
                                    filewrite.print(" , " + appointments.get(i).getTriageLevel());
                                    filewrite.print(" , " + appointments.get(i).getDoctorFullName());
                                }
                            }
                            filewrite.println();
                        }
                        filewrite.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    }

                    System.out.println("Exiting System");
                    return;

                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a number for one of the options");
                kb.next();

            }

        } while (choice != 6);
    }
}
