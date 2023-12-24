package com.spot.saver.android.presentation.ui.components.spotcard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.spot.saver.view.model.SpotDetailUiModel
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews
import com.spot.saver.android.theme.SpotSaverColors

/**
 * Details displayed in a spot card description
 */
@Composable
fun SpotDetailsListItem(
    spotDetailUiModel: SpotDetailUiModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = spotDetailUiModel.title,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Normal
                    )
                )  {
                    append("Spotted on ")
                    // expecting in "5th feb" format
                    append(spotDetailUiModel.createdDate)
                }
                append(" at ")
                // expecting "City, State" format
                append(spotDetailUiModel.displayLocation)
            },
            modifier = Modifier.padding(vertical = 4.dp),
            style = MaterialTheme.typography.labelSmall,
            color = SpotSaverColors.OuterSpaceColor
        )

        Spacer(modifier = Modifier.height(4.dp))

        SpotLabelsRow(spotDetailUiModel.labels)
    }
}



@ThemedComponentPreviews
@Composable
private fun ItemSpotCardDetailsUIPreview() {
    Preview {
        SpotDetailsListItem(
            SpotDetailUiModel(
                id = "quod",
                title = "sonet",
                createdDate = "senserit",
                displayLocation = "dicat",
                locationUri = "nascetur",
                imageUrl = null,
                totalImages = 1228,
                expiryTime = null,
                labels = listOf()
            )
        )
    }
}