package com.kathleenwang.interactivestory.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.kathleenwang.interactivestory.R

class MainActivity : AppCompatActivity() {
    private var nameField: EditText? = null
    private var startButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameField = findViewById(R.id.nameEditText)
        startButton = findViewById(R.id.startButton)
        startButton!!.setOnClickListener {
            val name = nameField!!.text.toString()
            startStory(name)
        }
    }
    private fun startStory(name: String){
//        val toast = Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT)
//        toast.show()
        val intent = Intent(this, StoryActivity::class.java)
        val keyName = getString(R.string.key_name)
        intent.putExtra(keyName,name)
        startActivity(intent)
    }
}