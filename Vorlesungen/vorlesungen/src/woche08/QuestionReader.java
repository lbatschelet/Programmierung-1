package woche08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionReader {

    public static ArrayList<Question> readQuestions(String url) throws FileNotFoundException {
        ArrayList<Question> questionList = new ArrayList<Question>();
        Scanner fileScanner = new Scanner(new File(url));
        Scanner lineScanner;

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            lineScanner = new Scanner(line);
            lineScanner.useDelimiter(";");
            Question question = new Question(lineScanner.next(), 
                                             lineScanner.next(),
                                             lineScanner.next(),
                                             lineScanner.next());
            questionList.add(question);
        }


        return questionList;
    }
    
    
}
