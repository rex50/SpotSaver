package com.spot.saver.android.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.ui.core.Preview
import com.spot.saver.android.ui.core.ThemedDevicePreviews
import com.spot.saver.android.ui.screens.home.components.AddNewSpotButton
import com.spot.saver.android.ui.screens.home.components.HeaderHome

@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderHome(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            profilePicture = R.drawable.test_image,
            onProfileClicked = {},
            onSearchClicked = {}
        )

        AddNewSpotButton(
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 8.dp
                )
        ) {}
    }
}

@ThemedDevicePreviews
@Composable
private fun HomePagePreview() {
    Preview {
        HomePage()
    }
}