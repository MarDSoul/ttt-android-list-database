package ttt.mardsoul.listdatabase.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import ttt.mardsoul.listdatabase.R
import ttt.mardsoul.listdatabase.domain.model.Item

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    item: Item,
    onClickEditAmount: () -> Unit = {},
    onClickDelete: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val horizontalPadding = PaddingValues(horizontal = dimensionResource(R.dimen.dimen_8))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontalPadding)
                .padding(top = dimensionResource(R.dimen.dimen_8)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.name,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleMedium
            )

            Row() {
                IconButton(onClick = onClickEditAmount) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = stringResource(R.string.edit_ic_cd),
                        tint = Color.Blue
                    )
                }
                IconButton(onClick = onClickDelete) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = stringResource(R.string.delete_ic_cd),
                        tint = Color.Red
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(dimensionResource(R.dimen.dimen_8)))
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontalPadding),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.dimen_4))
        ) {
            item.tags.forEach {
                SuggestionChip(
                    onClick = {},
                    label = { Text(text = it, style = MaterialTheme.typography.labelSmall) }
                )
            }
        }
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.dimen_8)))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontalPadding),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.amount_label_text),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = item.amount.toString(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.date_label_text),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = item.time,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontalPadding)
                .padding(bottom = dimensionResource(R.dimen.dimen_8)),
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = item.id.toString(),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}