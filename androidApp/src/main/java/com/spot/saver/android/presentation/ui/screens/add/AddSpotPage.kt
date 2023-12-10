package com.spot.saver.android.presentation.ui.screens.add

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.presentation.ui.components.AppHeader
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews
import com.spot.saver.android.theme.SpotSaverColors

@Composable
fun AddSpotPage() {

    AddSpotUi()

}

@Composable
fun AddSpotUi() {

    Column {

        AppHeader(
            title = stringResource(id = R.string.new_spot),
            onBackClick = {

            }
        )

        Location()
        Title()
        AddMedia()
    }

}

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

@Composable
fun Title() {
    val text = remember { mutableStateOf("") }
    var isTextFieldFocused by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .focusRequester(focusRequester)
            .onFocusChanged {
                isTextFieldFocused = it.isFocused
            },
        shape = RoundedCornerShape(14.dp),
        value = text.value,
        onValueChange = {
            text.value = it
        },
        placeholder = {
            Text(
                text = "What should we name it?",
                style = MaterialTheme.typography.titleSmall,
                color = SpotSaverColors.EditTextBlueColor,
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = SpotSaverColors.EditTextBlueColor,
            unfocusedBorderColor = SpotSaverColors.EditTextBlueColor,
            cursorColor = SpotSaverColors.LightBlueColor,
            focusedContainerColor = SpotSaverColors.EditTextBgColor,
            unfocusedContainerColor = SpotSaverColors.EditTextBgColor,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    )
}

@Composable
fun Location() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp, vertical = 20.dp),
    ) {

        Text(
            text = stringResource(id = R.string.location),
            style = MaterialTheme.typography.bodyLarge,
            color = SpotSaverColors.LightBlueColor
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.finding_current_location),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )
            MapIcon()
        }

    }
}

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
private fun PreviewAddSpotUi() {
    Preview {
        AddSpotUi()
    }
}
