package com.spot.saver.android.presentation.ui.components.spotcard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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
    onSpotClicked: () -> Unit,
    onNavigateClicked: () -> Unit
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
        val (details, image, btnNavigate) = createRefs()
        SpotDetailsListItem(
            spotDetails,
            modifier = Modifier
                .constrainAs(details) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(image.start, margin = 12.dp)
                    width = Dimension.fillToConstraints
                }
        )

        SpotImage(
            image = spotDetails.imageUrl ?: "",
            totalImages = spotDetails.totalImages,
            modifier = Modifier
                .height(70.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    end.linkTo(btnNavigate.start, margin = 12.dp)
                    bottom.linkTo(parent.bottom)
                }
        )

        NavigationButton(
            modifier = Modifier
                .width(65.dp)
                .constrainAs(btnNavigate) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                },
            onNavigateClicked = onNavigateClicked
        )
    }
}

@ThemedComponentPreviews
@Composable
private fun SpotCardContentPreview() {
    Preview {
        SpotCardListItem(
            spotDetails = SpotDetailUiModel(
                id = "deseruisse",
                title = "melius",
                createdDate = "appareat",
                displayLocation = "pretium",
                locationUri = "appareat",
                imageUrl = "https:google.com",
                totalImages = 10,
                expiryTime = null,
                labels = listOf()
            ),
            onSpotClicked = {},
            onNavigateClicked = {}
        )
    }
}