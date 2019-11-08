package com.example.secondapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val chihuahua = 0
    val koala = 1
    val panda = 2
    var randImage: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        load()
   }

    fun onButtonTapped(view: View?) {
        val selectedAnswer: Int? = when(view?.id) {
            R.id.chihuahuaButton -> chihuahua
            R.id.koalaButton -> koala
            R.id.pandaButton -> panda
            else -> null
        }
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("mainImage", randImage)
        intent.putExtra("selectedAnswer", selectedAnswer)
        startActivity(intent)
    }

    private fun load() {
        randImage = (Math.random() * 3).toInt()

        when(randImage) {
            chihuahua -> mainImage.setImageResource(R.drawable.chihuahua)
            koala -> mainImage.setImageResource(R.drawable.koala)
            panda -> mainImage.setImageResource(R.drawable.panda)
        }

        chihuahuaButton.setOnClickListener{ onButtonTapped(it) }
        koalaButton.setOnClickListener{ onButtonTapped(it) }
        pandaButton.setOnClickListener{ onButtonTapped(it) }
    }

    override fun onResume() {
        super.onResume()

        load()
        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show()
    }
}
