/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;

/**
 *
 * @author bjmaclean
 */
public class StudentMain {

    /**
     * @param args the command line arguments
     */
    private static Path path = Paths.get("c:\\cis2232\\student.txt");
    private static HashMap<String, Student> students = new HashMap();

    public static void main(String[] args) {
//test
        String option;
        Scanner input = new Scanner(System.in);

        String menu = "Please select from option below"
                + "\nA)Add a student"
                + "\nB)View all students"
                + "\nC)Edit a student"
                + "\nD)Load from file"
                + "\nX)Exit";

        System.out.println(menu);
        option = input.nextLine().toUpperCase();
        OutputStream output;
        BufferedWriter writer = null;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(path, CREATE, APPEND));
            writer = new BufferedWriter(new OutputStreamWriter(output));

            while (!option.equalsIgnoreCase("x")) {
                switch (option) {
                    case "A":
                        Student student = new Student();
                        students.put(student.getStudentId(), student);
                        fileWrite(writer, student.fileOutputString());
                        break;
                    case "B":
                        for (String variableName : students.keySet()) {
                            System.out.println(students.get(variableName) + "\n");
                        }
                        break;
                    case "C":
                        System.out.println("Future functionality");
                        break;
                    case "D":
                        System.out.println("Loading information from a file.");
                        loadFile();
                        break;

                    default:
                        System.err.println("Invalid option");
                }

                System.out.println(menu);
                option = input.nextLine().toUpperCase();

            }
        } catch (IOException ex) {
            System.err.println("There was an IO error");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                System.out.println("IO exception caught.(closing)");
            }
        }

    }

    public static void loadFile() {
        //debug statement.
        if (Util.debugOn) {
            System.out.println("About to load the file.");
        }
        InputStream input;
        System.out.println("About to load the file.");
        BufferedReader reader = null;
        try {
            input = new BufferedInputStream(Files.newInputStream(path));
            reader = new BufferedReader(new InputStreamReader(input));

            String nextLine = reader.readLine();
            while (nextLine != null) {
                //Read the information and load the hashmap.
                Student newStudent = new Student(nextLine);

                //next will be to add the new student to the hashmap.
                students.put(newStudent.getStudentId(), newStudent);
                nextLine = reader.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("There was an error reading the file.");
        }

    }

    public static void fileWrite(BufferedWriter writer, String toWrite) throws IOException {
        writer.write(toWrite);
        writer.newLine();
        writer.flush();

    }

}
