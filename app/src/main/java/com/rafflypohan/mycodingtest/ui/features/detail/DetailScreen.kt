package com.rafflypohan.mycodingtest.ui.features.detail

import android.content.Intent
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rafflypohan.mycodingtest.R

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher
    val state by viewModel.state.collectAsState()

    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, state.content)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopBar(
                onBackPressed = { dispatcher.onBackPressed() },
                onShareButtonClicked = { context.startActivity(shareIntent) })
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize(), Alignment.Center) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                DetailContent(state = state)
            }
        }
    }
}

@Composable
fun DetailContent(modifier: Modifier = Modifier, state: DetailUIState) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.secondaryVariant,
            shape = RoundedCornerShape(2.dp),
            elevation = 0.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.padding(horizontal = 20.dp, vertical = 22.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_format_quote_48),
                    contentDescription = null,
                )
                Text(
                    text = state.content,
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier = modifier.height(20.dp))
                Text(
                    text = state.author,
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}

@Composable
private fun TopBar(
    onBackPressed: () -> Unit,
    onShareButtonClicked: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Details") },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            Row {
                IconButton(onClick = onShareButtonClicked) {
                    Icon(imageVector = Icons.Rounded.Share, contentDescription = null)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailContent() {
    DetailContent(
        state = DetailUIState(
            "Budi",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        )
    )
}