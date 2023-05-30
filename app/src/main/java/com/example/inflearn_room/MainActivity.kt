package com.example.inflearn_room

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inflearn_room.adapter.TextAdapter
import com.example.inflearn_room.databinding.ActivityMainBinding
import com.example.inflearn_room.db.TextDatabase
import com.example.inflearn_room.entity.TextEntity
import com.example.inflearn_room.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val TAG = this::class.java.simpleName

    lateinit var textEntity: TextEntity
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel : MainActivityViewModel by viewModels()

        viewModel.getData()

        val etInput = binding.etInput
        val btnInsert = binding.btnInsert
        val btnGetData = binding.btnGetData
        val btnDelete = binding.btnDelete
        val rvText = binding.rvText

        viewModel.textList.observe(this, Observer {textEntityList ->
            val textAdapter = TextAdapter(textEntityList)
            rvText.adapter = textAdapter
            rvText.layoutManager = LinearLayoutManager(this)
        })

        btnInsert.setOnClickListener {

            viewModel.insertData(etInput.text.toString())

            etInput.setText("")

        }

        btnGetData.setOnClickListener {

            viewModel.getData()

        }

        btnDelete.setOnClickListener {

           viewModel.deleteAllData()

        }

    }
}