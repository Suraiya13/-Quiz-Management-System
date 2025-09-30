# Quiz Management System

A role-based quiz management system built with Java and Gradle that allows admin users to manage questions and student users to take quizzes.

## Features

### Admin Features
- Add multiple-choice questions (MCQs) to the question bank
- Each question has 4 options with one correct answer
- Questions are stored persistently in JSON format
- Continuous question addition until quit

### Student Features
- Take quizzes with 10 randomly selected questions
- Each correct answer earns 1 mark
- No negative marking
- Performance-based feedback
- Option to retake quiz

## Prerequisites

- Java 11 or higher
- Gradle 7.0 or higher (or use Gradle Wrapper)

## Installation & Setup

### 1. Create the project structure

Create the following directory structure:

mkdir -p quiz-management-system/src/main/java/com/quiz/{model,service,util}
cd quiz-management-system

### 2. Add all source files

Copy all the Java files into their respective directories:
- QuizApp.java → src/main/java/com/quiz/
- User.java & Question.java → src/main/java/com/quiz/model/
- AuthService.java, AdminService.java, StudentService.java → src/main/java/com/quiz/service/
- FileUtil.java → src/main/java/com/quiz/util/

### 3. Add Gradle files

Copy build.gradle and settings.gradle to the root directory.

### 4. Initialize JSON files

Create users.json in the root directory:

[
  {
    "username": "admin",
    "password": "1234",
    "role": "admin"
  },
  {
    "username": "salman",
    "password": "1234",
    "role": "student"
  }
]

Create quiz.json with the 20 sample SQA questions provided.

## Running the Application

### Using Gradle

# Build the project
./gradlew build

# Run the application
./gradlew run

# Create executable JAR
./gradlew jar

# Run the JAR
java -jar build/libs/quiz-management-system-1.0.0.jar

### Using Gradle Wrapper (if Gradle not installed)

# On Linux/Mac
./gradlew run

# On Windows
gradlew.bat run

## Usage

### Login Credentials

*Admin:*
- Username: admin
- Password: 1234

*Student:*
- Username: salman
- Password: 1234

### Admin Workflow

1. Login with admin credentials
2. Add questions following the prompts
3. Enter question text and 4 options
4. Specify the correct answer (1-4)
5. Choose to add more questions or quit

### Student Workflow

1. Login with student credentials
2. Press 's' to start the quiz
3. Answer 10 randomly selected questions
4. View your score and performance feedback
5. Choose to retake or quit

## Scoring System

| Score Range | Feedback |
|-------------|----------|
| 8-10 | Excellent! You have got [marks] out of 10 |
| 5-7 | Good. You have got [marks] out of 10 |
| 3-4 | Very poor! You have got [marks] out of 10 |
| 0-2 | Very sorry you are failed. You have got [marks] out of 10 |

## Sample Questions

The system comes pre-loaded with 20 Software Quality Assurance (SQA) questions covering topics such as:
- Testing types and techniques
- SDLC and test processes
- Testing principles
- Test coverage and metrics
- Defect management

## File Descriptions

### users.json
Stores user credentials and roles. Format:
{
  "username": "string",
  "password": "string",
  "role": "admin|student"
}

### quiz.json
Stores all MCQ questions. Format:
{
  "question": "string",
  "option 1": "string",
  "option 2": "string",
  "option 3": "string",
  "option 4": "string",
  "answerkey": 1-4
}

## Dependencies

- *Gson 2.10.1*: JSON parsing and serialization
- *JUnit Jupiter 5.9.3*: Unit testing framework

## Architecture

### Model Layer
- User: Represents system users with username, password, and role
- Question: Represents quiz questions with options and answer key

### Service Layer
- AuthService: Handles user authentication
- AdminService: Manages question creation and storage
- StudentService: Handles quiz logic and scoring

### Utility Layer
- FileUtil: Provides JSON file read/write operations using Gson

## Key Features

1. *Persistent Storage*: All data stored in JSON files
2. *Role-Based Access*: Different features for admin and student
3. *Random Question Selection*: Each quiz randomly picks 10 questions
4. *Input Validation*: Validates user inputs for answer keys and options
5. *Performance Feedback*: Contextual feedback based on score

## Troubleshooting

### Common Issues

*Issue*: Gradle build fails
- *Solution*: Ensure Java 11+ is installed and JAVA_HOME is set

*Issue*: JSON files not found
- *Solution*: Run the application once to auto-create files, or create them manually

*Issue*: Scanner input not working
- *Solution*: Make sure you're running with ./gradlew run which passes System.in

*Issue*: Permission denied on gradlew
- *Solution*: Run chmod +x gradlew on Linux/Mac

## Future Enhancements

- Add more user accounts
- Implement question editing and deletion
- Add question categories/topics
- Track student performance history
- Add timer for quizzes
- Implement question difficulty levels
- Add explanation for correct answers
- Export quiz results to PDF/CSV

## Development

### Building from Source

# Clone or download the project
cd quiz-management-system

# Build the project
./gradlew clean build

# Run tests (when implemented)
./gradlew test

# Generate JAR with dependencies
./gradlew jar

### Adding New Questions

As admin, you can add questions through the CLI, or manually edit quiz.json:

{
  "question": "Your question here?",
  "option 1": "First option",
  "option 2": "Second option",
  "option 3": "Third option",
  "option 4": "Fourth option",
  "answerkey": 1
}

## License

This project is created for educational purposes.

## Author

Quiz Management System - Java Project

---

*Note*: Make sure to keep users.json and quiz.json in the same directory as the JAR file when running the application.
