package com.example.android.quizapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int answerOneScore, answerTwoScore, answerThreeScore, answerFourScore, answerFiveScore;
    int totalScore;

    /**
     * These are boolean variables for Question Two
     */
    boolean answerChoice1;
    boolean answerChoice2;
    boolean answerChoice3;
    boolean answerChoice4;
    boolean answerChoice5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is for doing a summary of all scores and display the answer in a toast message
     * once the submit button is clicked
     **/

    public void submitResults(View view) {

        questionFourUserAns(view);
        questionTwoUserAns();

        totalScore = answerOneScore + answerTwoScore + answerThreeScore + answerFourScore + answerFiveScore;

        if (totalScore < 3) {
            Toast.makeText(this, getString(R.string.toast_messageForBelow3pts) + " " + totalScore + "/5" + "!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.toast_messageForAbove3pts) + " " + totalScore + "/5" + "!", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * This method gets the score for question one. The correct answer is Miroslav Klose
     **/
    public void questionOneUserAns(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.Klose:
                if (checked)
                    answerOneScore = 1;
                break;
            case R.id.Ronaldo:
                if (checked)
                    answerOneScore = 0;
                break;
            case R.id.Cristiano:
                if (checked)
                    answerOneScore = 0;
                break;
            case R.id.Messi:
                if (checked)
                    answerOneScore = 0;
                break;
        }
    }

    /**
     * This method  gets the score for Question Two. The correct answer is Senegal, Cameroon and Ghana.
     */
    public void questionTwoUserAns() {

        CheckBox question2choice1 = (CheckBox) this.findViewById(R.id.checkbox_nigeria);
        CheckBox question2choice2 = (CheckBox) this.findViewById(R.id.checkbox_senegal);
        CheckBox question2choice3 = (CheckBox) this.findViewById(R.id.checkbox_cameroon);
        CheckBox question2choice4 = (CheckBox) this.findViewById(R.id.checkbox_algeria);
        CheckBox question2choice5 = (CheckBox) this.findViewById(R.id.checkbox_ghana);

        answerChoice1 = question2choice1.isChecked();
        answerChoice2 = question2choice2.isChecked();
        answerChoice3 = question2choice3.isChecked();
        answerChoice4 = question2choice4.isChecked();
        answerChoice5 = question2choice5.isChecked();

        if (answerChoice2 && answerChoice3&& answerChoice5&& !answerChoice1&& !answerChoice4) {
            answerTwoScore = 1;
        } else {
            answerTwoScore = 0;
        }
    }

    /**
     * This method gets the score for Question Three. The correct answer is Germany/Brazil
     **/
    public void questionThreeUserAns(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.BraIta:
                if (checked)
                    answerThreeScore = 0;
                break;
            case R.id.SpaBra:
                if (checked)
                    answerThreeScore = 0;
                break;
            case R.id.GerBra:
                if (checked)
                    answerThreeScore = 1;
                break;
            case R.id.ItaGer:
                if (checked)
                    answerThreeScore = 0;
                break;
        }
    }

    /**
     * This method  gets the score for Question Four. The correct answer is Uruguay.
     *
     * @param view
     */
    public int questionFourUserAns(View view) {
        EditText editText_answer4 = (EditText) findViewById(R.id.questionFour);
        String userQuestion4Ans = editText_answer4.getText().toString();

        if (userQuestion4Ans.replaceAll("\\s", "").equalsIgnoreCase("Uruguay")) {
            answerFourScore = 1;
        } else {
            answerFourScore = 0;
        }
        return answerFourScore;
    }

    /**
     * This method  gets the score for Question Five. The correct answer is 1930.
     *
     * @param view
     */
    public void questionFiveUserAns(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.y1930:
                if (checked)
                    answerFiveScore = 1;
                break;
            case R.id.y1908:
                if (checked)
                    answerFiveScore = 0;
                break;
            case R.id.y1950:
                if (checked)
                    answerFiveScore = 0;
                break;
            case R.id.y1926:
                if (checked)
                    answerFiveScore = 0;
                break;
        }
    }
}