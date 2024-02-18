package com.nabilnazar.project_akhbaar.pressentation.details.components



//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DetailsTopBar(
//    onBookMarkClick: () -> Unit,
//){
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        "Simple TopAppBar",
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = { /* doSomething() */ }) {
//                        Icon(
//                            imageVector = Icons.Filled.Menu,
//                            contentDescription = "Localized description"
//                        )
//                    }
//                },
//                actions = {
//                    IconButton(onClick = onBookMarkClick) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_bookmark),
//                            contentDescription = null
//                        )
//                    }
//                    IconButton(onClick = onShareClick) {
//                        Icon(
//                            imageVector = Icons.Default.Share,
//                            contentDescription = null
//                        )
//                    }
//                    IconButton(onClick = onBrowsingClick) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_network),
//                            contentDescription = null
//                        )
//                    }
//                }
//            )
//        },
//        content = { innerPadding ->
//            LazyColumn(
//                contentPadding = innerPadding,
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                val list = (0..75).map { it.toString() }
//                items(count = list.size) {
//                    Text(
//                        text = list[it],
//                        style = MaterialTheme.typography.bodyLarge,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 16.dp)
//                    )
//                }
//            }
//        }
//    )
//
//}
//
//@Preview(showBackground = true)
//@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun DetailsTopBarPreview() {
//    ProjectAkhbaarTheme(dynamicColor = false) {
//        DetailsTopBar()
//    }
//}

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.nabilnazar.project_akhbaar.R
import com.nabilnazar.project_akhbaar.ui.theme.ProjectAkhbaarTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBrowsingClick: () -> Unit,
    onShareClick: () -> Unit,
    onBookMarkClick: () -> Unit,
    onBackClick: () -> Unit,
) {

    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body),
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = null,
                )
            }
        },
        actions = {

            IconButton(onClick = onBookMarkClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark),
                    contentDescription = null
                )
            }
            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null
                )
            }
            IconButton(onClick = onBrowsingClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_network),
                    contentDescription = null
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailsTopBarPreview() {
    ProjectAkhbaarTheme(dynamicColor = false) {
        DetailsTopBar(
            onShareClick = { /*TODO*/ },
            onBookMarkClick = { /*TODO*/ },
            onBrowsingClick = {}) {

        }
    }
}
