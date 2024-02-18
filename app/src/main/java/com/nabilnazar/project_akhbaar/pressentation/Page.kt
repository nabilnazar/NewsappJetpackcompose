package com.nabilnazar.project_akhbaar.pressentation

import androidx.annotation.DrawableRes
import com.nabilnazar.project_akhbaar.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Welcome to Akhbaar Application",
        description = "A Pace where you can get your all news",
        image = R.drawable.img_2
    ),
    Page(
        title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.img_1
    ),
    Page(
        title = "Select your tastes of Interest ",
        description = "",
        image = R.drawable.img
    )
)
