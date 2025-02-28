package ttt.mardsoul.listdatabase.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import ttt.mardsoul.listdatabase.R
import ttt.mardsoul.listdatabase.domain.model.Item
import ttt.mardsoul.listdatabase.ui.components.ItemCard
import ttt.mardsoul.listdatabase.ui.components.ItemDialog
import ttt.mardsoul.listdatabase.ui.components.SearchBar

@Composable
fun ItemListScreen(
    modifier: Modifier = Modifier,
    viewModel: ItemListViewModel = hiltViewModel()
) {
    val listState = viewModel.itemsState.collectAsState()
    var showEditAmountDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<Item?>(null) }
    val query by viewModel.query.collectAsState()

    Column(
        modifier = modifier
            .systemBarsPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.title),
            modifier = Modifier.padding(dimensionResource(R.dimen.dimen_16)),
            style = MaterialTheme.typography.headlineMedium
        )
        SearchBar(query = query, onQueryChange = { viewModel.updateQuery(it) })
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(
                horizontal = dimensionResource(R.dimen.dimen_16),
                vertical = dimensionResource(R.dimen.dimen_8)
            ),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.dimen_4)),
        ) {
            items(
                items = listState.value,
                key = { item -> item.id }
            ) { item ->
                ItemCard(
                    item = item,
                    onClickEditAmount = {
                        selectedItem = item
                        showEditAmountDialog = true
                    },
                    onClickDelete = {
                        selectedItem = item
                        showDeleteDialog = true
                    }
                )
            }
        }
    }

    selectedItem?.let { item ->
        if (showEditAmountDialog) {
            EditAmountItemDialog(
                onDismiss = { showEditAmountDialog = false },
                onConfirm = { amount ->
                    viewModel.changeAmount(item.id, amount)
                    showEditAmountDialog = false
                },
                currentAmount = item.amount
            )
        }

        if (showDeleteDialog) {
            DeleteItemDialog(
                onDismiss = { showDeleteDialog = false },
                onConfirm = {
                    viewModel.deleteItem(item.id)
                    showDeleteDialog = false
                }
            )
        }
    }
}

@Composable
fun EditAmountItemDialog(
    onDismiss: () -> Unit,
    onConfirm: (Int) -> Unit,
    currentAmount: Int
) {
    var amount by remember { mutableIntStateOf(currentAmount) }
    ItemDialog(
        onDismissClick = onDismiss,
        onConfirmClick = { onConfirm(amount) },
        dialogTitle = stringResource(R.string.edit_dialog_title),
        dialogContent = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { amount-- }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_minus_circle_24),
                        contentDescription = stringResource(R.string.minus_ic_cd)
                    )
                }
                Text(text = amount.toString(), style = MaterialTheme.typography.bodyMedium)
                IconButton(
                    onClick = { amount++ }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_plus_circle_24),
                        contentDescription = stringResource(R.string.plus_ic_cd)
                    )
                }
            }
        },
        icon = Icons.Filled.Settings,
        confirmText = stringResource(R.string.edit_confirm_text),
        dismissText = stringResource(R.string.edit_dismiss_text)
    )
}

@Composable
fun DeleteItemDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    ItemDialog(
        onDismissClick = onDismiss,
        onConfirmClick = onConfirm,
        dialogTitle = stringResource(R.string.delete_dialog_title),
        dialogContent = {
            Text(
                stringResource(R.string.delete_dialog_text),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        icon = Icons.Filled.Warning,
        confirmText = stringResource(R.string.delete_confirm_text),
        dismissText = stringResource(R.string.delete_dismiss_text)
    )
}