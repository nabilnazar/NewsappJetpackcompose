package com.nabilnazar.project_akhbaar.domain.usecases.app_entry

import com.nabilnazar.project_akhbaar.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }

}
