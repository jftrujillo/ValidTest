package com.rhodar.mobile.codescrum.validtest.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.rhodar.mobile.codescrum.validtest.data.db.entities.Artist
import io.reactivex.Flowable

@Dao
interface ArtistDao : BaseDao<Artist> {

    @Query("SELECT * FROM artist ")
    fun getAll(): Flowable<Artist>

}