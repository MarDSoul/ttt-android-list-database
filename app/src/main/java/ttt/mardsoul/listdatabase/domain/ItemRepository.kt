package ttt.mardsoul.listdatabase.domain

import kotlinx.coroutines.flow.Flow
import ttt.mardsoul.listdatabase.domain.model.Item

interface ItemRepository {
    fun getItems(): Flow<List<Item>>
    suspend fun changeAmount(itemId: Int, newAmount: Int)
    suspend fun deleteItem(itemId: Int)
}