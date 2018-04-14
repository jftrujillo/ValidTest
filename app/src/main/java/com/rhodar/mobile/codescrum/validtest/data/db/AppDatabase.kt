package com.rhodar.mobile.codescrum.validtest.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.rhodar.mobile.codescrum.validtest.data.db.dao.ArtistDao
import com.rhodar.mobile.codescrum.validtest.data.db.dao.TrackDao
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Artist
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Track



@Database(entities = [Artist::class,Track::class], version = 2)
abstract class  AppDatabase : RoomDatabase(){
    abstract fun artistDao() : ArtistDao
    abstract fun TrackDao() : TrackDao

}