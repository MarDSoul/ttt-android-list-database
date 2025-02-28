package ttt.mardsoul.listdatabase.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import ttt.mardsoul.listdatabase.R
import ttt.mardsoul.listdatabase.ui.components.ItemCard

@Composable
fun ItemListScreen(
    modifier: Modifier = Modifier,
    viewModel: ItemListViewModel = hiltViewModel()
) {
    val listState = viewModel.itemsState.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding(),
        contentPadding = PaddingValues(
            horizontal = dimensionResource(R.dimen.dimen_16),
            vertical = dimensionResource(R.dimen.dimen_8)
        ),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.dimen_4)),
    ) {
        items(listState.value) { item ->
            ItemCard(item = item)
        }
    }
}