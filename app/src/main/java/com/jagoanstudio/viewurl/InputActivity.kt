package com.jagoanstudio.viewurl

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        button_view_url.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("url", edittext_input_url.text.toString())
            startActivity(intent)
        }
    }

}