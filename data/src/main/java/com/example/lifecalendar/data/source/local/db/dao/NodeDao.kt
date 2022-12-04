package com.example.lifecalendar.data.source.local.db.dao

import androidx.room.*
import com.example.lifecalendar.data.source.local.db.model.NodeEntity

@Dao
interface NodeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addYearNodeItem(nodeEntity: NodeEntity)
    
    @Update
    fun updateYearNodeItem(nodeEntity: NodeEntity)
    
    @Query("SELECT * FROM NodeEntity WHERE year = :selectedYear")
    fun readNodesByYear(selectedYear: Int): List<NodeEntity>
    
    @Query("SELECT * FROM NodeEntity WHERE id = :id LIMIT 1")
    fun fetchNodeById(id: Int): NodeEntity
    
    @Delete
    fun deleteNode(nodeEntity: NodeEntity)
}