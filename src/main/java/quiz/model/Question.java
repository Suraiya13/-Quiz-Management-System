package quiz.model;

import com.google.gson.annotations.SerializedName;

public class Question {
    private String question;

    @SerializedName("option 1")
    private String option1;

    @SerializedName("option 2")
    private String option2;

    @SerializedName("option 3")
    private String option3;

    @SerializedName("option 4")
    private String option4;

    @SerializedName("answerkey")
    private int answerKey;

    public Question() {}

    public Question(String question, String option1, String option2, String option3, String option4, int answerKey) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerKey = answerKey;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(int answerKey) {
        this.answerKey = answerKey;
    }
}