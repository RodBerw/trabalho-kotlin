package com.example.notesapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NoteDao {

    @Insert suspend fun insertNote(note: Note)

    @Delete suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM notes ORDER BY id")fun getNotes(): MutableList<Note>

//    @Insert suspend fun insertDeletedNote(note: DeletedNote)
}