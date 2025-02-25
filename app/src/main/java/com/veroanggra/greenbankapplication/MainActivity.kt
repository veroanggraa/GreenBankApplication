package com.veroanggra.greenbankapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.veroanggra.greenbankapplication.ui.main_tab.MainTabScreen
import com.veroanggra.greenbankapplication.ui.theme.GreenBankApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenBankApplicationTheme {
                MainTabScreen(modifier = Modifier, context = this)
            }
        }
    }
}

