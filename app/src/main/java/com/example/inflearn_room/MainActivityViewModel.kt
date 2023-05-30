package com.example.inflearn_room

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.inflearn_room.db.TextDatabase
import com.example.inflearn_room.entity.TextEntity
import com.example.inflearn_room.entity.WordEntity
import com.example.inflearn_room.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application : Application) : AndroidViewModel(application) {

    private val TAG = this::class.java.simpleName

    private val context = application.applicationContext

    private val repository = Repository(context)

    private var _textList = MutableLiveData<List<TextEntity>>()
    val textList : MutableLiveData<List<TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList : MutableLiveData<List<WordEntity>>
        get() = _wordList

    fun getData() = viewModelScope.launch(Dispatchers.IO) {

        _textList.postValue(repository.getTextList())
        _wordList.postValue(repository.getWordList())

    }

    fun insertData(text : String) = viewModelScope.launch(Dispatchers.IO) {

        repository.insertTextData(text)
        repository.insertWordData(text)

        getData()

    }

    fun deleteAllData() = viewModelScope.launch(Dispatchers.IO) {

        repository.deleteTextData()
        repository.deleteWordData()

        getData()

    }
}