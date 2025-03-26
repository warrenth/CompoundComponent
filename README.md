Compounded Component Pattern
==
> 부모 컴포넌트가 UI의 전체 구조와 상태를 관리,  
> 자식 컴포넌트는 그 상태를 받아 UI를 자유롭게 조합할 수 있도록 만든 패턴.


# 1. DSDialog (Compound Component)
> 기본적인 다이얼로그 뼈대는 DSDialog가 담당하며, 내부에 들어갈 구체적인 UI는 사용자가 직접 자식 컴포넌트를 조합해서 구성합니다.

```kotlin
@Composable
fun DSDialog(
    data: DSDialogData,
    content: @Composable DSDialogScope.() -> Unit
) {
    Dialog() {
        Surface() {
            scope.content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DSDialogPreview(생략..) {
    DSDialog(
        data = data
    ) {
        DSDialogTitle()
        DSDialogConfirmButton()
        DSDialogCancelButton()
    }
}
```
```text
DSDialog (부모 컴포저블)
└─ DSDialogScope.() → 자식 컴포넌트로 전달
    ├── DSDialogTitle()            ← title 사용
    ├── DSDialogConfirmButton()    ← confirmText, confirmUrl, onConfirmClick 사용
    └── DSDialogCancelButton()     ← cancelText, onCancelClick 사용

 
- DSDialog는 부모 역할로 전체 구조 (Dialog, Surface)를 잡고, 자식에게 상태(scope)를 전달
- DSDialogScope는 부모의 상태(title 등)를 자식이 쓸 수 있게 해줌
- 자식 컴포넌트는 DSDialogScope를 리시버로 받아 부모 상태를 공유하며 UI를 그림
```

<img width="591" alt="Image" src="https://github.com/user-attachments/assets/bae129bf-cf6c-4fed-9e5e-bb4be376afa9" />

# 2. DSTopBar (Non-Compound Component)
> TopBar는 **항상 고정된 구조**로, Compound Component 를 사용하지 않습니다. </br> </br>
> 고정된 구조는 다음과 같다.  </br>
> - **Back 버튼**: 항상 고정 (좌측)  </br>
> - **Title 영역**: 텍스트 또는 아이콘 (가운데 정렬) </br>
> - **Action 영역**: 최대 2개의 버튼 (우측 정렬) </br>

```kotlin
DSTopBarScreen(
    data = data,
    onBackClick = {}

)
@Stable
data class DSTopBarData(
    val title: DSTopBarTitle? = null,
    val actions: List<DSTopBarAction> = emptyList()
)
```
```text
DSTopBar (하나의 컴포저블에서 모든 구성 처리)
│
├── BackButton 고정
├── Center 영역
│   ├── Text     ← data.title 이 Text 타입일 경우
│   └── Icon     ← data.title 이 Icon 타입일 경우
└── Right 영역
    └── 최대 2개까지 Action 버튼 (Search, Cart 등) ← data.actions 으로 구성
```
<img width="394" alt="Image" src="https://github.com/user-attachments/assets/01f71733-ea16-4c96-8772-101de0c112d1" />

### Compound Component VS Non-Compound Component
- UI 구조가 거의 고정되어 있고 커스터마이징이 적은지 판단
- 서버에서 단순히 데이터만 받아 노출/미노출 여부를 판단
- 자식 컴포넌트가 커스터마이징을 해서 새로운 Component 를 만들지 판단 

