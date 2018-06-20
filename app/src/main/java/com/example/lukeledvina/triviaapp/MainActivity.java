package com.example.lukeledvina.triviaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements QuestionCreatorFragment.Callback{

    private QuestionCreatorFragment questionCreatorFragment;
    private List<Question> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        questionsList = new ArrayList<>();
    }

    @OnClick(R.id.add_question_button)
    protected void addQuestionClicked() {

        questionCreatorFragment = QuestionCreatorFragment.newInstance();
        questionCreatorFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, questionCreatorFragment).commit();


    }

    @Override
    public void questionSaved(Question question) {
        //takes the question object that was passed in and saves it to the questions array list
        questionsList.add(question);
        //shows a toast to the user that lets them know the question was saved
        Toast.makeText(this, "Question Saved", Toast.LENGTH_SHORT).show();
        //removes the fragment from the freame layout
        getSupportFragmentManager().beginTransaction().remove(questionCreatorFragment).commit();

    }
}
