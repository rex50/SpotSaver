package com.spot.saver.android.ui.screens.home.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.spot.saver.android.R
import com.spot.saver.android.ui.components.AsyncImage
import com.spot.saver.android.ui.core.Preview
import com.spot.saver.android.ui.core.ThemedComponentPreviews

/**
 * New spot button component
 */
@Composable
fun AddNewSpotButton(
    modifier: Modifier = Modifier,
    onClicked: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier
            .height(165.dp)
            .clip(RoundedCornerShape(14.dp))
            .shadow(8.dp)
            .clickable {
                onClicked()
            }
    ) {
        val (background, icon, text) = createRefs()
        // Background
        AsyncImage(
            model = R.drawable.img_new_spot_bg,
            contentDescription = stringResource(R.string.desc_add_new_spot_button_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(background) {
                    linkTo(
                        start = parent.start,
                        end = parent.end,
                        top = parent.top,
                        bottom = parent.bottom
                    )
                }
        )
        // Icon
        Icon(
            painter = painterResource(id = R.drawable.ic_add_spot),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = stringResource(R.string.desc_add_new_spot_button_icon),
            modifier = Modifier
                .constrainAs(icon) {
                    linkTo(
                        start = parent.start,
                        end = parent.end,
                        top = parent.top,
                        bottom = parent.bottom,
                        bottomMargin = 18.dp
                    )
                }
        )
        // Text
        Text(
            text = stringResource(R.string.add_new_spot),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(icon.bottom, margin = 8.dp)
                    start.linkTo(icon.start)
                    end.linkTo(icon.end)
                }
        )

    }
}

@ThemedComponentPreviews
@Composable
private fun AddNewSpotButtonPreview() {
    Preview {
        AddNewSpotButton {}
    }
}