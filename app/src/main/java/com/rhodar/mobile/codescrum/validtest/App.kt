package com.rhodar.mobile.codescrum.validtest

import android.app.Application
import android.arch.persistence.room.Room
import com.rhodar.mobile.codescrum.validtest.data.db.AppDatabase

class App : Application() {

    companion object {
        lateinit var db : AppDatabase
        val DB_NAME = "ValidTest.db"
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this,AppDatabase::class.java, DB_NAME).build()
    }
}