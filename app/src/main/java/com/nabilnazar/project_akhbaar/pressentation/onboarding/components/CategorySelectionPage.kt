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
import com.nabilnazar.project_akhbaar.R
import com.nabilnazar.project_akhbaar.pressentation.Dimens
import com.nabilnazar.project_akhbaar.pressentation.Dimens.MediumPadding2
import com.nabilnazar.project_akhbaar.pressentation.common.CategoriesButton


@Composable
fun CategorySelectionPage() {
    // Define a list of available categories
    val categories = listOf(
        "Entertainment",
        "Technology",
        "General",
        "Health",
        "Science",
        "Sports",
        "Business"
    )

    // State to keep track of selected categories
    val selectedCategories = remember { mutableStateListOf<String>() }
   // Log.d("NABIL", selectedCategories.toList().toString())

    Column(
        modifier = Modifier.height(600.dp)
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

        LazyVerticalGrid(
             columns = GridCells.Fixed(2),
            // Adjust the number of columns as needed
        ) {
            items(categories) { category ->
                // Use lowercase for network calls (better to use an enum as suggested earlier)

                // Round button for each category
                CategoryButton(
                    text = category,
                    isSelected = category in selectedCategories,
                    onClick = {
                        if (category in selectedCategories) {
                            selectedCategories.remove(category)
                        } else {
                            selectedCategories.add(category)
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
            .height(48.dp).width(150.dp),
        onClick = onClick,
        isSelected = isSelected
    )
}
