package com.idn.myalarmapp.fragment.room

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database (
    entities = [Alarm::class],
    version = 2
)

abstract class AlarmDB : RoomDatabase() {
    abstract fun alarmDao(): AlarmDao

    companion object {
        @Volatile
        private var instance: AlarmDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AlarmDB::class.java, "alarm12345.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}