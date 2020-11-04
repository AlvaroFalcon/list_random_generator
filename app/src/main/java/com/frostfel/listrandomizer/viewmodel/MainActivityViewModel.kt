package com.frostfel.listrandomizer.viewmodel

import android.content.Intent
import android.widget.EditText
import androidx.lifecycle.ViewModel
import com.frostfel.listrandomizer.utils.WordProcessor

class MainActivityViewModel : ViewModel() {
    val delimiter = "\n"
    var wordList : List<String> = listOf()
    fun setTextFromExtra(intent: Intent?, randomizeItemsTextField: EditText?) {
        val text = intent?.getStringExtra(Intent.EXTRA_TEXT)
        randomizeItemsTextField?.setText(text)
    }

    fun updateWordList(text: String?) {
        wordList = WordProcessor.recognizeWords(text, delimiter)
    }

    fun getRandomItemFromList(): String {
        return wordList.random()
    }

}