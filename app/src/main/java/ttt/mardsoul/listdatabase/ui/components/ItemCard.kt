package ttt.mardsoul.listdatabase.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ttt.mardsoul.listdatabase.domain.model.Item

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    item: Item
) {
    Card(modifier = modifier) {
        Row {
            Text(text = item.id.toString())
            Text(text = item.name)
        }
        Text(text = item.time)
        Row {
            item.tags.forEach {
                Text(text = it)
            }
        }
        Text(text = item.amount.toString())
    }
}