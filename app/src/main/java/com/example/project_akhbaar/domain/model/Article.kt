package com.example.project_akhbaar.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,   // in databases we can only save primitive data types so we need to create type converters fot this object refer data/local package for type converters
    val title: String,
    @PrimaryKey
    val url: String,
    val urlToImage: String
)
