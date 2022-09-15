package com.rafflypohan.mycodingtest.ui.features.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rafflypohan.mycodingtest.ui.features.home.HomeUIState
import com.rafflypohan.mycodingtest.ui.navigation.Destinations

@Composable
fun QuotesList(modifier: Modifier = Modifier, state: HomeUIState, navigateTo: (String) -> Unit) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(items = state.quotes, key = { q -> q.id }) { item ->
            QuotesListItem(onItemClick = {
                navigateTo("${Destinations.DETAIL_ROUTE}/${item.id}")
            }, item)
            Spacer(modifier = modifier.height(16.dp))
        }
    }
}