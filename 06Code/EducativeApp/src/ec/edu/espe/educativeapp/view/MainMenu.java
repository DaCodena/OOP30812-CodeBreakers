package ec.edu.espe.educativeapp.view;

import ec.edu.espe.educativeapp.controller.StudentController;
import java.util.Scanner;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class MainMenu {

    public void start() {

        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();

        int option;

        do {
            System.out.println("===== EDUCATIVE APP =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Average: ");
                    int average = scanner.nextInt();
                    scanner.nextLine();

                    studentController.createStudent(id, name, average);
                    break;

                case 2:
                    studentController.showStudents();
                    break;
            }

        } while(option != 3);
    }
}