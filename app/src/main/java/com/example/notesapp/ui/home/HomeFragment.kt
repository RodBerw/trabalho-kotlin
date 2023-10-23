package com.example.notesapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.Note
import com.example.notesapp.NoteAdapter
import com.example.notesapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val noteAdapter = NoteAdapter(mutableListOf())

        val rvNotes : RecyclerView = binding.rvNotes
        rvNotes.adapter = noteAdapter
        rvNotes.layoutManager = GridLayoutManager(requireContext(),2)

        val btnAddNote : Button = binding.btnAddNote
        val etNote : EditText = binding.etNote

        btnAddNote.setOnClickListener{

            val noteContent = etNote.text.toString()

            if(noteContent.isNotEmpty()){
                val note = Note(noteAdapter.notes.size, noteContent)
                noteAdapter.addNote(note)
                etNote.text.clear()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}