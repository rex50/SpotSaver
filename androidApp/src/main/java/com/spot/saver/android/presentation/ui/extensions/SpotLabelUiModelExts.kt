package com.spot.saver.android.presentation.ui.extensions

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.spot.saver.android.data.enums.SpotLabelColors
import com.spot.saver.android.theme.SpotSaverColors
import com.spot.saver.enums.LabelType
import com.spot.saver.view.model.SpotLabelUiModel

/**
 * Returns [SpotLabelColors] based on [LabelType]
 */
@Composable
fun SpotLabelUiModel.colors(): SpotLabelColors {
    return when(type) {
        LabelType.GENERAL -> SpotLabelColors(
            background = MaterialTheme.colorScheme.tertiary,
            text = MaterialTheme.colorScheme.onTertiary
        )
        LabelType.EXPIRY_RED -> SpotLabelColors(
            background = SpotSaverColors.EngineRedColor,
            text = SpotSaverColors.WhiteColor
        )
        LabelType.EXPIRY_YELLOW -> SpotLabelColors(
            background = SpotSaverColors.OldGoldColor,
            text = SpotSaverColors.WhiteColor
        )
        LabelType.EXPIRY_GREEN -> SpotLabelColors(
            background = SpotSaverColors.PastelGreenColor,
            text = SpotSaverColors.WhiteColor
        )
    }
}