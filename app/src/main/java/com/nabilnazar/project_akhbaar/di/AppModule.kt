package com.nabilnazar.project_akhbaar.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.nabilnazar.project_akhbaar.data.local.NewsDao
import com.nabilnazar.project_akhbaar.data.local.NewsDatabase
import com.nabilnazar.project_akhbaar.data.local.NewsTypeConvertor
import com.nabilnazar.project_akhbaar.data.network.NewsApi
import com.nabilnazar.project_akhbaar.util.Constants.BASE_URL
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
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao


    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

}