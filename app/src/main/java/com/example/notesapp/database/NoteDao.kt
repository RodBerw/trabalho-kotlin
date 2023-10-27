package com.example.notesapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.google.firebase.database.DatabaseReference

interface NoteDao {
    var database: DatabaseReference

//
//    @Delete suspend fun deleteNote(note: Note)
//
//    @Query("SELECT * FROM notes ORDER BY id")fun getNotes(): MutableList<Note>
//
////    @Insert suspend fun insertDeletedNote(note: DeletedNote)
}