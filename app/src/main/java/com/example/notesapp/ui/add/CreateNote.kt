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

//        val noteDatabase = Room.databaseBuilder(
//            requireContext(),
//            NoteDatabase::class.java,
//            "NoteDatabase"
//        ).build()

        //HomeFragment.noteDao = noteDatabase.dao

        //val dao = noteDatabase.dao

        val btnConfirm = binding.btnConfirm

        btnConfirm.setOnClickListener {
            val noteText = binding.txtInputNewNote.text.toString()
            val newNote: Note = Note(notation = noteText)

            GlobalScope.launch(Dispatchers.IO) {
                //dao.insertNote(newNote)
            }

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, HomeFragment())
                commit()
            }
        }

        return binding.root
    }



}

