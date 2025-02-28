package ttt.mardsoul.listdatabase.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import ttt.mardsoul.listdatabase.domain.model.Item
import java.text.DateFormat

@Entity(tableName = "item")
data class ItemEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val time: Int,
    val tags: String,
    val amount: Int
) {
    fun toModel(): Item {
        return Item(
            id = id,
            name = name,
            time = convertTimeAsString(),
            tags = convertTagsList(),
            amount = amount
        )
    }

    private fun convertTagsList(): List<String> {
        val regexTag = Regex("(\"\\w+\")")
        return regexTag.findAll(tags).map { it.value }.toList()
    }

    private fun convertTimeAsString(): String {
        return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(time)
    }
}
