package com.veroanggra.greenbankapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.veroanggra.greenbankapplication.ui.theme.GreenBankApplicationTheme
import com.veroanggra.greenbankapplication.utils.actions.setClipboard
import com.veroanggra.greenbankapplication.utils.component.SavingCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenBankApplicationTheme {
                SavingCard(
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 60.dp),
                    onClick = {
                        this.setClipboard("label", "text")
                    })
            }
        }
    }
}
