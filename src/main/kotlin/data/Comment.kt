package data

data class Comment(
val id:Int,
val fromId:Int,
val date:Long,
val text:String,
val replyToUser:Int,
val replyToComment:Int,
val isDeleted:Boolean
)