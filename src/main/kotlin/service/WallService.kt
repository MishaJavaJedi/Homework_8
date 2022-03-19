package service

import data.Comment
import data.Note


class WallService {
    private var commentsCollection = mutableListOf<Comment>()
    private var notesCollection = mutableListOf<Note<Comment>>()


    fun add(note: Note<Comment>) {
        notesCollection.add(note)
        commentsCollection.add(note.comment ?: throw RuntimeException("Нельзя оставить пустой комментарий"))
    }

    fun createComment(note: Note<Comment>) {
        commentsCollection.add(
            note.comment ?: throw RuntimeException("Нельзя оставить пустой комментарий")
        )
    }

    fun delete(note: Note<Comment>) {
        //При удалении заметки, удаляются все комментарии к ней
        notesCollection.remove(note)
        for (comment in commentsCollection) {
            if (comment.noteId == note.id) {
                comment.isDeleted = true
            }
        }
    }

    fun deleteComment(note: Note<Comment>) {
        //Пользователь пытается удалить (или отредактировать) уже удалённый комментарий
        if (note.comment?.isDeleted == true) {
            throw RuntimeException("Нельзя удалить уже удаленный комментарий")
        } else {
            for (comment in commentsCollection) {
                if (comment.noteId == note.id) {
                    comment.isDeleted = true
                }
            }
        }
    }

    fun edit(note: Note<Comment>) {
        for ((index, value) in notesCollection.withIndex()) {
            if (note.id == value.id) {
                notesCollection[index] = note
            }
        }
    }

    fun editComment(note: Note<Comment>) {
        if (note.comment?.isDeleted == true) {
            throw java.lang.RuntimeException("Нельзя изменить удаленный комментарий")
        }
        for ((index, value) in commentsCollection.withIndex()) {
            if (note.comment?.noteId == value.id) {
                commentsCollection[index] = note.comment
            }
        }
    }

    fun get(): List<Note<Comment>> {
        return notesCollection
    }

    fun getById(id: Int): Note<Comment> {
        for (note in notesCollection) {
            if (note.id == id) {
                return note
            }
        }
        throw RuntimeException("Заметка не найдена")
    }

    fun getComments(): List<Comment> {
        return commentsCollection
    }

    fun restoreComment(note: Note<Comment>) {
        if (note.comment?.isDeleted == false) {
            throw RuntimeException("Нельзя восстановить не удаленный комментарий")
        }
        for (comment in commentsCollection) {
            if (comment.noteId == note.id) {
                comment.isDeleted = false
            }
        }
    }

    fun printAllNotes() {
        for (note in notesCollection) {
            println(note)
        }
    }

    fun printAllComments() {
        for (comment in commentsCollection) {
            println(comment)
        }
    }
}
