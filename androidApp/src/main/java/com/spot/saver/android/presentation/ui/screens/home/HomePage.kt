package com.spot.saver.android.presentation.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedDevicePreviews
import com.spot.saver.android.presentation.ui.components.SavedSpotsHeader
import com.spot.saver.android.presentation.ui.components.SpotCardContent
import com.spot.saver.android.presentation.ui.screens.home.components.AddNewSpotButton
import com.spot.saver.android.presentation.ui.screens.home.components.HeaderHome

/**
 * Home page
 */
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

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 8.dp
                )
        ) {

            item {
                AddNewSpotButton(
                    modifier = Modifier
                        .padding(
                            bottom = 8.dp
                        )
                ) {}
            }

            item {
                SavedSpotsHeader(
                    savedSpotsSize = 10,
                    sortedBy = "Expiring date",
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                ) {}
            }

            items(10) {
                SpotCardContent()
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@ThemedDevicePreviews
@Composable
private fun HomePagePreview() {
    Preview {
        HomePage()
    }
}