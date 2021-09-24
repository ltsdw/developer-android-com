package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    private fun rollDice() {
        val firstDiceImage: ImageView = findViewById(R.id.imageView)
        val secondDiceImage: ImageView = findViewById(R.id.imageView2)

        val firstDiceResourceId: Int = getDiceSideId()
        val secondDiceResourceId: Int = getDiceSideId()

        firstDiceImage.setImageResource(firstDiceResourceId)
        firstDiceImage.contentDescription = "result of the first dice is $firstDiceResourceId"

        secondDiceImage.setImageResource(secondDiceResourceId)
        secondDiceImage.contentDescription = "result of the second dice is $secondDiceResourceId"
    }

    private fun getDiceSideId(): Int {
        return when (Dice(6).roll()) {
            1       -> R.drawable.dice_1
            2       -> R.drawable.dice_2
            3       -> R.drawable.dice_3
            4       -> R.drawable.dice_4
            5       -> R.drawable.dice_5
            else    -> R.drawable.dice_6
        }
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
