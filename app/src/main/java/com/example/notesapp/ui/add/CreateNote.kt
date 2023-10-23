package com.example.notesapp.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesapp.Note
import com.example.notesapp.databinding.CreateNoteBinding

class CreateNote : Fragment() {



    private var _binding: CreateNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CreateNoteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnAddNote = binding.btnConfirm

//        btnAddNote.setOnClickListener {
//            val noteText = binding.txtInputNewNote.text.toString()
//            val newNote = Note(notation = noteText)
//
//            insertNote(newNote)
//        }

        return root
    }

    private fun insertNote(note: Note) {
        // A função insert será chamada aqui
//        noteDao.insert(note)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

