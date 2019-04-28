package io.androidedu.hoop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.androidedu.hoop.entity.StatusEntity

@Dao
interface StatusDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewStatus(statusEntity: StatusEntity)

    @Delete
    fun deleteStatus(statusEntity: StatusEntity)

    @Query("SELECT * FROM StatusTable")
    fun getAllStatus(): LiveData<List<StatusEntity>>
}