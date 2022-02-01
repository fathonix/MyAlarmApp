package com.idn.myalarmapp.fragment.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alarm(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val time: String,
    val date: String,
    val note: String,
    val type: Int
)