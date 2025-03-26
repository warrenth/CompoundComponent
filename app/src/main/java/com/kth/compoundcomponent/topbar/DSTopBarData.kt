package com.kth.compoundcomponent.topbar

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable

@Stable
sealed class DSTopBarTitle {
    data class Text(val value: String) : DSTopBarTitle()
    data class Icon(@DrawableRes val resId: Int) : DSTopBarTitle()
}

@Stable
data class DSTopBarData(
    val title: DSTopBarTitle? = null,
    val actions: List<DSTopBarAction> = emptyList()
)

sealed class DSTopBarAction {
    data object Search : DSTopBarAction()
    data object Cart : DSTopBarAction()
}
