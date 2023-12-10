package com.spot.saver.android.presentation.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.Placeholder as GlidePlaceholder
import com.bumptech.glide.integration.compose.placeholder as glidePlaceholder

/**
 * Image component which internally uses Glide
 */
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AsyncImage(
    model: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    loading: Placeholder? = null,
    failure: Placeholder? = null,
    contentScale: ContentScale = ContentScale.Fit
) {
    GlideImage(
        modifier = modifier,
        model = model,
        contentDescription = contentDescription,
        loading = loading?.toGlidePlaceholder(),
        failure = failure?.toGlidePlaceholder(),
        contentScale = contentScale,
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
private fun Placeholder.toGlidePlaceholder(): GlidePlaceholder {
    return when (this) {
        is Placeholder.Drawable -> glidePlaceholder(drawable)
        is Placeholder.Resource -> glidePlaceholder(resourceId)
    }
}

sealed class Placeholder {
    data class Drawable(val drawable: android.graphics.drawable.Drawable?) : Placeholder()
    data class Resource(@DrawableRes val resourceId: Int) : Placeholder()

    companion object {
        fun placeholder(drawable: android.graphics.drawable.Drawable?): Placeholder =
            Drawable(drawable)

        fun placeholder(@DrawableRes resourceId: Int): Placeholder = Resource(resourceId)
    }
}