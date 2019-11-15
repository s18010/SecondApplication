package com.example.secondapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val chihuahua = 0
        val koala = 1
        val panda = 2


//        val intent = Intent(this, MainActivity::class.java)
        val mainImage = intent.getIntExtra("mainImage", 0)
        val selectedAnswer = intent.getIntExtra("selectedAnswer", 0)
        var answerText = ""
        var isCorrect = -1


        when (mainImage) {
            chihuahua -> {
                resultImage.setImageResource(R.drawable.chihuahua)
                answerText = "チワワ"
            }
            koala -> {
                resultImage.setImageResource(R.drawable.koala)
                answerText = "コアラ"
            }
            panda -> {
                resultImage.setImageResource(R.drawable.panda)
                answerText = "パンダ"
            }
        }

        when (selectedAnswer) {
            chihuahua -> yourAnswer.text = "チワワ"
            koala -> yourAnswer.text = "コアラ"
            panda -> yourAnswer.text = "パンダ"
        }

        if (mainImage == selectedAnswer) {
            resultText.text = "正解"
        } else {
            resultText.text = "不正解"
            correctAnswerText.text = "正解は「${answerText}」でした"
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
