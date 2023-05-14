import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class NotesServiceTest {

    @Before
    fun setUp() {
        NotesService.clear()
    }

    @Test
    fun shouldAddNoteSuccessfully() {
        val note1 = Note(3, 1)
        val result = NotesService.add(note1)
        assertEquals(1, result)
    }

    @Test
    fun shouldGetExistingNotes() {
        val note1 = Note(1, 1)
        val note2 = Note(2, 2, isDeleted = true)
        val note3 = Note(3, 3)
        NotesService.add(note1)
        NotesService.add(note2)
        NotesService.add(note3)
        val listOfNotDeletedNotes = mutableListOf(note1, note3)
        val result = NotesService.get()
        assertEquals(listOfNotDeletedNotes, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowExceptionWhenGettingNonExistingNote() {
        NotesService.getById(3)
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldThrowExceptionWhenGettingNonExistingComment() {
        val note1 = Note(3, 3)
        val resultAdd = NotesService.add(note1)
        NotesService.editComment(resultAdd, 2, "H")
    }

    @Test
    fun shouldCreateCommentInTheExistingNote() {
        val note1 = Note(5, 7)
        val resultAdd = NotesService.add(note1)
        val resultComment = NotesService.createComment(resultAdd, Comment(2, 2))
        assertEquals(2, resultComment)
    }

    @Test
    fun shouldDeleteExistingNote() {
        val note1 = Note(3, 3) //завожу объект note1
        val resultAdd = NotesService.add(note1) //завожу переменную с именем resultAdd и приравниваю к ней результат функции add
        //потому что мы не знаем какой id объекта note1 внутри коллекции notes, потому что за пределами коллекции NoteService мы это никак не узнаем
        //из-за этого нам нужно завести переменную resultAdd, чтобы оперировать этим возвращенным значением
        val result = NotesService.delete(resultAdd)
        assertTrue(result)
    }

    @Test
    fun shouldDeleteCommentInTheExistingNote() {
        val note1 = Note(5, 7)
        val resultAdd = NotesService.add(note1)
        NotesService.createComment(resultAdd, Comment(3, 2))
        val resultDeleteComment = NotesService.deleteComment(resultAdd, 3)
        assertTrue(resultDeleteComment)
    }

    @Test
    fun shouldEditExistingNote() {
        val note1 = Note(5, 7)
        val resultAdd = NotesService.add(note1)
        val result = NotesService.edit(resultAdd, "добби хочет погулять", "а не вот это вот все")
        assertTrue(result)
    }

    @Test
    fun shouldEditCommentInTheExistingNote() {
        val note1 = Note(5, 7)
        val resultAdd = NotesService.add(note1)
        NotesService.createComment(resultAdd, Comment(3, 2))
        val resultEditComment = NotesService.editComment(resultAdd, 3, "Спасити")
        assertTrue(resultEditComment)
    }

    @Test
    fun shouldGetByIdExistingNote() {
        val note1 = Note(5, 7)
        val note2 = Note(6, 7)
        NotesService.add(note1)
        val resultAdd = NotesService.add(note2)
        val resultGetById = NotesService.getById(resultAdd)
        val testNote = note2.copy(id = resultAdd)
        assertEquals(testNote, resultGetById)
    }

    @Test
    fun shouldGetUndeletedComments() {
        val note1 = Note(1, 1)
        val resultAdd = NotesService.add(note1)
        val comment1 = Comment(2, 2)
        val comment2 = Comment(3, 2)
        val comment3 = Comment(4, 2, isDeleted = true)
        NotesService.createComment(resultAdd, comment1)
        NotesService.createComment(resultAdd, comment2)
        NotesService.createComment(resultAdd, comment3)
        val listOfNotDeletedComments = mutableListOf(comment1, comment2)
        val resultGetComments = NotesService.getComments(resultAdd)
        assertEquals(listOfNotDeletedComments, resultGetComments)
    }

    @Test
    fun shouldRestoreExistingComment() {
        val note1 = Note(5, 7)
        val resultAdd = NotesService.add(note1)
        NotesService.createComment(resultAdd, Comment(2, 2))
        NotesService.createComment(resultAdd, Comment(3, 2, isDeleted = true))
        val resultRestore = NotesService.restoreComment(resultAdd, 3)
        assertTrue(resultRestore)
    }
}