package com.example.apptravel.domain.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TravelDAO {

    @Insert
    fun insert(travel: Travel)

    @Delete
    fun delete(travel: Travel)

    @Query("SELECT*FROM travel")
    fun getAllTravel(): List<Travel>
}