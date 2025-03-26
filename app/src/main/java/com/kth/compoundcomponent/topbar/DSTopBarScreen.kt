package com.kth.compoundcomponent.topbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.kth.compoundcomponent.topbar.preview.DSTopBarPreviewProvider

@Composable
fun DSTopBarScreen(
    data: DSTopBarData,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    DSTopBar(
        data = data,
        onBackClick = onBackClick,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDSTopBarScreen(
    @PreviewParameter(DSTopBarPreviewProvider::class) data: DSTopBarData
) {
    DSTopBarScreen(
        data = data,
        onBackClick = {}
    )
}
