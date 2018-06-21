package com.example.lukeledvina.triviaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.lukeledvina.triviaapp.MainActivity.QUESTIONS_LIST;

public class QuizFragment extends Fragment {

    @BindView(R.id.question_textview)
    protected TextView quizQuestion;

    @BindView(R.id.first_answer_button)
    protected Button firstAnswerButton;

    @BindView(R.id.second_answer_button)
    protected Button secondAnswerButton;

    @BindView(R.id.third_answer_button)
    protected Button thirdAnswerButton;

    @BindView(R.id.fourth_answer_button)
    protected Button fourthAnswerButton;

    @BindView(R.id.next_question_button)
    protected Button nextQuestionButton;

    private List<Question> questionsList;
    private Question question;
    private int questionListPosition = 0;
    private int correctAnswers = 0;
    private QuizCallback quizCallback;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_take_quiz, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static QuizFragment newInstance() {

        Bundle args = new Bundle();

        QuizFragment fragment = new QuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.first_answer_button)
    protected void buttonOneClicked() {

        checkAnswer(firstAnswerButton.getText().toString());
    }

    @OnClick(R.id.second_answer_button)
    protected void buttonTwoClicked() {

        checkAnswer(secondAnswerButton.getText().toString());
    }

    @OnClick(R.id.third_answer_button)
    protected void buttonThreeClicked() {

        checkAnswer(thirdAnswerButton.getText().toString());

    }

    @OnClick(R.id.fourth_answer_button)
    protected void buttonfourClicked() {

        checkAnswer(fourthAnswerButton.getText().toString());

    }

    @OnClick(R.id.next_question_button)
    protected void buttonNextClicked() {

        if (questionListPosition <= questionsList.size() - 1) {

            populateQuizContent();
        } else {
            //handling no more questions, taking user back to main activity
            quizCallback.quizFinished(correctAnswers);

        }
    }

    public void attachParent(QuizCallback quizCallback){

        this.quizCallback = quizCallback;
    }

    public interface QuizCallback {

        void quizFinished(int correctAnswers);
    }

    @Override
    public void onStart() {
        super.onStart();

        questionsList = getArguments().getParcelableArrayList(QUESTIONS_LIST);

        populateQuizContent();
    }

    private void populateQuizContent() {
        question = questionsList.get(questionListPosition);
        quizQuestion.setText(question.getQuizQuestionInput());

        List<Button> buttonList = new ArrayList<>();
        buttonList.add(firstAnswerButton);
        buttonList.add(secondAnswerButton);
        buttonList.add(thirdAnswerButton);
        buttonList.add(fourthAnswerButton);

        List<String> possibleAnswersList = new ArrayList<>();
        possibleAnswersList.add(question.getCorrectAnswerInput());
        possibleAnswersList.add(question.getWrongAnswerOneInput());
        possibleAnswersList.add(question.getWrongAnswerTwoInput());
        possibleAnswersList.add(question.getWrongAnswerThreeInput());

        for (Button button : buttonList) {

            int random = (int) Math.ceil(Math.random() * (possibleAnswersList.size() - 1));

            //takes the random numbers from above and mixes the text to different buttons
            button.setText(possibleAnswersList.get(random));
            possibleAnswersList.remove(random);
        }

    }

    private void checkAnswer(String answer) {
        //Increments questionListPostioton so we can go to the next question
        questionListPosition++;
        if (question.getCorrectAnswerInput().equals(answer)) {
            //sets the text view to shjow the user they were correct
            quizQuestion.setText(R.string.correct);
            //Increments the correct answers the use r has gotten
            correctAnswers++;


        } else {
            quizQuestion.setText(getString(R.string.wrong_answer_text, question.getCorrectAnswerInput()));
        }

    }


}
