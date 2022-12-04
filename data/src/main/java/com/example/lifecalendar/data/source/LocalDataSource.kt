package com.example.lifecalendar.data.source

import com.example.lifecalendar.data.source.local.db.dao.NodeDao
import com.example.lifecalendar.data.source.local.db.model.NodeEntity

class LocalDataSource(private val nodeDao: NodeDao) {
    fun addYearNodeItem(nodeEntity: NodeEntity) {
        nodeDao.addYearNodeItem(nodeEntity)
    }
    
    fun updateYearNodeItem(nodeEntity: NodeEntity) {
        nodeDao.updateYearNodeItem(nodeEntity)
    }
    
    fun readNodesByYear(selectedYear: Int) = nodeDao.readNodesByYear(selectedYear)
    
    fun fetchNodeById(id: Int): NodeEntity = nodeDao.fetchNodeById(id)
    
    fun deleteNode(nodeEntity: NodeEntity) {
        nodeDao.deleteNode(nodeEntity)
    }
}