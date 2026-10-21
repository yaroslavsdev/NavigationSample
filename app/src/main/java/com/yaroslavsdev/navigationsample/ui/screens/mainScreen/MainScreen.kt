package com.yaroslavsdev.navigationsample.ui.screens.mainScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yaroslavsdev.navigationsample.data.ItemsRepository

@Composable
fun MainScreen(
    onButtonClicked: (Int) -> Unit
) {
    LazyColumn {
        for (i in 0..<ItemsRepository.getSize()) {
            item {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                        .height(60.dp)
                ) {
                    TextButton(
                        modifier = Modifier.fillMaxSize(),
                        onClick = { onButtonClicked(i) }
                    ) {
                        Text(ItemsRepository.getProductName(i))
                    }
                }
            }
        }
    }
}