package com.example.inflearn_room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.inflearn_room.entity.TextEntity
import com.example.inflearn_room.entity.WordEntity

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table")
    fun getAllData(): List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: WordEntity)

    @Query("DELETE FROM word_table")
    fun deleteAllData()

}