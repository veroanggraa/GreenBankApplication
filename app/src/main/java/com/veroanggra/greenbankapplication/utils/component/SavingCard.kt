package com.veroanggra.greenbankapplication.utils.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SavingCard(modifier: Modifier, onClick: () -> Unit, textNumber: String, balance: String, textName: String) {
    Card(
        modifier = modifier.size(width = 320.dp, height = 200.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F4F6))
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            AccountNameNumberTextCopy(
                modifier = Modifier,
                textName = textName,
                textNumber = textNumber,
                onClick = onClick
            )
            BalanceText(
                balance = balance,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                isVisible = false
            )
            Row(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
                CommonButton(onClick = {}, modifier = Modifier, label = "Pindah Dana")
                Spacer(Modifier.width(10.dp))
                CommonButton(onClick = {}, modifier = Modifier, label = "Qris")
            }
        }
    }
}

@Preview
@Composable
private fun PreViewCard() {
    SavingCard(modifier = Modifier, textNumber = "0291938237", textName = "greenSaving", balance = "1.000.000", onClick = {})
}