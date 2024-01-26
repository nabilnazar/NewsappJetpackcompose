package com.example.project_akhbaar.data.network

import com.example.project_akhbaar.data.network.dto.NewsCategoryResponse
import com.example.project_akhbaar.data.network.dto.NewsResponse
import com.example.project_akhbaar.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query
interface NewsApi {

        @GET("everything")
        suspend fun getNews(
            @Query("sources") sources: String,
            @Query("page") page: Int,
            @Query("apiKey") apiKey: String = API_KEY
        ): NewsResponse

        @GET("top-headlines/sources")
        suspend fun getNewsByCategories(
            @Query("category") categories: List<String>,
            @Query("page") page: Int,
            @Query("apiKey") apiKey: String = API_KEY
        ): NewsCategoryResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse


}