package com.blumer.msu.geographyquiz2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.blumer.msu.geographyquiz2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )



    private var currentIndex = 0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener { view: View ->
            Snackbar.make(
                view,
                R.string.correct_snackbar,
                Snackbar.LENGTH_SHORT
            ).show()
        }

        binding.falseButton.setOnClickListener { view: View ->
            Snackbar.make(
                view,
                R.string.incorrect_snackbar,
                Snackbar.LENGTH_SHORT
            ).show()
        }


        binding.previousButton.setOnClickListener {
            currentIndex = (currentIndex - 1).coerceAtLeast(0) % questionBank.size
            updateQuestion()
        }
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        binding.questionTextView.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        updateQuestion()
    }
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

}