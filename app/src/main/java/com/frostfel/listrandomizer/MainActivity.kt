package com.frostfel.listrandomizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(intent.action == Intent.ACTION_SEND && intent.hasExtra(Intent.EXTRA_TEXT)){
            randomize_items_text_field?.setText(intent.getStringExtra(Intent.EXTRA_TEXT))
        }
    }
}