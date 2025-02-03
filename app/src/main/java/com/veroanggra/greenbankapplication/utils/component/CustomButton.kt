package com.veroanggra.greenbankapplication.utils.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.veroanggra.greenbankapplication.R

@Composable
fun CopyButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        onClick = onClick,
        modifier
            .size(40.dp)
            .padding(end = 10.dp, top = 10.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_copy),
            contentDescription = "Copy",
            modifier.size(30.dp)
        )
    }
}

@Composable
fun EyeIconButton(onClick: () -> Unit, modifier: Modifier, isVisible: Boolean) {
    IconButton(
        onClick = onClick,
        modifier
            .size(40.dp)
            .padding(end = 10.dp, top = 10.dp)
    ) {
        if (isVisible) {
            Icon(
                painter = painterResource(R.drawable.icon_eye),
                contentDescription = "Eye",
                modifier.size(30.dp)
            )
        }

    }
}

@Preview
@Composable
private fun CopyButtonPreview() {
    Column {
        CopyButton(
            modifier = Modifier,
            onClick = {}
        )

        EyeIconButton(
            onClick = {}, modifier = Modifier, isVisible = true
        )
    }
}
