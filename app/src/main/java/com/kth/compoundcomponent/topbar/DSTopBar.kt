package com.kth.compoundcomponent.topbar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kth.compoundcomponent.router.LandingRouter
import com.kth.compoundcomponent.R

@Composable
fun DSTopBar(
    data: DSTopBarData,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onBackClick) {
            Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "Back")
        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            when (val title = data.title) {
                is DSTopBarTitle.Text -> Text(
                    text = title.value,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
                is DSTopBarTitle.Icon -> Icon(
                    painter = painterResource(id = title.resId),
                    contentDescription = "Title Icon"
                )
                null -> {}
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            data.actions.take(2).forEach { action ->
                IconButton(
                    onClick = {
                        when (action) {
                            DSTopBarAction.Search -> {
                                // TODO: Navigate to search screen
                            }
                            DSTopBarAction.Cart -> {
                                LandingRouter.loadUrl(context, "https://yourdomain.com/cart")
                            }
                        }
                    }
                ) {
                    val iconRes = when (action) {
                        DSTopBarAction.Search -> R.drawable.ic_search
                        DSTopBarAction.Cart -> R.drawable.ic_basket
                    }
                    Icon(painter = painterResource(id = iconRes), contentDescription = "Action")
                }
            }
        }
    }
}
