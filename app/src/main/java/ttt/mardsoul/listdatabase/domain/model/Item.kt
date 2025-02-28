package ttt.mardsoul.listdatabase.domain.model

data class Item(
    val id: Int,
    val name: String,
    val time: String,
    val tags: List<String>,
    val amount: Int
)
