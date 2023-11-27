package com.spot.saver.android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.spot.saver.android.R
import com.spot.saver.android.theme.SpotSaverColors
import com.spot.saver.android.theme.pacificoFamily
import com.spot.saver.android.ui.core.Preview
import com.spot.saver.android.ui.core.ThemedComponentPreviews

@Composable
fun AppHeader(
    title: String,
    onBackClick: (() -> Unit)? = null
) {

    Column {
        AppName()
        AppTitle(title,onBackClick)
    }
}

@Composable
fun AppName() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        text = stringResource(id = R.string.app_name),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge.copy(fontFamily = pacificoFamily),
        color = MaterialTheme.colorScheme.primary,
    )
}

@Composable
fun AppTitle(title: String, onBackClick: (() -> Unit)?) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (onBackClick != null) {
            IconButton(
                onClick = {
                    onBackClick.invoke()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = "back arrow",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }else {
            Spacer(modifier = Modifier.size(10.dp))
        }
        Text(
            modifier = Modifier
                .wrapContentSize(),
            text = title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
@ThemedComponentPreviews
fun PreviewAppTitle() {

    Preview {
        AppHeader(
            stringResource(id = R.string.new_spot),
            onBackClick = {}
        )
    }

}


