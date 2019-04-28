package io.androidedu.hoop.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StatusTable")
data class StatusEntity(
        @PrimaryKey(autoGenerate = true) @NonNull
        val _id: Long = 0,

        @ColumnInfo(name = "userName")
        val userName: String,

        @ColumnInfo(name = "statusDate")
        val statusDate: String,

        @ColumnInfo(name = "statusTime")
        val statusTime: String,

        @ColumnInfo(name = "profilePhoto")
        val profilePhoto: Int
)