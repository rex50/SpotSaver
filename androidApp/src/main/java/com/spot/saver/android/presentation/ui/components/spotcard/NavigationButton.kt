package com.spot.saver.android.presentation.ui.components.spotcard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews

/**
 * Spot card navigation button
 */
@Composable
fun NavigationButton(
    modifier: Modifier = Modifier,
    onNavigateClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                )
            )
            .background(
                color = MaterialTheme.colorScheme.primary
            )
            .clickable {
                onNavigateClicked()
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_navigation),
            tint = Color.White,
            contentDescription = null,
            modifier = Modifier
                .height(19.dp)
                .width(19.dp)
        )
    }

}

@Composable
@ThemedComponentPreviews
fun NavigationButtonPreview() {
    Preview {
        NavigationButton(
            modifier = Modifier
                .height(62.dp)
                .width(61.dp)
        ) {

        }
    }
}