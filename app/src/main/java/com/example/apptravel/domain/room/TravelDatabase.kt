package com.example.apptravel.domain.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Travel::class], version = 1, exportSchema = false)
abstract class TravelDatabase : RoomDatabase() {



    abstract fun travelDao(): TravelDAO

    companion object {
        private var instance: TravelDatabase? = null

        fun getTravelDatabase(context: Context): TravelDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    TravelDatabase::class.java,
                    "travel.db"
                ).allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}