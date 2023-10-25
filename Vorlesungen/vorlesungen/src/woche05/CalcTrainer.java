package woche05;

import java.util.Iterator;
import java.util.Scanner;


public class CalcTrainer {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Wiw viele Aufgaben möchtest du lösen?");
        int number = scan.nextInt();

        TaskList taskList = new TaskList(number);

        int correctCount = 0;

        Iterator<AdditionTask> iter = taskList.getTasks().iterator();
        while (iter.hasNext()) {
            AdditionTask task = iter.next();
            task.displayTask();
            int answer = scan.nextInt();
            if (task.isCorrect(answer)) {
                System.out.println("Richtig!");
                correctCount++;
            } else {
                System.out.println("Falsch");
                System.out.println("Richtig wäre: " + task.getResult());
            }
        }
        System.out.println("Du hast " + correctCount + " von " + number + " Aufgaben richtig gelöst.");
        scan.close();
    }
    
    
}
