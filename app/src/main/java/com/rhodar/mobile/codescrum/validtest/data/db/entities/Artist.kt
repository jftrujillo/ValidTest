package com.rhodar.mobile.codescrum.validtest.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "artist")
data class Artist(
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "listeners")
        val listeners : Long,
        @ColumnInfo(name = "url")
        val artistUrl : String,
        @ColumnInfo(name = "img_url")
        val imageUrl : String?
){
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}

