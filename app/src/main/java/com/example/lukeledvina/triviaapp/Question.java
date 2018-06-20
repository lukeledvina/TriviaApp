package com.example.lukeledvina.triviaapp;

public class Question {

    protected String quizQuestionInput;
    protected String correctAnswerInput;
    protected String wrongAnswerOneInput;
    protected String wrongAnswerTwoInput;
    protected String wrongAnswerThreeInput;


    public Question(String quizQuestion, String correctAnswer, String wrongAnswerOne, String wrongAnswerTwo, String wrongAnswerThree) {
        this.quizQuestionInput = quizQuestion;
        this.correctAnswerInput = correctAnswer;
        this.wrongAnswerOneInput = wrongAnswerOne;
        this.wrongAnswerTwoInput = wrongAnswerTwo;
        this.wrongAnswerThreeInput = wrongAnswerThree;
    }

    public String getQuizQuestionInput() {
        return quizQuestionInput;
    }

    public String getCorrectAnswerInput() {
        return correctAnswerInput;
    }

    public String getWrongAnswerOneInput() {
        return wrongAnswerOneInput;
    }

    public String getWrongAnswerTwoInput() {
        return wrongAnswerTwoInput;
    }

    public String getWrongAnswerThreeInput() {
        return wrongAnswerThreeInput;
    }
}
