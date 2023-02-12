package me.mattak.dicomparation.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextCell(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(16.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
}