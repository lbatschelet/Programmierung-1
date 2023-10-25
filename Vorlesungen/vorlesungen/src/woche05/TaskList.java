package woche05;

import java.util.ArrayList;

public class TaskList {
    
    private ArrayList<AdditionTask> tasks;

    public TaskList(int number) {
        this.tasks = new ArrayList<AdditionTask>();
        int count = 0;
        while (count < number) {
            AdditionTask t = new AdditionTask();
            this.tasks.add(t);
            count++;
        }
    }

    public ArrayList<AdditionTask> getTasks() {
        return this.tasks;
    }

    public static void main(String[] args) {
        

    }
}


