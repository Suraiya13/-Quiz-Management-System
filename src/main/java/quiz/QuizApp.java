package quiz;


import quiz.model.User;
import quiz.service.AdminService;
import quiz.service.AuthService;
import quiz.service.StudentService;

import java.util.Scanner;

public class QuizApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AuthService authService = new AuthService();
    private static final AdminService adminService = new AdminService();
    private static final StudentService studentService = new StudentService();

    public static void main(String[] args) {
        System.out.println("Welcome to Quiz Management System");

        while (true) {
            User user = login();

            if (user == null) {
                System.out.println("Invalid credentials. Please try again.");
                continue;
            }

            if (user.getRole().equals("admin")) {
                handleAdminSession(user);
            } else if (user.getRole().equals("student")) {
                handleStudentSession(user);
            }

            System.out.println("\nThank you for using Quiz Management System!");
            System.out.print("Do you want to login again? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("y")) {
                break;
            }
        }

        scanner.close();
    }

    private static User login() {
        System.out.print("System:> Enter your username\nUser:> ");
        String username = scanner.nextLine().trim();

        System.out.print("System:> Enter password\nUser:> ");
        String password = scanner.nextLine().trim();

        return authService.authenticate(username, password);
    }

    private static void handleAdminSession(User user) {
        System.out.println("System:> Welcome " + user.getUsername() + "! Please create new questions in the question bank.");
        adminService.addQuestions(scanner);
    }

    private static void handleStudentSession(User user) {
        System.out.println("System:> Welcome " + user.getUsername() + " to the quiz! We will throw you 10 questions.");
        System.out.println("Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");

        while (true) {
            System.out.print("Student:> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("s")) {
                studentService.startQuiz(scanner);

                System.out.print("\nSystem:> Would you like to start again? Press 's' for start or 'q' for quit\nStudent:> ");
                String choice = scanner.nextLine().trim().toLowerCase();
                if (choice.equals("q")) {
                    break;
                }
            } else if (input.equals("q")) {
                break;
            } else {
                System.out.println("Invalid input. Press 's' to start or 'q' to quit.");
            }
        }
    }
}
