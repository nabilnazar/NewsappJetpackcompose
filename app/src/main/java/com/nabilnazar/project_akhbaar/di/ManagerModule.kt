package com.nabilnazar.project_akhbaar.di


import com.nabilnazar.project_akhbaar.data.manager.LocalUserManagerImpl
import com.nabilnazar.project_akhbaar.domain.manager.LocalUserManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MangerModule {

    @Binds
    @Singleton
    abstract fun bindLocalUserManger(localUserManagerImpl: LocalUserManagerImpl) : LocalUserManager
}