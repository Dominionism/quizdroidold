package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhysicsActivity : AppCompatActivity() {
    private lateinit var beginButton: Button
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics)

        val score = intent.getIntExtra("score", 0)

        val physicsDescription: TextView = findViewById(R.id.physics_description_text)
        physicsDescription.text = "The physics category focuses on simple physics problems."

        val numQuestions: TextView = findViewById((R.id.physics_number_questions))
        numQuestions.text = "The physics category as 2 questions."

        beginButton = findViewById(R.id.physics_begin_button)
        beginButton.setOnClickListener {
            val firstQuestion = Intent(this, PhysicsQuestionOne::class.java)
            firstQuestion.putExtra("score", score)
            startActivity(firstQuestion)
        }
    }
}