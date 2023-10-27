package com.example.notesapp.ui.add

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.MainActivity
import com.example.notesapp.NoteAdapter
import com.example.notesapp.R
import com.example.notesapp.database.Note
import com.example.notesapp.database.NoteDao
import com.example.notesapp.database.NoteDatabase
import com.example.notesapp.databinding.CreateNoteBinding
import com.example.notesapp.ui.home.HomeFragment
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateNote : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var binding = CreateNoteBinding.inflate(inflater, container, false)
        var database = HomeFragment.database
        var notes = MainActivity.notes

        val btnConfirm = binding.btnConfirm

        btnConfirm.setOnClickListener {
            val noteText = binding.txtInputNewNote.text.toString()
            val newNote: Note = Note(notes.size, notation = noteText)

            insertNote(newNote, database)

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, HomeFragment())
                commit()
            }
        }

        return binding.root
    }

    fun insertNote(note: Note, db: DatabaseReference){
        db.child("notes").child(note.id.toString()).setValue(note)
    }

}

