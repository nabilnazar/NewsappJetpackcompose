package com.nabilnazar.project_akhbaar.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>

}