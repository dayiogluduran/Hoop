package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.CallDao
import io.androidedu.hoop.dao.ChatDao
import io.androidedu.hoop.dao.StatusDao
import io.androidedu.hoop.entity.CallEntity
import io.androidedu.hoop.entity.ChatEntity
import io.androidedu.hoop.entity.StatusEntity

@Database(entities = [CallEntity::class, ChatEntity::class, StatusEntity::class], version = 1)
abstract class HoopDb : RoomDatabase() {
    abstract fun getCallDao(): CallDao
    abstract fun getChatDao(): ChatDao
    abstract fun getStatusDao(): StatusDao

    companion object {
        private var INSTANCE: HoopDb? = null
        fun getInstance(context: Context): HoopDb? {
            if (INSTANCE == null) {
                synchronized(HoopDb::class) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            HoopDb::class.java, "hoop_db"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }
    }
}