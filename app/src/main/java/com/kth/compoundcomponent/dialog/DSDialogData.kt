package com.kth.compoundcomponent.dialog

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

/**
 *  Preview 테스트
 *  서버 driven
 */
@Stable
data class DSDialogData(
    val title: String,
    val message: String? = null,
    @DrawableRes val imageResId: Int? = null,
    val imageTint: Color?= null,
    val isVerticalButtonLayout: Boolean = false,
    val confirmButtonText: String? = null,
    val confirmUrl: String? = null,
    val cancelButtonText: String? = null
)