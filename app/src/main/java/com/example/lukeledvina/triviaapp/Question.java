package com.example.lukeledvina.triviaapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable{

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

    protected Question(Parcel in) {
        quizQuestionInput = in.readString();
        correctAnswerInput = in.readString();
        wrongAnswerOneInput = in.readString();
        wrongAnswerTwoInput = in.readString();
        wrongAnswerThreeInput = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(quizQuestionInput);
        parcel.writeString(correctAnswerInput);
        parcel.writeString(wrongAnswerOneInput);
        parcel.writeString(wrongAnswerTwoInput);
        parcel.writeString(wrongAnswerThreeInput);
    }
}
