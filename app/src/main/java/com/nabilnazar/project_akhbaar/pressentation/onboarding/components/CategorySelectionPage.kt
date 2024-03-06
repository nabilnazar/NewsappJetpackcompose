package com.nabilnazar.project_akhbaar.pressentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nabilnazar.project_akhbaar.R
import com.nabilnazar.project_akhbaar.pressentation.Dimens
import com.nabilnazar.project_akhbaar.pressentation.Dimens.MediumPadding2
import com.nabilnazar.project_akhbaar.pressentation.common.CategoriesButton


@Composable
fun CategorySelectionPage(
    sharedViewModel: SharedViewModel = viewModel()) {
    // Define a list of available categories
    val sources = listOf(
        "bbc-news",
        "abc-news",
        "al-jazeera-english",
        "hacker-news",
        "new-scientist",
        "newsweek",
        "techradar",
        "reddit-r-all"

    )

    Column(
        modifier = Modifier
            .height(600.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.40f),
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(Dimens.IndicatorSize))
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = "Select Your Taste Of Interest",
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(sources) { category ->
                // Dynamically determine if the category is selected
                val isSelected = category in sharedViewModel.selectedSources

                CategoryButton(
                    text = category,
                    isSelected = isSelected,  // Pass the dynamic state
                    onClick = {
                        if (isSelected) {
                            sharedViewModel.removeSource(category)
                        } else {
                            sharedViewModel.addSources(category)
                        }
                    }
                )
            }
        }

    }
}

@Composable
fun CategoryButton(text: String, onClick: () -> Unit, isSelected: Boolean) {

    CategoriesButton(
        text = text,
        modifier = Modifier
            .padding(8.dp)
            .height(48.dp)
            .width(150.dp),
        onClick = onClick,
        isSelected = isSelected
    )
}
