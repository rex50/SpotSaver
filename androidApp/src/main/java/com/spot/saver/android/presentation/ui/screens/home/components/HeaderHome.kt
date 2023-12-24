package com.spot.saver.android.presentation.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.spot.saver.android.R
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews
import com.spot.saver.android.presentation.ui.components.ProfileImage
import com.spot.saver.android.presentation.ui.components.SearchBoxButton

/**
 * Header component for [HomePage]
 */
@Composable
fun HeaderHome(
    modifier: Modifier = Modifier,
    profilePicture: Any? = null,
    onSearchClicked: () -> Unit,
    onProfileClicked: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SearchBoxButton(onSearchClicked = onSearchClicked)

        ProfileImage(
            profileImage = profilePicture,
            onProfileClicked = onProfileClicked
        )
    }
}

@ThemedComponentPreviews
@Composable
private fun HeaderHomePreview() {
    Preview {
        HeaderHome(
            profilePicture = R.drawable.test_image,
            onProfileClicked = {},
            onSearchClicked = {}
        )
    }
}