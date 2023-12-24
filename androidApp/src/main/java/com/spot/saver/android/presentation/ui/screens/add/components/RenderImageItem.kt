package com.spot.saver.android.presentation.ui.screens.add.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews
import com.spot.saver.android.presentation.ui.screens.add.AddSpotUi

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RenderImageItem() {
    Image(
        painter = painterResource(id = R.drawable.ic_add_media),
        contentDescription = "",
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .combinedClickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(),
                onClick = {

                }
            )
    )
}

@ThemedComponentPreviews
@Composable
private fun PreviewRenderImageItem() {
    Preview {
        RenderImageItem()
    }
}