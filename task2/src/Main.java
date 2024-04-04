import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private char correctAnswer;

    public QuizQuestion(String question, List<String> options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;
    private static final int TIME_LIMIT_SECONDS = 10;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            displayQuestion(question);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    proceedToNextQuestion();
                }
            }, TIME_LIMIT_SECONDS * 1000);

            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toUpperCase();
            timer.cancel(); // Cancel the timer as the user has submitted an answer

            checkAnswer(question, userAnswer);
            proceedToNextQuestion();
        }

        displayResult();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println("\n" + question.getQuestion());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((char) ('A' + i) + ". " + options.get(i));
        }
    }

    private void checkAnswer(QuizQuestion question, String userAnswer) {
        if (userAnswer.equals(String.valueOf(question.getCorrectAnswer()))) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
        }
    }

    private void proceedToNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            System.out.println("\nNext question:");
        }
    }

    private void displayResult() {
        System.out.println("\nQuiz completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());

        // Display summary of correct/incorrect answers
        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion question = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + question.getQuestion());
            System.out.println("Correct Answer: " + question.getCorrectAnswer());
        }
    }
}

 class QuizApp {
    public static void main(String[] args) {
        // Create quiz questions
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("What is the capital of France?", Arrays.asList("A. Berlin", "B. Paris", "C. Rome"), 'B'));
        quizQuestions.add(new QuizQuestion("Which planet is known as the Red Planet?", Arrays.asList("A. Mars", "B. Venus", "C. Jupiter"), 'A'));
        // Add more questions as needed

        // Create a quiz with the questions
        Quiz quiz = new Quiz(quizQuestions);

        // Start the quiz
        quiz.startQuiz();
    }
}
