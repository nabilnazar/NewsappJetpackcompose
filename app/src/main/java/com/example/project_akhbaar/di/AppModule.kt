package com.example.project_akhbaar.di

import android.app.Application
import com.example.project_akhbaar.data.manager.LocalUserManagerImpl
import com.example.project_akhbaar.data.network.NewsApi
import com.example.project_akhbaar.data.repository.NewsRepositoryImpl
import com.example.project_akhbaar.domain.manager.LocalUserManager
import com.example.project_akhbaar.domain.usecases.app_entry.AppEntryUseCases
import com.example.project_akhbaar.domain.usecases.app_entry.ReadAppEntry
import com.example.project_akhbaar.domain.usecases.app_entry.SaveAppEntry
import com.example.project_akhbaar.domain.usecases.news.GetNews
import com.example.project_akhbaar.domain.usecases.news.NewsUseCases
import com.example.project_akhbaar.domain.repository.NewsRepository
import com.example.project_akhbaar.domain.usecases.news.SearchNews
import com.example.project_akhbaar.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }

}