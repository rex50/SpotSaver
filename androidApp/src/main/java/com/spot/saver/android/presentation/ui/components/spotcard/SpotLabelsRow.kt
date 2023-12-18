package com.spot.saver.android.presentation.ui.components.spotcard

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import com.spot.saver.android.presentation.ui.components.ItemLabelUI
import com.spot.saver.android.presentation.ui.core.Preview
import com.spot.saver.android.presentation.ui.core.ThemedComponentPreviews
import com.spot.saver.android.presentation.ui.extensions.colors
import com.spot.saver.enums.LabelType
import com.spot.saver.models.ui.SpotLabelUiModel


/**
 * Displays (flow) row of labels
 */
@Composable
@OptIn(ExperimentalLayoutApi::class)
fun SpotLabelsRow(labels: List<SpotLabelUiModel>) {
    FlowRow {
        labels.forEach { label ->
            val colors = label.colors()
            ItemLabelUI(
                text = label.text,
                backgroundColor = colors.background,
                textColor = colors.text
            )
        }
    }
}

@ThemedComponentPreviews
@Composable
private fun SpotLabelsPreview() {
    Preview {
        SpotLabelsRow(
            listOf(
                SpotLabelUiModel("Expires in 4 hours", LabelType.EXPIRY_RED),
                SpotLabelUiModel("Expires in 24 hours", LabelType.EXPIRY_YELLOW),
                SpotLabelUiModel("Expires in 1 month", LabelType.EXPIRY_GREEN),
                SpotLabelUiModel("General label", LabelType.GENERAL),
            )
        )
    }
}