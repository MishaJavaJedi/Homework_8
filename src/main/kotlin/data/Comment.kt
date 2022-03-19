package data

data class Comment(
    val id:Int,
    val noteId:Int,
    val fromId:Int,
    val date:Long,
    val text:String,
    val replyToUser:Int,
    val replyToComment:Int,
    var isDeleted:Boolean
)