package com.spot.saver.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.ui.core.Preview
import com.spot.saver.android.ui.core.ThemedComponentPreviews

/**
 * Header of the saved components
 */
@Composable
fun SavedSpotsHeader(
    savedSpotsSize: Int,
    sortedBy: String,
    modifier: Modifier = Modifier,
    onSortClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Saved spots count
        Text(
            text = stringResource(R.string.saved_spots, savedSpotsSize),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )

        // Sorting option
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    onSortClicked()
                }
        ) {
            Text(
                text = stringResource(R.string.sorted_by) + " ",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = sortedBy,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.width(6.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = stringResource(R.string.sorted_by),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@ThemedComponentPreviews
@Composable
fun SavedSpotsHeaderPreview() {
    Preview(modifier = Modifier.fillMaxWidth()) {
        SavedSpotsHeader(
            savedSpotsSize = 10,
            sortedBy = "Expiring date",
            modifier = Modifier.fillMaxWidth()
        ) {

        }
    }
}