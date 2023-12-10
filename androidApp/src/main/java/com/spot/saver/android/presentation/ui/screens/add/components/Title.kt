package com.spot.saver.android.presentation.ui.screens.add.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews
import com.spot.saver.android.presentation.ui.screens.add.AddSpotUi
import com.spot.saver.android.theme.SpotSaverColors

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

@ThemedComponentPreviews
@Composable
private fun PreviewTitle() {
    Preview {
        Title()
    }
}