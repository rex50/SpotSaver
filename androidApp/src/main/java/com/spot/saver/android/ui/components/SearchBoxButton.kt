package com.spot.saver.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.theme.SpotSaverColors
import com.spot.saver.android.theme.pacificoFamily
import com.spot.saver.android.ui.core.Preview
import com.spot.saver.android.ui.core.ThemedComponentPreviews
import com.spot.saver.android.ui.screens.home.HomePage

/**
 * Search button component for [HomePage]
 */
@Composable
fun SearchBoxButton(
    modifier: Modifier = Modifier,
    onSearchClicked: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = SpotSaverColors.LightGreyColor,
                shape = CircleShape
            )
            .clip(CircleShape)
            .clickable {
                onSearchClicked()
            }
            .border(
                width = 1.dp,
                color = SpotSaverColors.LightBlueColor,
                shape = CircleShape
            )
            .padding(
                vertical = 10.dp,
                horizontal = 15.dp
            )
    ) {
        // Search icon
        AsyncImage(
            model = R.drawable.ic_search,
            contentDescription = stringResource(R.string.search)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Search text
        Text(
            text = stringResource(R.string.search),
            style = MaterialTheme.typography.bodyLarge.copy(fontFamily = pacificoFamily),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@ThemedComponentPreviews
@Composable
private fun SearchBoxPreview() {
    Preview {
        SearchBoxButton {}
    }
}