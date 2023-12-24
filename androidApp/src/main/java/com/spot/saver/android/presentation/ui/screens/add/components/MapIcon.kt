package com.spot.saver.android.presentation.ui.screens.add.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews
import com.spot.saver.android.presentation.ui.screens.add.AddSpotUi

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MapIcon() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primary)
            .combinedClickable(
                indication = rememberRipple(),
                interactionSource = remember { MutableInteractionSource() },
                enabled = true,
                onClick = {

                }
            )
            .padding(vertical = 8.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_map_marker),
            contentDescription = stringResource(R.string.edit_marker),
            tint = Color.White
        )

        Text(
            text = stringResource(id = R.string.map),
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )

    }
}

@ThemedComponentPreviews
@Composable
private fun PreviewMapIcon() {
    Preview {
        MapIcon()
    }
}