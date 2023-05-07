/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lebaguette.ca2groupproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

        //hashmap object?
        hashmap practice = new hashmap();
        Scanner kb = new Scanner(System.in);

        int choice = -1;
        //case 6 will be the reading patient file
        //and writing to a file the data
        //and then the program will end, so 
        //the writing will be done before program closes
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
                        //delete patient
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
                        //create new appointment for patient
                        break;
                    case 5:
                        //call next patient in
                        break;
                    case 6:
                   try {
                        File input = new File("patients.txt");
                        Scanner KB = new Scanner(input);
                        int count = 1;
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

                                Appointment ap = new Appointment(FirstName, LastName, dob, issue, date, triageLevel, doctorName);
                                patient.addAppointment(ap);
                            }
                            practice.put(count++, patient);
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

                            for (int i = 0; i < appointments.size(); i++) {
                                filewrite.print(" , " + appointments.get(i).getIssue());
                                filewrite.print(" , " + appointments.get(i).getDate());
                                filewrite.print(" , " + appointments.get(i).getTriageLevel());
                                filewrite.print(" , " + appointments.get(i).getDoctorFullName());
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
