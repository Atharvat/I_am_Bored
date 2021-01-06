package com.atharva.iambored

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewArticleActivity : AppCompatActivity() {

    private lateinit var editTitleView: EditText
    private lateinit var editTextView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_article)

        editTitleView = findViewById(R.id.edit_title)
        editTextView = findViewById(R.id.edit_text)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener{
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editTextView.text) || TextUtils.isEmpty(editTitleView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val article = arrayOf(editTitleView.text.toString(), editTextView.text.toString())
                replyIntent.putExtra(EXTRA_REPLY, article)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}