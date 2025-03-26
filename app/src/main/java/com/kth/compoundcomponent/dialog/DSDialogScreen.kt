package com.kth.compoundcomponent.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.kth.compoundcomponent.dialog.preview.DSDialogPreviewProvider

@Composable
fun DialogScreen() {
    var isDialogVisible by remember { mutableStateOf(false) }

    val dialogData = DSDialogData(
        title = "안녕하세요",
        message = "이것은 Compound Component 다이얼로그입니다.",
        confirmButtonText = "확인",
        cancelButtonText = "취소"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { isDialogVisible = true }) {
            Text("다이얼로그 열기")
        }
    }

    DSDialog(
        show = isDialogVisible,
        onDismissRequest = { isDialogVisible = false },
        data = dialogData,
        onConfirmClick = { isDialogVisible = false },
        onCancelClick = { isDialogVisible = false }
    ) {
        DSDialogDefaultLayout()
    }
}

@Preview(showBackground = true)
@Composable
fun DSDialogPreview(
    @PreviewParameter(DSDialogPreviewProvider::class) data: DSDialogData
) {
    DSDialog(
        show = true,
        onDismissRequest = {},
        data = data,
        onConfirmClick = {},
        onCancelClick = {}
    ) {
        DSDialogDefaultLayout()
    }
}