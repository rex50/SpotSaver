package com.spot.saver.android.presentation.ui.screens.add.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews

@Composable
fun AddMedia() {
    LazyRow(
        modifier = Modifier.padding(horizontal = 35.dp, vertical = 10.dp),
        state = rememberLazyListState()
    ) {

        item {
            RenderImageItem()
        }

    }
}


@ThemedComponentPreviews
@Composable
private fun PreviewAddMedia() {
    Preview {
        AddMedia()
    }
}