


 package za.ac.tut.b1;

import za.ac.tut.entity.StudentEntity;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

import za.ac.tut.b1.StudentDB;

import java.util.Scanner;

import java.util.Scanner;

public class DAOApp {

    public static void main(String[] args) {
   
        String dbURL = "jdbc:derby://localhost:1527/StudentDB"; 
        String username = "app"; 
        String password = "123"; 

        try (Scanner sc = new Scanner(System.in)) {
            StudentDB studentDB = new StudentDB(dbURL, username, password);

            int choice;
            do {
                System.out.println("\n--- Student Database Menu ---");
                System.out.println("1. Add student");
                System.out.println("2. View all students");
                System.out.println("3. Find student by ID");
                System.out.println("4. Update student");
                System.out.println("5. Delete student");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter student number: ");
                        int num = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter surname: ");
                        String surname = sc.nextLine();
                        studentDB.add(new StudentEntity(num, name, surname));
                        System.out.println("Student added.");
                        break;

                    case 2:
                        List<StudentEntity> students = studentDB.getAll();
                        System.out.println("\nAll students:");
                        for (StudentEntity s : students) {
                            System.out.println(s);
                        }
                        break;

                    case 3:
                        System.out.print("Enter student number: ");
                        int id = sc.nextInt();
                        StudentEntity student = studentDB.get(id);
                        if (student != null) {
                            System.out.println("Found: " + student);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter student number to update: ");
                        int updId = sc.nextInt();
                        sc.nextLine();
                        StudentEntity updStudent = studentDB.get(updId);
                        if (updStudent != null) {
                            System.out.print("Enter new name: ");
                            updStudent.setName(sc.nextLine());
                            System.out.print("Enter new surname: ");
                            updStudent.setSurname(sc.nextLine());
                            studentDB.update(updStudent);
                            System.out.println("Student updated.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter student number to delete: ");
                        int delId = sc.nextInt();
                        studentDB.delete(new StudentEntity(delId, null, null));
                        System.out.println("Student deleted (if existed).");
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 0);

        } catch (SQLException ex) {
            System.err.println("Database error: " + ex.getMessage());
        }
    }
}

    
    

