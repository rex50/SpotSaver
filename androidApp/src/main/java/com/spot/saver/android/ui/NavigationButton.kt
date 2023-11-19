package com.spot.saver.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spot.saver.android.MyApplicationTheme
import com.spot.saver.android.R
import com.spot.saver.android.theme.ActionColor

@Composable
fun NavigationButton(
    modifier: Modifier
) {
    Box(
        modifier = modifier.background(
            ActionColor,
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp,
                bottomStart = 10.dp,
                bottomEnd = 10.dp
            )
        ), contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_navigation),
            tint = Color.White,
            contentDescription = null,
            modifier = Modifier
                .height(19.dp)
                .width(19.dp)
        )
    }

}

@Composable
@ThemedComponentPreviews
fun NavigationButtonPreview() {
    Preview {
        NavigationButton(
            modifier = Modifier
                .height(62.dp)
                .width(61.dp)
        )
    }
}