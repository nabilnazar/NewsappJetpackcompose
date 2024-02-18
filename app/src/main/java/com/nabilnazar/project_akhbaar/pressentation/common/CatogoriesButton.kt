package com.nabilnazar.project_akhbaar.pressentation.common


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.nabilnazar.project_akhbaar.pressentation.ClickableGlowingCard
import kotlin.random.Random

@Composable
fun CategoriesButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    isSelected: Boolean,
) {

    val glowingColor = remember {
        Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
            alpha = 0.5f
        )
    }

    val oppositeColor = remember {
        ColorUtils.blendARGB(glowingColor.toArgb(), Color.Black.toArgb(), 0.5f)
        // You can adjust the blending factor (0.5f in this case) based on your preference
    }

    ClickableGlowingCard(
        glowingColor = glowingColor,
        modifier = modifier, containerColor = Color(oppositeColor.red, oppositeColor.green, oppositeColor.blue),
        cornersRadius = 5.dp,
    )
    {
        Box(modifier=Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
            ) {


            Button(
                modifier = Modifier
                    .width(144.dp),
                onClick = onClick,
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = if(isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onTertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.inverseOnSurface
                ),
                shape = RoundedCornerShape(size = 5.dp)
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                )
            }
        }
    }
}

