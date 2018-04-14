package com.rhodar.mobile.codescrum.validtest.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "track")
data class Track(
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "duration")
        val duration : String,
        @ColumnInfo(name = "listeners")
        val listeners : Long,
        @ColumnInfo(name = "track_url")
        val trackUrl : String?,
        @ColumnInfo(name = "artist")
        val artist : String,
        @ColumnInfo(name = "image_url")
        val imageUrl : String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
