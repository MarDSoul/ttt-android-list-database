package ttt.mardsoul.listdatabase.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ttt.mardsoul.listdatabase.ui.components.ItemCard

@Composable
fun ItemListScreen(
    modifier: Modifier = Modifier,
    viewModel: ItemListViewModel = hiltViewModel()
) {
    val listState = viewModel.itemsState.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        listState.value.forEach { item ->
            ItemCard(item = item)
        }
    }
}