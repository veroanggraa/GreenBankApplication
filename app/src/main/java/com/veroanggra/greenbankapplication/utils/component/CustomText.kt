package com.veroanggra.greenbankapplication.utils.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AccountNameNumberTextCopy(
    textName: String,
    textNumber: String,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = Modifier.padding(top = 15.dp, start = 20.dp)) {
            Text(
                text = textName, style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212821),
                )
            )
            Text(
                text = " - ", style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212821),
                )
            )
            Text(
                text = textNumber, style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF212821),
                )
            )
        }
        CopyButton(onClick = onClick)
    }
}

@Preview(showBackground = true, name = "Saving Card")
@Composable
fun AccountNameNumberTextPreview() {
    AccountNameNumberTextCopy(
        textName = "greenSavng",
        textNumber = "9876543210",
        onClick = {},
        modifier = Modifier
    )
}

