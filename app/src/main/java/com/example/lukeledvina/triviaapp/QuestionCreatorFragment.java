package com.example.lukeledvina.triviaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionCreatorFragment extends Fragment {


    @BindView(R.id.question_edittext)
    protected EditText questionInput;
    @BindView(R.id.correct_answer_edittext)
    protected EditText correctAnswerInput;
    @BindView(R.id.first_wrong_answer_edittext)
    protected EditText firstWrongAnswerInput;
    @BindView(R.id.second_wrong_answer_edittext)
    protected EditText secondWrongAnswerInput;
    @BindView(R.id.third_wrong_answer_edittext)
    protected EditText thirdWrongAnswerInput;

    private Callback callback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_creator, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    public static QuestionCreatorFragment newInstance() {

        Bundle args = new Bundle();

        QuestionCreatorFragment fragment = new QuestionCreatorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.save_question_button)
    protected void addQuestion() {







                //Gets use input from the editTexts and saves them as variables
                String questionTitle = questionInput.getText().toString();
                String correctAnswer = correctAnswerInput.getText().toString();
                String firstWrongAnswer = firstWrongAnswerInput.getText().toString();
                String secondWrongAnswer = secondWrongAnswerInput.getText().toString();
                String thirdWrongAnswer = thirdWrongAnswerInput.getText().toString();

                if (questionInput.getText().toString().isEmpty() || correctAnswerInput.getText().toString().isEmpty() || firstWrongAnswerInput.getText().toString().isEmpty() || secondWrongAnswerInput.getText().toString().isEmpty() || thirdWrongAnswerInput.getText().toString().isEmpty()) {
                    return;


            } else {
            //takes variables crated from user input and saves them in the Questoon object
            Question question = new Question(questionTitle, correctAnswer, firstWrongAnswer, secondWrongAnswer, thirdWrongAnswer);

            //sends question object we just created to the callback methiod to be saves
            callback.questionSaved(question);
        }

    }

    public void attachParent(Callback callback) {
        this.callback = callback;

    }


    public interface Callback {

        void questionSaved(Question question);
    }


}
