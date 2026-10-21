package com.yaroslavsdev.navigationsample.ui.screens.productCard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yaroslavsdev.navigationsample.data.ItemsRepository

@Composable
fun ProductCard(
    id: Int,
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onBackClicked) {
            Text("Назад к списку")
        }

        Card(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = ItemsRepository.getProductName(id),
                modifier = Modifier.padding(24.dp),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}