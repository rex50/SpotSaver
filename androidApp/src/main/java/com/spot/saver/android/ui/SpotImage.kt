package com.spot.saver.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.spot.saver.android.R
import com.spot.saver.android.SpotSaverTheme
import com.spot.saver.android.theme.SpotSaverColors

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SpotImage(
    url: String,
    imageCount: Int,
    fontCardHeightAndWidth: Int,
    rotateBackCard: Float = -20f,
    modifier: Modifier
) {
    // I maintain consistent ratios for mockups across various sizes.
    val ratio = fontCardHeightAndWidth / 10

    // here base image count we are hiding (background rotate card).
    if (imageCount>1){
        // background rotate card
        Box(modifier = modifier
            .height((fontCardHeightAndWidth - ratio).dp)
            .width((fontCardHeightAndWidth - ratio).dp)
            .rotate(rotateBackCard)
            .clip(RoundedCornerShape((ratio + 2).dp))
            .background(Color.Gray),
        )
    }

    // Front card
    Box(
        Modifier
            .padding(start = (ratio + 6).dp)
            .height(fontCardHeightAndWidth.dp)
            .width(fontCardHeightAndWidth.dp)
            .clip(RoundedCornerShape((ratio + 2).dp)),
        contentAlignment = Alignment.Center
    ) {
        //  here load image on (Front card).
        GlideImage(
            modifier = Modifier.fillMaxSize(),
            model = R.drawable.test_image,
            contentDescription = "",
            failure = placeholder(R.drawable.alien),
            contentScale = ContentScale.Crop
        )

        //here base image count we are hiding (transparent effect in image) & (images count text).
        if (imageCount > 1){
            // This used for transparent effect in image.
            Spacer(
                modifier = Modifier.fillMaxSize().background(SpotSaverColors.LightGreyColor)
            )
            // this used for showing images count text.
            Text(modifier = Modifier.fillMaxWidth(), text = "+${imageCount-1}", textAlign = TextAlign.Center,fontSize = (ratio+ratio+ratio-2).sp, color = Color.White)
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun DefaultPreview() {
    SpotSaverTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(Modifier
                .fillMaxSize()
                .padding(start = 40.dp, top = 100.dp)) {
                SpotImage(
                    "https://images.unsplash.com/photo-1694457269860-b7926c29e008?auto=format&fit=crop&q=80&w=3090&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                    1,
                    100,
                    modifier = Modifier
                )
            }
        }
    }
}
