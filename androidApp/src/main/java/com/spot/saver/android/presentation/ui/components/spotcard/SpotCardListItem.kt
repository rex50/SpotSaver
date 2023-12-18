package com.spot.saver.android.presentation.ui.components.spotcard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.spot.saver.models.ui.SpotDetailUiModel
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews

/**
 * Spot card component
 */
@Composable
fun SpotCardListItem(
    spotDetails: SpotDetailUiModel,
    modifier: Modifier = Modifier,
    onSpotClicked: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                onSpotClicked()
            }
            .padding(
                vertical = 8.dp,
                horizontal = 10.dp
            )
    ) {
        SpotDetailsListItem(
            spotDetails
        )
    }
}

@ThemedComponentPreviews
@Composable
private fun SpotCardContentPreview() {
    Preview {
        SpotCardListItem(
            SpotDetailUiModel(
                id = "deseruisse",
                title = "melius",
                createdDate = "appareat",
                displayLocation = "pretium",
                locationUri = "appareat",
                imageUrl = null,
                totalImages = 6724,
                expiryTime = null,
                labels = listOf()
            )
        ) {

        }
    }
}