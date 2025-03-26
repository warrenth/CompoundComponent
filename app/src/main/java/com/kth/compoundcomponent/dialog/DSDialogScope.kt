package com.kth.compoundcomponent.dialog

import androidx.compose.runtime.Stable

@Stable
interface DSDialogScope {
    val onDismissRequest: () -> Unit
    val data: DSDialogData
    val onConfirmClick: (() -> Unit)?
    val onCancelClick: (() -> Unit)?
}

class DSDefaultDialogScope(
    override val onDismissRequest: () -> Unit,
    override val data: DSDialogData,
    override val onConfirmClick: (() -> Unit)? = null,
    override val onCancelClick: (() -> Unit)? = null
) : DSDialogScope
