package service

import data.Comment
import data.Note


class WallService {
    private var commentsCollection = mutableListOf<Comment>()
    private var notesCollection = mutableSetOf<Note<Comment>>()


    fun add(note: Note<Comment>){
        notesCollection.add(note)
    }

    fun createComment(note: Note<Comment>){
        commentsCollection.add(note.comment?:throw java.lang.RuntimeException("Нельзя оставить комментарий к несуществующей заметке"))
    }

     fun delete(noteId:Note<Comment>){
         notesCollection.remove(noteId)
     }

    fun deleteComment(note: Note<Comment>){
       for(tempNote in notesCollection){
           if(tempNote==note){
               val tempComment = tempNote.comment?.copy(isDeleted = true)
           }
       }
    }
}
