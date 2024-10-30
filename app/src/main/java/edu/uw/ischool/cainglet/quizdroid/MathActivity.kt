package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MathActivity : AppCompatActivity() {
    private lateinit var beginButton: Button
    @SuppressLint("WrongViewCast", "MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        val score = intent.getIntExtra("score", 0)

        val mathDescription: TextView = findViewById((R.id.math_description_text))
        mathDescription.text = "The math category focuses on simple arithmetic problems."

        val numQuestions: TextView = findViewById(R.id.math_number_questions)
        numQuestions.text = "The math category has 2 questions."

        beginButton = findViewById(R.id.math_begin_button)
        beginButton.setOnClickListener {
            val firstQuestion = Intent(this, MathQuestionOne::class.java)
            firstQuestion.putExtra("score", score)
            startActivity(firstQuestion)
        }
    }
}