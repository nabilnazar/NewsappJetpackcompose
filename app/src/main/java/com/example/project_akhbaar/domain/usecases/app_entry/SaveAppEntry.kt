package com.example.project_akhbaar.domain.usecases.app_entry

import com.example.project_akhbaar.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManger: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}
