package ttt.mardsoul.listdatabase.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ttt.mardsoul.listdatabase.data.database.ItemDao
import ttt.mardsoul.listdatabase.di.IoDispatcher
import ttt.mardsoul.listdatabase.domain.ItemRepository
import ttt.mardsoul.listdatabase.domain.model.Item
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ItemRepository {
    override fun getItems(name: String): Flow<List<Item>> {
        return itemDao.getItemsByName(name)
            .map { list -> list.map { it.toModel() } }
            .flowOn(ioDispatcher)
    }

    override suspend fun changeAmount(itemId: Int, newAmount: Int) {
        withContext(ioDispatcher) {
            itemDao.setAmount(itemId, newAmount)
        }
    }

    override suspend fun deleteItem(itemId: Int) {
        withContext(ioDispatcher) {
            itemDao.deleteItem(itemId)
        }
    }
}