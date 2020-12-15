package com.kathleenwang.interactivestory.ui

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.kathleenwang.interactivestory.R
import com.kathleenwang.interactivestory.model.Page
import com.kathleenwang.interactivestory.model.Story


class StoryActivity : AppCompatActivity() {
    private val tag = StoryActivity::class.java.simpleName
    private var storyImageView : ImageView? = null
    private var storyTextView : TextView? = null
    private var choice1Button: Button?= null
    private var choice2Button: Button? = null
    private var name : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        storyImageView =  findViewById(R.id.storyImageView)
        storyTextView = findViewById(R.id.storyTextView)
        choice1Button = findViewById(R.id.choice1Button)
        choice2Button = findViewById(R.id.choice2Button)

        val intent:Intent = intent
        val keyName = getString(R.string.key_name)
        name = intent.getStringExtra(keyName)
        // add condition in case name is empty
        if (name.isNullOrEmpty()) {
            name = "Friend"
        }
        loadPage(0)
        }
    private fun loadPage(pageNumber:Int){
        val story = Story()
        choice1Button!!.visibility = View.VISIBLE
        var page: Page = story.getPage(pageNumber)
        var image : Drawable? = ContextCompat.getDrawable(this, page.imageId)
        storyImageView!!.setImageDrawable(image)

        var pageText = getString(page.textId)
        // Add name if placeholder is included (won't add anything if placeholder not found)
        pageText = String.format(pageText, name)
        storyTextView!!.text = pageText

        if (page.isFinalPage) {
            val toast = Toast.makeText(this, getString(R.string.final_page_text), Toast.LENGTH_SHORT)
            toast.show()
            choice1Button!!.visibility = View.INVISIBLE
            choice2Button!!.text = getString(R.string.play_again_button_text)
            choice2Button!!.setOnClickListener {
                loadPage(0)
            }
        }
        else {
            loadButtons(page)
        }

    }
    private fun loadButtons(page:Page){
        var button1Text = getString(page.choice1!!.textId)
        var button2Text = getString(page.choice2!!.textId)
        choice1Button!!.text = button1Text
        choice2Button!!.text = button2Text
        choice1Button!!.setOnClickListener {
            var nextPage: Int = page.choice1!!.nextPage
            loadPage((nextPage))
        }
        choice2Button!!.setOnClickListener {
            var nextPage: Int = page.choice2!!.nextPage
            loadPage((nextPage))
        }
    }

}