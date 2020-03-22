package com.example.hat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hat.entity.GameSettings
import kotlinx.android.synthetic.main.activity_add_word.*

class AddWordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)
        val gameSettings: GameSettings = intent.getSerializableExtra("gameSettings") as GameSettings
        updateWordsQuantity(gameSettings)

        button_to_add_word.setOnClickListener {
            val word = editText_to_add_word.text.toString()
            gameSettings.vocabular?.add(word)
            updateWordsQuantity(gameSettings)
        }

        button_continue_to_game.setOnClickListener {
            //TODO create new activity
            val intent1 = Intent(this, AddWordActivity::class.java)
            intent1.putExtra("gameSettings", gameSettings)
            startActivity(intent1)
        }
    }

    private fun updateWordsQuantity(gameSettings: GameSettings) {
        textView6.text = gameSettings.vocabular?.size.toString()
    }
}