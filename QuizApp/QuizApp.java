import java.util.*;

class Question {
    String question;
    String[] options;
    char answer;

    Question(String question, String[] options, char answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question(
                "1. What is the capital of France?",
                new String[]{"A. Berlin", "B. Madrid", "C. Paris", "D. Rome"},
                'C'
        ));
        quiz.add(new Question(
                "2. Which planet is known as the Red Planet?",
                new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"},
                'B'
        ));
        quiz.add(new Question(
                "3. Who developed Python?",
                new String[]{"A. James Gosling", "B. Guido van Rossum", "C. Dennis Ritchie", "D. Bjarne Stroustrup"},
                'B'
        ));

        int score = 0;

       

        for (Question q : quiz) {
            System.out.println("\n" + q.question);
            for (String opt : q.options) {
                System.out.println(opt);
            }

            System.out.print("Your answer (A/B/C/D): ");
            char ans = sc.next().toUpperCase().charAt(0);

            if (ans == q.answer) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.answer);
            }
        }

       
        System.out.println("\nYour final score is " + score + "/" + quiz.size());
        sc.close();
    }
}
