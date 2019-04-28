package io.androidedu.hoop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.androidedu.hoop.entity.ChatEntity

@Dao
interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewChat(chatEntity: ChatEntity)

    @Delete
    fun deleteChat(chatEntity: ChatEntity)

    @Query("SELECT * FROM ChatTable")
    fun getAllChats(): LiveData<List<ChatEntity>>
}