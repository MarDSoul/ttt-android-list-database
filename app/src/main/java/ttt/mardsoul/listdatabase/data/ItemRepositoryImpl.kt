package ttt.mardsoul.listdatabase.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ttt.mardsoul.listdatabase.data.database.ItemDao
import ttt.mardsoul.listdatabase.di.IoDispatcher
import ttt.mardsoul.listdatabase.domain.ItemRepository
import ttt.mardsoul.listdatabase.domain.model.Item
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ItemRepository {
    override fun getItems(): Flow<List<Item>> {
        return itemDao.getAllItems()
            .map { list -> list.map { it.toModel() } }
            .flowOn(ioDispatcher)
    }

    override suspend fun changeAmount(itemId: Int, newAmount: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteItem(itemId: Int) {
        TODO("Not yet implemented")
    }
}