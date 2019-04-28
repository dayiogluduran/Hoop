package io.androidedu.hoop.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CallTable")
data class CallEntity(
        @PrimaryKey(autoGenerate = true) @NonNull
        val id: Int = 0,

        @ColumnInfo(name = "userName")
        val userName: String,

        @ColumnInfo(name = "callDate")
        val callDate: String,

        @ColumnInfo(name = "callTime")
        val callTime: String,

        @ColumnInfo(name = "profilePhoto")
        val profilePhoto: Int,

        @ColumnInfo(name = "callIcon")
        val callIcon: Int
)