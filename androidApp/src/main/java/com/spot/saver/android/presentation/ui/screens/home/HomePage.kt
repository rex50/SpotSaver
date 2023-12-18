package com.spot.saver.android.presentation.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.presentation.ui.components.SavedSpotsHeader
import com.spot.saver.android.presentation.ui.components.spotcard.SpotCardListItem
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedDevicePreviews
import com.spot.saver.android.presentation.ui.screens.home.components.AddNewSpotButton
import com.spot.saver.android.presentation.ui.screens.home.components.HeaderHome
import com.spot.saver.viewmodel.HomePageViewModel

/**
 * Home page
 */
@Composable
fun HomePage() {

    // TODO: inject viewModel via Koin
    val viewModel = remember {
        HomePageViewModel()
    }

    val mySpots by viewModel.savedSpots.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchMySpots()
    }

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
                .padding(horizontal = 20.dp)
        ) {

            item {
                AddNewSpotButton(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                ) {}
            }

            item {
                SavedSpotsHeader(
                    savedSpotsSize = 10,
                    sortedBy = "Expiring date",
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                ) {
                    // TODO: handle sort button click event
                }
            }

            items(mySpots) { spot ->
                SpotCardListItem(
                    spotDetails = spot
                ) {
                    // TODO: Handle spot click event
                }
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