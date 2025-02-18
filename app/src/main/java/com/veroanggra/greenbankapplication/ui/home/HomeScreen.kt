import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.veroanggra.greenbankapplication.utils.actions.setClipboard
import com.veroanggra.greenbankapplication.utils.component.CustomOnTopToast
import com.veroanggra.greenbankapplication.utils.component.CustomTabSample
import com.veroanggra.greenbankapplication.utils.component.GrayLine
import com.veroanggra.greenbankapplication.utils.component.SavingCard
import com.veroanggra.greenbankapplication.utils.helper.BankingDataStore
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    context: Context
) {
    val textNumber = "9876543210"
    val textName = "greenSaving"
    val balance = "1.000.000.000"
    var isShowMessage by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    val isVisibleFlow = BankingDataStore.getIsVisible(context)
    val isVisible by isVisibleFlow.collectAsState(initial = true)
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            CustomTabSample()
            Spacer(modifier = Modifier.height(1.dp))
            GrayLine(Modifier, Color(0xFFF3F4F6), 10f)
            Spacer(modifier = Modifier.height(10.dp))
            SavingCard(
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp),
                textNumber = textNumber,
                textName = textName,
                balance = balance,
                onClick = {
                    context.apply {
                        setClipboard("Account Number", textNumber)
                        isShowMessage = true
                        message = "Berhasil di-Copy!"
                    }
                },
                isVisible = isVisible,
                eyeClick = {
                    coroutineScope.launch {
                        BankingDataStore.saveIsVisible(context, !isVisible)
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