package woche08;



public class Question {
    
    private String questionText;
    private Answer[] answers;
    private Category category;


    // Constructor
    public Question(String category, String questionText, String correctAnswer, String wrongAnswer) {
        this.category = Category.valueOf(category);
        this.questionText = questionText;
        this.answers = new Answer[2]; // allways 50/50 questions
        this.answers[0] = new Answer(correctAnswer, true);
        this.answers[1] = new Answer(wrongAnswer, false);
    }

    public void printQuestion() {
        this.shuffleAnswers();
        System.out.println("Frage aus der Kategorie " + this.category.name());
        System.out.println(this.questionText);
        for (int i = 0; i < this.answers.length; i++) {
            System.out.println((i+1) + ". " + this.answers[i].getAnswerText());
        }
        
    }

    private void shuffleAnswers() {
        if (Math.random() < 0.5) {
            Answer temp = this.answers[0];
            this.answers[0] = this.answers[1];
            this.answers[1] = temp;
        }
    }

    public boolean evaluateAnswer(int choice) {
        if (choice >= 0 && choice < this.answers.length) {
            return this.answers[choice].isCorrect();
        }
        return false;
    }

    
}
