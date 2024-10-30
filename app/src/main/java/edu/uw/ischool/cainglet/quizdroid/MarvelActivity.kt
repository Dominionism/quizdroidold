package edu.uw.ischool.cainglet.quizdroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MarvelActivity : AppCompatActivity() {
    private lateinit var  beginButton: Button
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel)

        val score = intent.getIntExtra("score", 0)

        val marvelDescription: TextView = findViewById(R.id.marvel_description_text)
        marvelDescription.text = "The Marvel category focuses on hero features."

        val numQuestions: TextView = findViewById(R.id.marvel_number_questions)
        numQuestions.text = "The marvel category has 2 questions."

        beginButton = findViewById(R.id.marvel_begin_button)
        beginButton.setOnClickListener {
            val firstQuestion = Intent(this, MarvelQuestionOne::class.java)
            firstQuestion.putExtra("score", score)
            startActivity(firstQuestion)
        }
    }
}