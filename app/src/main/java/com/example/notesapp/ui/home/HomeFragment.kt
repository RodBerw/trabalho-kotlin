package com.example.notesapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.notesapp.NoteAdapter
import com.example.notesapp.R
import com.example.notesapp.database.NoteDao
import com.example.notesapp.database.NoteDatabase
import com.example.notesapp.databinding.FragmentHomeBinding
import com.example.notesapp.ui.add.CreateNote
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class HomeFragment : Fragment() {


    private lateinit var noteAdapter: NoteAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var binding = FragmentHomeBinding.inflate(inflater, container, false)

        val noteAdapter = NoteAdapter()

        val rvNotes : RecyclerView = binding.rvNotes
        rvNotes.adapter = noteAdapter
        rvNotes.layoutManager = GridLayoutManager(requireContext(),2)

        val btnAddNote : ImageButton = binding.btnAddNote

        btnAddNote.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragmentContainerView, CreateNote())
                commit()
            }
        }

        return binding.root
    }

}