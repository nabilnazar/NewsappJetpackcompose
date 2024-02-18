package com.example.project_akhbaar.di

import android.app.Application
import android.health.connect.datatypes.AppInfo
import androidx.room.Dao
import androidx.room.Room
import com.example.project_akhbaar.data.local.NewsDao
import com.example.project_akhbaar.data.local.NewsDatabase
import com.example.project_akhbaar.data.local.NewsTypeConvertor
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
import com.example.project_akhbaar.domain.usecases.news.DeleteArticle
import com.example.project_akhbaar.domain.usecases.news.GetArticles
import com.example.project_akhbaar.domain.usecases.news.SearchNews
import com.example.project_akhbaar.domain.usecases.news.UpsertArticle
import com.example.project_akhbaar.util.Constants.BASE_URL
import com.example.project_akhbaar.util.Constants.NEWS_DATABASE_NAME
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
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            deleteArticle = DeleteArticle(newsDao),
            getArticles = GetArticles(newsDao),
            upsertArticle = UpsertArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ):NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        database: NewsDatabase
    ):NewsDao{
        return database.newsDao
    }



}