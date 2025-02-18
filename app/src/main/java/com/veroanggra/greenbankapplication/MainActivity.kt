package com.veroanggra.greenbankapplication

import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.veroanggra.greenbankapplication.ui.theme.GreenBankApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenBankApplicationTheme {
                HomeScreen(this)

//                Column {
//                    GrayLine(Modifier, Color(0xFFF3F4F6), 50f)
//                    Spacer(modifier = Modifier.height(20.dp))
//                    SavingCard(
//                        modifier = Modifier.padding(horizontal = 30.dp, vertical = 60.dp),
//                        textNumber = textNumber,
//                        textName = textName,
//                        balance = balance,
//                        onClick = {
//                            this.apply {
//                                setClipboard("Account Number", textNumber)
//                                isShowMessage = true
//                                message = "Berhasil di-Copy!"
//                            }
//                        },
//                        isVisible = isVisible,
//                        eyeClick = {
//                            coroutineScope.launch {
//                                BankingDataStore.saveIsVisible(this@MainActivity, !isVisible)
//                            }
//                        })
//                }
//                if (isShowMessage) {
//                    CustomOnTopToast(
//                        message = message,
//                        onDismiss = { isShowMessage = false }
//                    )
//                }
            }
        }
    }
}

