package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhysicsQuestionTwo : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var optionOne: RadioButton
    private lateinit var optionTwo: RadioButton
    private lateinit var optionThree: RadioButton
    private lateinit var optionFour: RadioButton
    private lateinit var question: TextView
    private lateinit var selectedButton: RadioButton
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_question_two)

        var score = intent.getIntExtra("score", 0)

        question = findViewById(R.id.physics_question_two_text)
        question.text = "If you drop a ball, what causes it's downward acceleration?"
        val correctAnswer = "Gravity"

        optionOne = findViewById(R.id.physics_option_one)
        optionTwo = findViewById(R.id.physics_option_two)
        optionThree = findViewById(R.id.physics_option_three)
        optionFour = findViewById(R.id.physics_option_four)

        submitButton = findViewById(R.id.physics_second_question_submit)
        submitButton.isEnabled = false

        optionOne.setOnClickListener {
            selectedButton = optionOne
            submitButton.isEnabled = true
        }

        optionTwo.setOnClickListener {
            selectedButton = optionTwo
            submitButton.isEnabled = true
        }

        optionThree.setOnClickListener {
            selectedButton = optionThree
            submitButton.isEnabled = true
        }

        optionFour.setOnClickListener {
            selectedButton = optionFour
            submitButton.isEnabled = true
        }

        submitButton.setOnClickListener {
            if (selectedButton.text == correctAnswer) {
                score += 1
            }

            val answerPage = Intent(this, PhysicsAnswerPageTwo::class.java)
            answerPage.putExtra("score", score)
            answerPage.putExtra("chosen", selectedButton.text)
            answerPage.putExtra("answer", correctAnswer)
            startActivity(answerPage)
        }
    }
}