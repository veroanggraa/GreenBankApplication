package com.veroanggra.greenbankapplication.utils.actions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

fun Context.setClipboard(label: String, text: String) {
    (getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager)?.setPrimaryClip(
        ClipData.newPlainText(
            label,
            text
        )
    )
}