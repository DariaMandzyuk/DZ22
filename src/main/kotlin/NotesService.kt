object NotesService {
    private var notes = mutableListOf<Note>()  // создала коллекцию с именем notes
    private var lastId = 0
    // если просто запомнить предыдущий айдишник, то не придется перебирать весь массив
    // ++lastId когда ++ до имени переменной, то сначала берется текущее значение этой переменной, увеличивается на единицу и возвращается в присваивание
    // lastId++ сначала ++ присваивается в переменную и только потом текущая переменная увеличивается на 1

    fun clear() {
        notes = mutableListOf()
        lastId = 0
    }

    fun add(note: Note): Int {
        notes += note.copy(id = ++lastId)
        return notes.last().id // бращаюсь к массиву notes. вызываю в нем метод last(). и обращаюсь к объекту, который он вернул через last беру у него id
    }
    //ситуация: в функции меин объявили переменную note, ее добавили в массив через сервис, а потом в мейне
    //эту переменную note поменяли, в результате чего у нас пост внутри массива тоже поменялся
    //чтобы от этого защититься нужно использовать оператор .copy()
    //когда мы добавляем в массив *notes += note мы добавляем по сути ссылку на объект из функции мейн
    //мы можем сделать локальную копию, которая нигде, кроме нашего сервиса не будет храниться
    //note.copy() создает другой объект с теми же полями, что были у исходного и этот другой объект добавляется в массив постов
    //функция copy() создает объект в который записываются все значения старого объекта, если мы хотим изменить какие-то из полей, то указываем в скобках = параметры функции

    fun get(): MutableList<Note> {
        val listOfNotDeletedNotes = mutableListOf<Note>()
        for (note in notes) {
            if (!note.isDeleted) {
                listOfNotDeletedNotes.add(note)
            }
        }
        return listOfNotDeletedNotes
    }

    fun createComment(noteId: Int, commentVneshnii: Comment): Int {
        for (note in notes) {
            if (note.id == noteId && !note.isDeleted) {
                note.comments += commentVneshnii
                return note.comments.last().id
            }
        }
        throw NoteNotFoundException("Note with id $noteId not found or deleted")
    }

    fun delete(id: Int): Boolean {
        for (note in notes) {
            if (note.id == id) {
                note.isDeleted = true
                return true
            }
        }
        throw NoteNotFoundException("Note with id $id not found")
    }

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        for (note in notes) {
            if (note.id == noteId && !note.isDeleted) {
                for (comment in note.comments) {
                    if (comment.id == commentId && !comment.isDeleted) {
                        comment.isDeleted = true
                        return true
                    }
                }
                throw CommentNotFoundException("Comment with id $commentId not found or deleted")
            }
            return false
        }
        throw NoteNotFoundException("Note with id $noteId not found or deleted")
    }

    fun edit(noteId: Int, newTitle: String, newText: String): Boolean {
        for (note in notes) {
            if (note.id == noteId && !note.isDeleted) {
                note.text = newText
                note.title = newTitle
                return true
            }
        }
        throw NoteNotFoundException("Note with id $noteId not found or deleted")
    }

    fun editComment(noteId: Int, commentId: Int, commentText: String): Boolean {
        for (note in notes) {
            if (note.id == noteId && !note.isDeleted) {
                for (comment in note.comments) {
                    if (comment.id == commentId && !comment.isDeleted) {
                        comment.text = commentText
                        return true
                    }
                }
                throw CommentNotFoundException("Comment with id $commentId not found or deleted")
            }
        }
        throw NoteNotFoundException("Note with id $noteId not found or deleted")
    }

    fun getById(id: Int): Note {
        for (note in notes) {
            if (!note.isDeleted && note.id == id) {
                return note
            }
        }
        throw NoteNotFoundException("Note with id $id not found or deleted")
    }

    fun getComments(noteId: Int): MutableList<Comment> {
        val listOfNotDeletedComments = mutableListOf<Comment>()
        for (note in notes) {
            if (!note.isDeleted && note.id == noteId) {
                for (comment in note.comments) {
                    if (!comment.isDeleted) {
                        listOfNotDeletedComments.add(comment)
                    }
                }
            }
        }
        return listOfNotDeletedComments
    }

    fun restoreComment(noteId: Int, commentId: Int): Boolean {
        for (note in notes) {
            if (note.id == noteId && !note.isDeleted) {
                for (comment in note.comments) {
                    if (comment.id == commentId && comment.isDeleted) {
                        comment.isDeleted = false
                        return true
                    }
                }
                throw CommentNotFoundException("Comment with id $commentId not found or deleted")
            }
        }
        throw NoteNotFoundException("Note with id $noteId not found or deleted")
    }
}





