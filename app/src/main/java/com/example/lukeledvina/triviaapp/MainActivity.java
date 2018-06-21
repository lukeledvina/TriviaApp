package com.example.lukeledvina.triviaapp;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements QuestionCreatorFragment.Callback{

    private QuestionCreatorFragment questionCreatorFragment;
    private QuizFragment quizFragment;
    private List<Question> questionsList;
    public static final String QUESTIONS_LIST = "questions_list";


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

    @OnClick(R.id.take_quiz_button)
    protected void takeQuizClicked() {

        if(questionsList.isEmpty()) {
            //handle toast for if there are no questions saved for thre quiz
            Toast.makeText(this, "You must create some questions first ", Toast.LENGTH_SHORT).show();
        } else {
            //////////////////// ///launch fragment, pass in parcelable array
            quizFragment = QuizFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, quizFragment).commit();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(QUESTIONS_LIST, (ArrayList<? extends Parcelable>) questionsList);

        }
    }
}
