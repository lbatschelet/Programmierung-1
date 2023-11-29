package woche08;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Quiz {
    
    private final static String URL = "/Users/lukasbatschelet/Library/CloudStorage/OneDrive-UniversitaetBern/Studium/HS23/Programmierung_1/Vorlesungen/vorlesungen/src/woche08/resources/questions.txt";
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Question> questionList = QuestionReader.readQuestions(URL);
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        
        String another = "y";
        do {
            int next = rand.nextInt(questionList.size());
            Question q = questionList.get(next);
            q.printQuestion();
            System.out.println("Ihre Antwort: ");
            int choice = scan.nextInt();
            scan.nextLine(); // clear buffer
            if (q.evaluateAnswer(choice - 1)) {
                System.out.println("Richtig!");
            } else {
                System.out.println("Leider falsch!");
            }


            System.out.println("Neue Frage? (y/n)");
            another = scan.nextLine();

        } while (another.equalsIgnoreCase("y"));
        scan.close();

        
    }
}
