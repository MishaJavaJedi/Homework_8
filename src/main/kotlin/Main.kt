import data.Comment
import data.Note
import service.WallService

fun main() {
    val comment = Comment(id = 0, fromId = 1, date = 31234123, text = "lorem ipsum", replyToComment = 1, replyToUser = 2, isDeleted = false)
    val note = Note(
        id = 0,
        userId = 1,
        noteTitle = "noteTitle",
        noteText = "noText",
        date = 123476872,
        comment = comment,
        readComment = 5
    )
val wallService = WallService()
    wallService.add(note)

}