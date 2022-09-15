package com.rafflypohan.mycodingtest.ui.features.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafflypohan.mycodingtest.R
import com.rafflypohan.mycodingtest.core.domain.models.QuotesModelItem

@Composable
fun QuotesListItem(onItemClick: () -> Unit, item: QuotesModelItem, modifier: Modifier = Modifier) {
    Card(
        border = BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
        shape = RoundedCornerShape(8.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clickable(onClick = onItemClick)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_round_format_quote_24),
                contentDescription = null
            )
            Text(text = item.content, style = MaterialTheme.typography.body1)
            Spacer(modifier = modifier.height(16.dp))
            Text(text = "~ ${item.author}", style = MaterialTheme.typography.body1, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQuotesListItem() {
    QuotesListItem(
        onItemClick = { /*TODO*/ },
        item = QuotesModelItem(
            "1",
            "Budi",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        )
    )
}