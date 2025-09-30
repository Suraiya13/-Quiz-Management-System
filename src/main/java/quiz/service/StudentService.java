package quiz.service;

import com.google.gson.reflect.TypeToken;
import quiz.model.Question;
import quiz.util.FileUtil;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StudentService {
    private static final String QUIZ_FILE = "quiz.json";
    private static final int TOTAL_QUESTIONS = 10;

    public void startQuiz(Scanner scanner) {
        Type questionListType = new TypeToken<List<Question>>(){}.getType();
        List<Question> allQuestions = FileUtil.readJsonFile(QUIZ_FILE, questionListType);

        if (allQuestions.isEmpty()) {
            System.out.println("No questions available in the question bank. Please contact admin.");
            return;
        }

        int score = 0;
        Random random = new Random();

        for (int i = 1; i <= TOTAL_QUESTIONS; i++) {
            Question question = allQuestions.get(random.nextInt(allQuestions.size()));

            System.out.println("\nSystem:> [Question " + i + "] " + question.getQuestion());
            System.out.println("1. " + question.getOption1());
            System.out.println("2. " + question.getOption2());
            System.out.println("3. " + question.getOption3());
            System.out.println("4. " + question.getOption4());

            int answer = 0;
            while (answer < 1 || answer > 4) {
                System.out.print("Student:> ");
                try {
                    answer = Integer.parseInt(scanner.nextLine().trim());
                    if (answer < 1 || answer > 4) {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            }

            if (answer == question.getAnswerKey()) {
                score++;
            }
        }

        displayResult(score);
    }

    private void displayResult(int score) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Quiz Completed!");
        System.out.println("=".repeat(50));

        if (score >= 8 && score <= 10) {
            System.out.println("Excellent! You have got " + score + " out of " + TOTAL_QUESTIONS);
        } else if (score >= 5 && score <= 7) {
            System.out.println("Good. You have got " + score + " out of " + TOTAL_QUESTIONS);
        } else if (score >= 3 && score <= 4) {
            System.out.println("Very poor! You have got " + score + " out of " + TOTAL_QUESTIONS);
        } else {
            System.out.println("Very sorry you are failed. You have got " + score + " out of " + TOTAL_QUESTIONS);
        }

        System.out.println("=".repeat(50));
    }
}