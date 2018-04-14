package com.rhodar.mobile.codescrum.validtest.data.db.dao

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update

interface BaseDao<in T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg obj: T): List<Long>

    @Update()
    fun update(vararg obj: T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWithIgnore(obj: T): Long
}