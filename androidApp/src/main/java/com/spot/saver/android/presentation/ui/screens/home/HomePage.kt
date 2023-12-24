package com.spot.saver.android.presentation.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.presentation.ui.components.SavedSpotsHeader
import com.spot.saver.android.presentation.ui.components.spotcard.SpotCardListItem
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedDevicePreviews
import com.spot.saver.android.presentation.ui.screens.home.components.AddNewSpotButton
import com.spot.saver.android.presentation.ui.screens.home.components.HeaderHome
import com.spot.saver.android.presentation.utils.koinViewModel
import com.spot.saver.view.viewmodel.HomePageViewModel

/**
 * Home page
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(
    viewModel: HomePageViewModel
) {

    LaunchedEffect(Unit) {
        viewModel.fetchMySpots()
    }

    val state by viewModel.state.collectAsState()

    val lazyListState = rememberLazyListState()

    val elevateSavedSpotsHeader by remember {
        derivedStateOf { lazyListState.firstVisibleItemIndex >= 1 }
    }

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
            onProfileClicked = {
                // TODO: handle profile click event
            },
            onSearchClicked = {
                // TODO: handle search button click event
            }
        )

        LazyColumn(
            state = lazyListState,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            item {
                AddNewSpotButton(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .padding(horizontal = 20.dp)
                ) {
                    // TODO: handle add new button click event
                }
            }

            stickyHeader {
                SavedSpotsHeader(
                    savedSpotsSize = state.savedSpots.size,
                    sortedBy = "Expiring date",
                    modifier = Modifier
                        .then(if (elevateSavedSpotsHeader) Modifier.shadow(8.dp) else Modifier)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(horizontal = 20.dp)
                        .padding(vertical = 12.dp)
                ) {
                    // TODO: handle sort button click event
                }

                if(state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(32.dp)
                            .width(24.dp),
                        color = MaterialTheme.colorScheme.tertiary,
                        trackColor = MaterialTheme.colorScheme.primary,
                    )
                }
            }

            items(state.savedSpots) { spot ->
                SpotCardListItem(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    spotDetails = spot,
                    onSpotClicked = {
                        // TODO: handle spot click event
                    },
                    onNavigateClicked = {
                        // TODO: handle spot navigate button click event
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@ThemedDevicePreviews
@Composable
private fun HomePagePreview() {
    Preview {
        HomePage(koinViewModel())
    }
}
