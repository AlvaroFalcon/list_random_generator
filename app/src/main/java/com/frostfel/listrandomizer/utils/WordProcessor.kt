package com.frostfel.listrandomizer.utils

class WordProcessor {
    companion object{
        fun recognizeWords(text: String?, delimiter: String = "\n") : List<String>{
            if(text == null) return listOf()
            if(text.isEmpty()) return listOf()
            if(!text.contains(delimiter)) return listOf(text)
            return text.trim().split(delimiter)
        }
    }
}