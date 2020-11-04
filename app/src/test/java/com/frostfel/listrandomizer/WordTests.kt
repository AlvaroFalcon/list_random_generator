package com.frostfel.listrandomizer

import com.frostfel.listrandomizer.utils.WordProcessor
import org.junit.Test

import org.junit.Assert.*

class WordTests {

    @Test
    fun recognise_with_empty_string() {
        assertEquals(0, WordProcessor.recognizeWords("").size)
    }

    @Test
    fun recognise_words_separated_by_break_lines() {
        assertEquals(3, WordProcessor.recognizeWords("hola\nque\ntal").size)
    }

    @Test
    fun recognise_words_separated_by_custom_delimiter(){
        assertEquals(3, WordProcessor.recognizeWords("hola,que,tal",",").size)
    }

    @Test
    fun recognise_when_delimiter_is_not_available(){
        assertEquals(1, WordProcessor.recognizeWords("holaquetal").size)
    }

}