package com.spot.saver.android.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews

/**
 * Profile image component
 * @param profileImage can be any (e.g. resourceId, uri, url, null)
 */
@Composable
fun ProfileImage(
    modifier: Modifier = Modifier,
    profileImage: Any?,
    onProfileClicked: () -> Unit
) {
    AsyncImage(
        model = profileImage,
        contentDescription = stringResource(R.string.profile),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .clickable {
                onProfileClicked()
            }
    )
}

@ThemedComponentPreviews
@Composable
private fun ProfileImagePreview() {
    Preview {
        ProfileImage(profileImage = R.drawable.test_image) {

        }
    }
}