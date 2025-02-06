package com.veroanggra.greenbankapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.veroanggra.greenbankapplication.ui.theme.GreenBankApplicationTheme
import com.veroanggra.greenbankapplication.utils.actions.setClipboard
import com.veroanggra.greenbankapplication.utils.component.CustomOnTopToast
import com.veroanggra.greenbankapplication.utils.component.SavingCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenBankApplicationTheme {
                val textNumber = "9876543210"
                val textName = "greenSaving"
                val balance = "1.000.000"
                var isShowMessage by remember { mutableStateOf(false) }
                var message by remember { mutableStateOf("") }
                SavingCard(
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 60.dp),
                    textNumber = textNumber,
                    textName = textName,
                    balance = balance,
                    onClick = {
                        this.apply {
                            setClipboard("Account Number", textNumber)
                            isShowMessage = true
                            message = "Berhasil di-Copy!"
                        }
                    })
                if (isShowMessage) {
                    CustomOnTopToast(
                        message = message,
                        onDismiss = { isShowMessage = false }
                    )
                }
            }
        }
    }
}
