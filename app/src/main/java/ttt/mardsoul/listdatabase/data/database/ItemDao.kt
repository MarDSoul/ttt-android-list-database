package ttt.mardsoul.listdatabase.data.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM item WHERE name LIKE '%' || :name || '%'")
    fun getItemsByName(name: String): Flow<List<ItemEntity>>

    @Query("UPDATE item SET amount = :amount WHERE id = :id")
    suspend fun setAmount(id: Int, amount: Int)

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun deleteItem(id: Int)
}