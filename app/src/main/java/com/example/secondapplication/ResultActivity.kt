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

        val mainImage = intent.getIntExtra("mainImage", 0)
        val selectedAnswer = intent.getIntExtra("selectedAnswer", 0)

        when(mainImage) {
            chihuahua -> resultImage.setImageResource(R.drawable.chihuahua)
            koala -> resultImage.setImageResource(R.drawable.koala)
            panda -> resultImage.setImageResource(R.drawable.panda)
        }

        if (mainImage == selectedAnswer) {
            resultText.setText(R.string.result_correct)
        } else {
            resultText.setText(R.string.result_incorrect)
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
