package com.veroanggra.greenbankapplication.utils.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun CustomTabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
    val tabTextColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            Black
        } else {
            Color(0xff898D99)
        },
        animationSpec = tween(easing = LinearEasing), label = "animation",
    )
    Text(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onClick()
            }
            .width(tabWidth)
            .padding(
                vertical = 6.dp,
                horizontal = 6.dp,
            ),
        text = text,
        textAlign = TextAlign.Center,
        color = tabTextColor, fontSize = 20.sp
    )
}


@Composable
private fun CustomTabIndicator(
    indicatorOffset: Dp,
    indicatorColor: Color,
) {
    Box(
        modifier = Modifier
            .width(70.dp)
            .height(3.dp)
            .offset(
                x = indicatorOffset,
            )
            .background(
                color = indicatorColor,
            ),
    )
}

@Composable
fun CustomTab(
    selectedItemIndex: Int,
    items: List<String>,
    modifier: Modifier = Modifier,
    tabWidth: Dp = 70.dp,
    onClick: (index: Int) -> Unit,
) {
    val indicatorOffset: Dp by animateDpAsState(
        targetValue = tabWidth * selectedItemIndex,
        animationSpec = tween(easing = LinearEasing), label = "animation",
    )

    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .height(intrinsicSize = IntrinsicSize.Min),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                CustomTabItem(
                    isSelected = isSelected,
                    onClick = {
                        onClick(index)
                    },
                    tabWidth = tabWidth,
                    text = text,
                )
            }
        }
        CustomTabIndicator(
            indicatorOffset = indicatorOffset,
            indicatorColor = Color(0xff399918),
        )
    }
}