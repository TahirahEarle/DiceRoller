package com.tahirahearle.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var scoreText: TextView
    private lateinit var resultImages: ImageView
    private lateinit var resultImages1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        scoreText=findViewById(R.id.score_text)
        resultImages=findViewById(R.id.dice_image)
        resultImages1=findViewById(R.id.dice_image1)

        // Button & Animation
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text= getString(R.string.let_roll)
        rollButton.setOnClickListener {
            rollDice()
        }

        resultImages= findViewById(R.id.dice_image)
        resultImages1= findViewById(R.id.dice_image1)

    }

    @SuppressLint("SetTextI18n")

    // function to roll dice and display result
    private fun rollDice() {
        //Die 1
        val randomInt=(1..6).random()
        val drawableImage = when(randomInt){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        //Die 2
        val randomInt1=(1..6).random()
        val drawableImage1 = when(randomInt1){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        //Adding both dice face value
        val tvInt=randomInt +randomInt1

        // converting int into string
        val tvText = tvInt.toString()

        resultImages.setImageResource(drawableImage)
        resultImages1.setImageResource(drawableImage1)

        // displaying the sum / score of the dice
        scoreText.text="You Rolled $tvText"
        Toast.makeText(this,"You Rolled $tvText", Toast.LENGTH_SHORT).show()
    }
}
