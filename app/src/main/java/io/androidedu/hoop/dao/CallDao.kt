package io.androidedu.hoop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.androidedu.hoop.entity.CallEntity

@Dao
interface CallDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addnewCall(callEntity: CallEntity)

    @Delete
    fun removeItem(callEntity: CallEntity)

    @Query("SELECT * FROM CallTable")
    fun getAllCalls(): LiveData<List<CallEntity>>
}