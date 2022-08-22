package com.example.codepath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

/**
 * Main Activity - The home page. Consists of an introduction, a button, and a cool menu tab
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuButton: Button = findViewById(R.id.button)
        menuButton.setOnClickListener { Toast.makeText(this, "Hey there! Click on the menu on the top-left to learn more about me!", Toast.LENGTH_LONG).show() }
    }

    // This function will implement the main menu that includes a CodePath fan button, a roll-the-dice
    // game, and a menu tab that has an about me tab
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    // This function is for when the user click in each of the buttons
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_menu -> aboutMe()
            R.id.nav_dice -> dice()
            R.id.nav_favorite -> Toast.makeText(this, "CodePath Rules!", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    // This function directs the user to the dice page
    private fun dice() {
        val intent = Intent(this, DiceActivity::class.java)
        startActivity(intent)
    }

    // This function directs the user to the about me page
    private fun aboutMe() {
        val intent = Intent(this, AboutMeActivity::class.java)
        startActivity(intent)
    }
}