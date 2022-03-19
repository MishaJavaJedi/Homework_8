package data

data class Note<C>(
    val id:Int,
    val userId:Int,
    val noteTitle:String,
    val noteText:String,
    val date:Long,
    val comment:C?,
    val readComment:Int
)
