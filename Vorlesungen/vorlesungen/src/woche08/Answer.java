package woche08;

public class Answer {

    private String answerText;
    private boolean correct;

    public Answer(String answer, boolean correct) {
        this.answerText = answer;
        this.correct = correct;
    }

    public String getAnswerText() {
        return this.answerText;
    }

    public boolean isCorrect() {
        return this.correct;
    }

}
