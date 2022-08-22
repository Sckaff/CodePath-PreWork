package com.example.codepath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

/**
 * This activity is something fun that I felt like introducing to my pre-work part of the application,
 * a roll-the-dice game!
 */
class DiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        // Rolling the dice for the first time so the screen is not blank
        rollDice()

        // Roll the dice as someone clicks on the button
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    // Creating a menu so you could go back home
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.go_back_nav, menu)
        return true
    }

    // Implementing the "go back home" button
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_left -> goBack()
        }
        return super.onOptionsItemSelected(item)
    }

    // Making the "go back home" button its own function for good practice
    private fun goBack() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // Roll-the-dice function
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
        val rollText = "You rolled a " + diceRoll + "!"
        Toast.makeText(this, rollText, Toast.LENGTH_SHORT).show()
    }
}

// Created a dice class so I could further implement dices with other number of sides!
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}