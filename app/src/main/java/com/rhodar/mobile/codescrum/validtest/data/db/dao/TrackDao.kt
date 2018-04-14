package com.rhodar.mobile.codescrum.validtest.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Artist
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Track
import io.reactivex.Flowable

@Dao
interface TrackDao : BaseDao<Track> {
    @Query("SELECT * FROM track")
    fun getAll() : Flowable<Track>
}