package com.kth.compoundcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kth.compoundcomponent.dialog.DialogScreen
import com.kth.compoundcomponent.ui.theme.CompoundComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompoundComponentTheme {
                DialogScreen()
            }
        }
    }
}
