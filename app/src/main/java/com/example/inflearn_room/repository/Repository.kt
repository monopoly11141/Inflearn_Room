package com.example.inflearn_room.repository

import android.content.Context
import com.example.inflearn_room.db.TextDatabase
import com.example.inflearn_room.entity.TextEntity
import com.example.inflearn_room.entity.WordEntity

class Repository(context : Context) {

    private val db = TextDatabase.getDatabase(context)

    fun getTextList() = db.textDao().getAllData()

    fun getWordList() = db.wordDao().getAllData()

    fun insertTextData(text : String) = db.textDao().insert(TextEntity(0, text))

    fun insertWordData(word : String) = db.wordDao().insert(WordEntity(0, word))

    fun deleteTextData() = db.textDao().deleteAllData()

    fun deleteWordData() = db.wordDao().deleteAllData()

}