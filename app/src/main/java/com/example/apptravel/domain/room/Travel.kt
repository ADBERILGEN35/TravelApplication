package com.example.apptravel.domain.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "travel")
data class Travel(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "travelId")
    var travelId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "country")
    var country: String,

    @ColumnInfo(name = "city")
    var city: String,

    @ColumnInfo(name = "travelImages")
    var travelImages: String,

    @ColumnInfo(name = "travelBookmark")
    var travelBookmark: Boolean,

    @ColumnInfo(name = "days")
    var days: String,


    )
