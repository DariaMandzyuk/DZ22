fun main() {
    val noteVneshnii = Note(0, 0)
    NotesService.add(noteVneshnii)
    NotesService.add(noteVneshnii)
    NotesService.get()
}

