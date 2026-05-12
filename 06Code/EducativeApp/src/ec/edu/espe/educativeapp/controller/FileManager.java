package ec.edu.espe.educativeapp.controller;

import ec.edu.espe.educativeapp.model.Student;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileManager {

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
    
    
    public ArrayList<Student> loadStudentsJSON(String fileName) {

    ArrayList<Student> students = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

        String line;

        int id = 0;
        String name = "";
        double average = 0;

        while ((line = reader.readLine()) != null) {

            line = line.trim();

            if (line.startsWith("\"id\"")) {

                String value = line.split(":")[1]
                                   .replace(",", "")
                                   .trim();

                id = Integer.parseInt(value);
            }

            if (line.startsWith("\"name\"")) {

                String value = line.split(":")[1]
                                   .replace(",", "")
                                   .replace("\"", "")
                                   .trim();

                name = value;
            }

            if (line.startsWith("\"average\"")) {

                String value = line.split(":")[1]
                                   .trim();

                average = Double.parseDouble(value);

                Student student = new Student(id, name, average);

                students.add(student);
            }
        }

        System.out.println("Students loaded from JSON successfully.");

    } catch (IOException e) {

        System.out.println("Error loading JSON file.");
    }

    return students;
}
}