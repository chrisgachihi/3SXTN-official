//package com.example.bottom.Database
/*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bottom.Models.Drill
import com.example.bottom.Utilities.DATABASE_NAME


@Database(entities = arrayOf(Drill::class), version = 1, exportSchema = false)
abstract class DrillDatabase : RoomDatabase() {

    abstract fun getDrillDao() : DrillDao

    companion object{

        @Volatile
        private var INSTANCE : DrillDatabase? = null

        fun getDatabase(context : Context) : DrillDatabase{

            return INSTANCE ?: synchronized(this){

            val instance = Room.databaseBuilder(
                context.applicationContext,
                DrillDatabase::class.java,
                DATABASE_NAME
            ).build()

            INSTANCE =instance

            instance
            }
        }
    }
}
 */