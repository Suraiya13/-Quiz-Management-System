package quiz.service;

import com.google.gson.reflect.TypeToken;
import quiz.model.Question;
import quiz.util.FileUtil;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    private static final String QUIZ_FILE = "quiz.json";

    public AdminService() {
        FileUtil.createFileIfNotExists(QUIZ_FILE);
    }

    public void addQuestions(Scanner scanner) {
        while (true) {
            Question question = new Question();

            System.out.print("System:> Input your question\nAdmin:> ");
            question.setQuestion(scanner.nextLine().trim());

            System.out.print("System:> Input option 1:\nAdmin:> ");
            question.setOption1(scanner.nextLine().trim());

            System.out.print("System:> Input option 2:\nAdmin:> ");
            question.setOption2(scanner.nextLine().trim());

            System.out.print("System:> Input option 3:\nAdmin:> ");
            question.setOption3(scanner.nextLine().trim());

            System.out.print("System:> Input option 4:\nAdmin:> ");
            question.setOption4(scanner.nextLine().trim());

            int answerKey = 0;
            while (answerKey < 1 || answerKey > 4) {
                System.out.print("System:> What is the answer key?\nAdmin:> ");
                try {
                    answerKey = Integer.parseInt(scanner.nextLine().trim());
                    if (answerKey < 1 || answerKey > 4) {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            }
            question.setAnswerKey(answerKey);

            saveQuestion(question);
            System.out.println("System:> Saved successfully!");

            System.out.print("System:> Do you want to add more questions? (press 's' to start, 'q' to quit)\nAdmin:> ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("q")) {
                break;
            }
        }
    }

    private void saveQuestion(Question question) {
        Type questionListType = new TypeToken<List<Question>>(){}.getType();
        List<Question> questions = FileUtil.readJsonFile(QUIZ_FILE, questionListType);
        questions.add(question);
        FileUtil.writeJsonFile(QUIZ_FILE, questions);
    }
}