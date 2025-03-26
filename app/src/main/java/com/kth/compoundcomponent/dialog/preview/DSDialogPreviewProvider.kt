package com.kth.compoundcomponent.dialog.preview

import com.kth.compoundcomponent.dialog.DSDialogData
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class DSDialogPreviewProvider : PreviewParameterProvider<DSDialogData> {
    override val values: Sequence<DSDialogData> = sequenceOf(
        DSDialogData("제목만 있음", confirmButtonText = "확인"),
        DSDialogData("제목과 버튼", confirmButtonText = "확인", cancelButtonText = "취소"),
        DSDialogData("제목 세로 버튼", confirmButtonText = "확인", cancelButtonText = "취소", isVerticalButtonLayout = true),
        DSDialogData("제목+메시지", message = "메시지입니다", confirmButtonText = "확인"),
        DSDialogData("제목+메시지+가로버튼", message = "내용 설명", confirmButtonText = "확인", cancelButtonText = "취소"),
        DSDialogData("제목+메시지+세로버튼", message = "상세 설명", confirmButtonText = "확인", cancelButtonText = "취소", isVerticalButtonLayout = true),
        DSDialogData("아이콘 포함", message = "아이콘 메시지", imageResId = android.R.drawable.ic_dialog_info, confirmButtonText = "확인", cancelButtonText = "취소"),
        DSDialogData("아이콘 세로 버튼", message = "세로정렬", imageResId = android.R.drawable.ic_dialog_info, confirmButtonText = "확인", cancelButtonText = "취소", isVerticalButtonLayout = true)
    )
}
