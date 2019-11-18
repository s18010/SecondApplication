package com.example.secondapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val chihuahua = 0
        val koala = 1
        val panda = 2

        val mainImage = intent.getIntExtra("mainImage", 0)
        val selectedAnswer = intent.getIntExtra("selectedAnswer", 0)
        var answerText = ""


        when (mainImage) {
            chihuahua -> {
                resultImage.setImageResource(R.drawable.chihuahua)
                answerText = getString(R.string.chihuahuaText)
            }
            koala -> {
                resultImage.setImageResource(R.drawable.koala)
                answerText = getString(R.string.koalaText)
            }
            panda -> {
                resultImage.setImageResource(R.drawable.panda)
                answerText = getString(R.string.pandaText)
            }
        }

        when (selectedAnswer) {
            chihuahua -> yourAnswer.text = "チワワ"
            koala -> yourAnswer.text = "コアラ"
            panda -> yourAnswer.text = "パンダ"
        }

        if (mainImage == selectedAnswer) {
            saveScores(1)
            resultText.text = "正解"
        } else {
            saveScores(0)
            resultText.text = "不正解"
            val text = "正解は「${answerText}」でした"
            correctAnswerText.text = text
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun saveScores(isCorrect: Int) {
        val pref = getSharedPreferences("SCORES", Context.MODE_PRIVATE)
        val lastScore2 = pref.getInt("LAST_SCORE", -1)
        val lastScore3 = pref.getInt("LAST_SCORE2", -1)

        pref.edit {
            putInt("LAST_SCORE", isCorrect)
            putInt("LAST_SCORE2", lastScore2)
            putInt("LAST_SCORE3", lastScore3)
        }
    }
}
