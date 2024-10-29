package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MathAnswerPageTwo : AppCompatActivity() {
    private lateinit var chosenAnswerView: TextView
    private lateinit var correctAnswerView: TextView
    private lateinit var currentScoreView: TextView
    private lateinit var finishButton: Button
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_answer_page_two)

        val chosenAnswer = intent.getStringExtra("chosen")
        val correctAnswer = intent.getStringExtra("answer")
        val score = intent.getIntExtra("score", 0)

        chosenAnswerView = findViewById(R.id.math_two_question_two_chosen_answer)
        correctAnswerView = findViewById(R.id.math_two_question_two_correct_answer)
        currentScoreView = findViewById(R.id.math_two_question_two_current_score)

        chosenAnswerView.text = "Chosen Answer: $chosenAnswer"
        correctAnswerView.text = "Correct Answer: $correctAnswer"
        currentScoreView.text = "You have $score out of 2 correct"

        finishButton = findViewById(R.id.math_answer_page_two_finish)
        finishButton.setOnClickListener {
            val homePage = Intent(this, MainActivity::class.java)
            startActivity(homePage)
        }
    }
}