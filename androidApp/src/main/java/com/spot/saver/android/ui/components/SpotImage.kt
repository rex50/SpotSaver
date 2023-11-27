package com.spot.saver.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spot.saver.android.R
import com.spot.saver.android.theme.SpotSaverColors
import com.spot.saver.android.ui.core.Preview
import com.spot.saver.android.ui.core.ThemedComponentPreviews

/**
 * Spot images content which adapts based on number of images
 * Scenarios:
 * 1. One image - Single image will be displayed
 * 2. Multiple images - Back card, Image with a overlay (Front card)
 * and on top total count will be displayed
 */
@Composable
fun SpotImage(
    images: List<Any>,
    modifier: Modifier
) {
    if (images.isEmpty())
        return

    val isMoreThanOneImage = remember { images.size > 1 }

    BoxWithConstraints(
        modifier = modifier
            .aspectRatio(
                ratio = 1f,
                matchHeightConstraintsFirst = true
            )
    ) {
        // Calculate adjusted sizes based on current max sizes
        val adjustedHeight = remember { maxHeight - (maxHeight.times(.18f)) }
        val adjustedWidth = remember { maxWidth - (maxWidth.times(.18f)) }
        val offsetHeight = remember { maxHeight * 0.13f }
        val offsetWidth = remember { maxWidth * 0.17f }
        val cornerRadius = 6.dp

        // Show Back card when images are more than one
        if (isMoreThanOneImage) {
            BackCard(adjustedHeight, offsetWidth, offsetHeight, cornerRadius)
        }

        // Front card with overlay and text
        Box(
            Modifier
                .height(if (isMoreThanOneImage) adjustedHeight else maxHeight)
                .width(if (isMoreThanOneImage) adjustedWidth else maxWidth)
                .graphicsLayer {
                    if (isMoreThanOneImage) {
                        translationX = offsetWidth.toPx()
                        translationY = offsetHeight.toPx()
                    }
                }
                .clip(shape = RoundedCornerShape(size = cornerRadius)),
            contentAlignment = Alignment.Center
        ) {
            // Image on Front card.
            AsyncImage(
                model = images.first(),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "Spot Image(s)",
                contentScale = ContentScale.Crop
            )

            // Show overlay and text when images are more than one
            if (isMoreThanOneImage) {
                ImageOverlayAndCount(count = images.size)
            }
        }
    }
}

/**
 * Displays Back with modifications
 */
@Composable
private fun BackCard(
    adjustedHeight: Dp,
    offsetWidth: Dp,
    offsetHeight: Dp,
    cornerRadius: Dp
) {
    val backCardRotationAngle = -17f
    // Use 90% height of the front card for Back card size
    val adjustedBackCardSize = adjustedHeight.times(.9f)
    Box(
        modifier = Modifier
            .width(adjustedBackCardSize)
            // Reduce Back card height to avoid overflow due to rotation
            .height(adjustedBackCardSize.times(.98f))
            .graphicsLayer {
                translationX = offsetWidth
                    .toPx()
                    .times(0.5f)
                translationY = offsetHeight.toPx()
            }
            .rotate(degrees = backCardRotationAngle)
            .clip(shape = RoundedCornerShape(size = cornerRadius))
            .background(color = MaterialTheme.colorScheme.primary),
    )
}

/**
 * Displays overlay and count
 */
@Composable
private fun ImageOverlayAndCount(
    count: Int
) {
    // Transparent effect in image.
    Spacer(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
    )

    // Count text.
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "$count",
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        color = Color.White
    )
}

@ThemedComponentPreviews
@Composable
private fun SpotSingleImagePreview() {
    Preview {
        SpotImage(
            listOf(R.drawable.test_image),
            modifier = Modifier
                .height(40.dp)
        )
    }
}

@ThemedComponentPreviews
@Composable
private fun SpotMultipleImagePreview() {
    Preview {
        SpotImage(
            listOf(
                R.drawable.test_image,
                R.drawable.test_image
            ),
            modifier = Modifier
                .height(40.dp)
        )
    }
}