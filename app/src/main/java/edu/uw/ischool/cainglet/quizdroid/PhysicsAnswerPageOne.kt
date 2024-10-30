package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhysicsAnswerPageOne : AppCompatActivity() {
    private lateinit var chosenAnswerView: TextView
    private lateinit var correctAnswerView: TextView
    private lateinit var currentScoreView: TextView
    private lateinit var nextButton: Button
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_answer_page_one)

        val chosenAnswer = intent.getStringExtra("chosen")
        val correctAnswer = intent.getStringExtra("answer")
        val score = intent.getIntExtra("score", 0)

        chosenAnswerView = findViewById(R.id.physics_question_chosen_answer)
        correctAnswerView = findViewById(R.id.physics_question_correct_answer)
        currentScoreView = findViewById(R.id.physics_question_current_score)

        chosenAnswerView.text = "Chosen Answer: $chosenAnswer"
        correctAnswerView.text = "Correct Answer: $correctAnswer"
        currentScoreView.text = "You have $score out of 2 correct"

        nextButton = findViewById(R.id.physics_answer_page_one_next)
        nextButton.setOnClickListener {
            val secondQuestion = Intent(this, PhysicsQuestionTwo::class.java)
            secondQuestion.putExtra("score", score)
            startActivity(secondQuestion)
        }
    }
}