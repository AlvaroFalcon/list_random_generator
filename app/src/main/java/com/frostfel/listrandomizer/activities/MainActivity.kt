package com.frostfel.listrandomizer.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.frostfel.listrandomizer.R
import com.frostfel.listrandomizer.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        randomize_btn.setOnClickListener(this)
        if(intent.action == Intent.ACTION_SEND && intent.hasExtra(Intent.EXTRA_TEXT)){
            viewModel.setTextFromExtra(intent, randomize_items_text_field)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.clear_list -> {
                viewModel.clearList()
                randomize_items_text_field.setText("")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.randomize_btn ->{
                viewModel.updateWordList(randomize_items_text_field.text.toString())
                val randomItem = viewModel.getRandomItemFromList()
                result_text.text = randomItem
            }
        }
    }
}