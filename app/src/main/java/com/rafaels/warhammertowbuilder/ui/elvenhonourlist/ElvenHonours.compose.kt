package com.rafaels.warhammertowbuilder.ui.elvenhonourlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rafaels.domain.model.ElvenHonourModel

@Composable
fun ElvenHonours(
    elvenHonours: List<ElvenHonourModel>,
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(elvenHonours) {
            UnitHonour(it)
        }
    }
}

@Composable
fun UnitHonour(elvenHonour: ElvenHonourModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.Red)
    ) {
        Spacer(modifier = Modifier.padding(120.dp))
        Text(text = elvenHonour.honour, textAlign = TextAlign.Start)
        Text(text = elvenHonour.honourPoints.toString(), textAlign = TextAlign.End)

    }
}