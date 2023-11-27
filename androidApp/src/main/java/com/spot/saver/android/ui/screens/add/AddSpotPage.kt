package com.spot.saver.android.ui.screens.add

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.spot.saver.android.R
import com.spot.saver.android.ui.components.AppHeader
import com.spot.saver.android.ui.core.Preview
import com.spot.saver.android.ui.core.ThemedComponentPreviews

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

    }

}


@ThemedComponentPreviews
@Composable
fun PreviewAddSpotUi() {
    Preview {
        AddSpotUi()
    }
}
