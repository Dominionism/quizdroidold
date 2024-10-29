package edu.uw.ischool.cainglet.quizdroid

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val model = listOf("Math", "Physics", "Marvel Superheroes")
    private lateinit var quizTopics: ListView
    private var currentScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizTopics = findViewById((R.id.view_primary))
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, model)
        quizTopics.adapter = adapter

        quizTopics.setOnItemClickListener { _, _, position, _ ->
            val selectedTopic = model[position]
            lateinit var topicActivity: Intent
            when (selectedTopic) {
                "Math" -> topicActivity = Intent(this, MathActivity::class.java)
                "Physics" -> topicActivity = Intent(this, PhysicsActivity::class.java)
                "Marvel Superheroes" -> topicActivity = Intent(this, MarvelActivity::class.java)
            }

            topicActivity.putExtra("score", currentScore)
            startActivity(topicActivity)
        }
    }
}