// ✅ DSDialog.kt
package com.kth.compoundcomponent.dialog

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DSDialog(
    show: Boolean,
    onDismissRequest: () -> Unit,
    data: DSDialogData,
    onConfirmClick: (() -> Unit)? = null,
    onCancelClick: (() -> Unit)? = null,
    content: @Composable DSDialogScope.() -> Unit
) {
    if (!show) return

    val scope = remember(onDismissRequest, data) {
        DSDefaultDialogScope(
            onDismissRequest = onDismissRequest,
            data = data,
            onConfirmClick = onConfirmClick,
            onCancelClick = onCancelClick
        )
    }

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            modifier = Modifier.wrapContentHeight(),
            shape = MaterialTheme.shapes.medium,
            color = Color.White,
            tonalElevation = 2.dp
        ) {
            scope.content()
        }
    }
}
