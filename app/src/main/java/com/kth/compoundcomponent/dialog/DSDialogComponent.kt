package com.kth.compoundcomponent.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kth.compoundcomponent.router.LandingRouter

@Composable
fun DSDialogScope.DSDialogTitle(modifier: Modifier = Modifier) {
    val title = data.title
    val style = if (data.message.isNullOrBlank()) {
        MaterialTheme.typography.headlineSmall
    } else {
        MaterialTheme.typography.titleMedium
    }

    Text(
        text = title,
        modifier = modifier,
        style = style,
        textAlign = TextAlign.Center
    )
}

@Composable
fun DSDialogScope.DSDialogCancelButton(modifier: Modifier = Modifier) {
    val text = data.cancelButtonText ?: return

    Button(
        onClick = {
            onCancelClick?.invoke() ?: onDismissRequest
        },
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun DSDialogScope.DSDialogConfirmButton(modifier: Modifier = Modifier) {
    val text = data.confirmButtonText ?: return
    val context = LocalContext.current

    Button(
        onClick = {
            if (onConfirmClick != null) {
                onConfirmClick?.invoke()
            } else {
                data.confirmUrl?.let { url ->
                    LandingRouter.loadUrl(context, url)
                } ?: onDismissRequest()
            }
        },
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun DSDialogScope.DSDialogDefaultLayout() {
    val hasMessage = !data.message.isNullOrBlank()
    val hasConfirmButton = !data.confirmButtonText.isNullOrBlank()
    val hasCancelButton = !data.cancelButtonText.isNullOrBlank()
    val hasButtons = hasConfirmButton || hasCancelButton

    Column(
        modifier = Modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DSDialogTitle()

        if (hasMessage) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = data.message ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        if (hasButtons) {
            Spacer(modifier = Modifier.height(24.dp))

            if (data.isVerticalButtonLayout) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (hasConfirmButton) DSDialogConfirmButton(Modifier.fillMaxWidth())
                    if (hasCancelButton) DSDialogCancelButton(Modifier.fillMaxWidth())
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (hasCancelButton) DSDialogCancelButton(Modifier.weight(1f))
                    if (hasConfirmButton) DSDialogConfirmButton(Modifier.weight(1f))
                }
            }
        }
    }
}

