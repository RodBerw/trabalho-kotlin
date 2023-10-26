package com.example.notesapp.database

import androidx.lifecycle.ViewModel

class NoteViewModel(private  val dao: NoteDao): ViewModel() {
    suspend fun insertNote(note: Note){
        dao.insertNote(note)
    }


    suspend fun getNotes(){
        val activeNotes = dao.getNotes()
    }
}