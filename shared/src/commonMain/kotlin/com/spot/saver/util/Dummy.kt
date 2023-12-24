package com.spot.saver.util

import com.spot.saver.enums.LabelType
import com.spot.saver.view.model.SpotDetailUiModel
import com.spot.saver.view.model.SpotLabelUiModel

/**
 * Dummy spot detail item
 */
internal val dummySpotDetail = SpotDetailUiModel(
    id = "",
    title = "Pericula",
    createdDate = "5th feb",
    displayLocation = "Surat, Gujarat",
    locationUri = "https://map.path.go",
    imageUrl = null,
    totalImages = 0,
    expiryTime = null,
    labels = listOf(
        SpotLabelUiModel(
            text = "Expires in 4 hours",
            type = LabelType.EXPIRY_RED
        )
    )
)