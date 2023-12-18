package com.spot.saver.models.ui

import com.spot.saver.enums.LabelType

/**
 * UI model for Spot detail
 */
data class SpotDetailUiModel(
    val id: String,
    val title: String,
    val createdDate: String,
    val displayLocation: String,
    val locationUri: String,
    val imageUrl: String? = null,
    val totalImages: Int = 0,
    val expiryTime: String? = null,
    val labels: List<SpotLabelUiModel> = listOf()
)

/**
 * UI model for Spot label
 */
data class SpotLabelUiModel(
    val text: String,
    val type: LabelType
)
