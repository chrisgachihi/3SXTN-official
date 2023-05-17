//package com.example.bottom.Database
/*


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bottom.Models.Drill


@Dao
interface DrillDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(drill: Drill)

    @Delete
    suspend fun delete(drill: Drill)

    @Query("SELECT * FROM drills_table ORDER BY id ASC")
    fun getAllDrills(): LiveData<List<Drill>>

    @Query("UPDATE drills_table SET title = :title, drill = :drill WHERE id = :id")
    suspend fun update(id: Int?, title: String?, drill: String?)
}
*/