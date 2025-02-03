package com.veroanggra.greenbankapplication.utils.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SavingCard(modifier: Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier.size(width = 320.dp, height = 200.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F4F6))
    ) {
        AccountNameNumberTextCopy(
            modifier = Modifier,
            textName = "greenSaving",
            textNumber = "0291938237",
            onClick = onClick
        )
    }
}