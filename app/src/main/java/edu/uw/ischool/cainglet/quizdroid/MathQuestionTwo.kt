package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MathQuestionTwo : AppCompatActivity() {
    private lateinit var submitButton: Button
    private lateinit var question: TextView
    private lateinit var optionOne: RadioButton
    private lateinit var optionTwo: RadioButton
    private lateinit var optionThree: RadioButton
    private lateinit var optionFour: RadioButton
    private lateinit var selectedButton: RadioButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_question_two)
        var score = intent.getIntExtra("score", 0)

        question = findViewById(R.id.question_two_text)
        question.text = "4 + 4"
        val correctAnswer = "8"

        optionOne = findViewById(R.id.math_two_option_one)
        optionTwo = findViewById(R.id.math_two_option_two)
        optionThree = findViewById(R.id.math_two_option_three)
        optionFour = findViewById(R.id.math_two_option_four)

        submitButton = findViewById(R.id.math_second_question_submit)
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

            val answerPage = Intent(this, MathAnswerPageTwo::class.java)
            answerPage.putExtra("score", score)
            answerPage.putExtra("chosen", selectedButton.text)
            answerPage.putExtra("answer", correctAnswer)
            startActivity(answerPage)
        }
    }
}