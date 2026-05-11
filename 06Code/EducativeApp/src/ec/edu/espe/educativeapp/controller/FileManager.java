package ec.edu.espe.educativeapp.controller;

import ec.edu.espe.educativeapp.model.Student;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class FileManager {

    // =========================
    // SAVE STUDENTS TO CSV
    // =========================
    public void saveStudentsCSV(ArrayList<Student> students, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Student student : students) {

                writer.write(
                    student.getId() + "," +
                    student.getName() + "," +
                    student.getAverage()
                );

                writer.newLine();
            }

            System.out.println("Students saved in CSV successfully.");

        } catch (IOException e) {

            System.out.println("Error saving CSV file.");
        }
    }

    // =========================
    // LOAD STUDENTS FROM CSV
    // =========================
    public ArrayList<Student> loadStudentsCSV(String fileName) {

        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double average = Double.parseDouble(data[2]);

                Student student = new Student(id, name, 0);
                student.setAverage(average);

                students.add(student);
            }

            System.out.println("Students loaded from CSV.");

        } catch (IOException e) {

            System.out.println("Error loading CSV file.");
        }

        return students;
    }

    // =========================
    // SAVE STUDENTS TO JSON
    // =========================
    public void saveStudentsJSON(ArrayList<Student> students, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("[\n");

            for (int i = 0; i < students.size(); i++) {

                Student student = students.get(i);

                writer.write("  {\n");
                writer.write("    \"id\": " + student.getId() + ",\n");
                writer.write("    \"name\": \"" + student.getName() + "\",\n");
                writer.write("    \"average\": " + student.getAverage() + "\n");
                writer.write("  }");

                if (i < students.size() - 1) {
                    writer.write(",");
                }

                writer.newLine();
            }

            writer.write("]");

            System.out.println("Students saved in JSON successfully.");

        } catch (IOException e) {

            System.out.println("Error saving JSON file.");
        }
    }
}