package com.example.lifecalendar.data.source

import com.example.lifecalendar.data.source.local.db.dao.BirthdateDao
import com.example.lifecalendar.data.source.local.db.model.BirthdateEntity

class LocalDataSource(private val birthdateDao: BirthdateDao) {
    fun addBirthdateItem(birthdateEntity: BirthdateEntity) {
        birthdateDao.addBirthdateItem(birthdateEntity)
    }
    
    fun updateBirthdateItem(birthdateEntity: BirthdateEntity) {
        birthdateDao.updateBirthdateItem(birthdateEntity)
    }
    
    fun readBirthdate(): BirthdateEntity = birthdateDao.readBirthdate()
}