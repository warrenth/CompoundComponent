package com.kth.compoundcomponent.topbar.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.kth.compoundcomponent.topbar.DSTopBarAction
import com.kth.compoundcomponent.topbar.DSTopBarData
import com.kth.compoundcomponent.topbar.DSTopBarTitle

class DSTopBarPreviewProvider : PreviewParameterProvider<DSTopBarData> {
    override val values: Sequence<DSTopBarData> = sequenceOf(
        DSTopBarData(title = DSTopBarTitle.Text("타이틀만 있음")),
        DSTopBarData(
            title = DSTopBarTitle.Text("타이틀 + 액션 1개"),
            actions = listOf(DSTopBarAction.Search)
        ),
        DSTopBarData(
            title = DSTopBarTitle.Text("타이틀 + 액션 2개"),
            actions = listOf(DSTopBarAction.Search, DSTopBarAction.Cart)
        ),
        DSTopBarData(
            title = DSTopBarTitle.Icon(android.R.drawable.ic_dialog_info),
            actions = listOf(DSTopBarAction.Search)
        )
    )
}
