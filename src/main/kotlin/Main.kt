import data.Comment
import data.Note
import service.WallService

fun main() {
    val wallService = WallService()
    val comment = Comment(
        id = 0,
        noteId = 1,
        fromId = 1,
        date = 31234123,
        text = "lorem ipsum",
        replyToComment = 1,
        replyToUser = 2,
        isDeleted = false
    )
    val updatedComment = Comment(
        id = 0,
        noteId = 1,
        fromId = 1,
        date = 31234123,
        text = "new text",
        replyToComment = 1,
        replyToUser = 2,
        isDeleted = false
    )
    val note = Note(
        id = 1,
        userId = 1,
        noteTitle = "Note Title",
        noteText = "Note Text",
        date = 123476872,
        comment = comment,
        readComment = 5
    )
    val updatedNote = note.copy(noteText = "Updated note text", comment = updatedComment)

    wallService.add(note)
    wallService.createComment(updatedNote)

    wallService.deleteComment(note)

    wallService.printAllComments()
    wallService.printAllNotes()

    wallService.restoreComment(note)

    wallService.printAllComments()
    wallService.printAllNotes()
}