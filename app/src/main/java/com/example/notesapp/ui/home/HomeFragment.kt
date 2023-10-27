package com.example.notesapp.ui.home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.NoteAdapter
import com.example.notesapp.R
import com.example.notesapp.database.Note
import com.example.notesapp.databinding.FragmentHomeBinding
import com.example.notesapp.ui.add.CreateNote
import com.google.firebase.firestore.FirebaseFirestore
import android.util.Log

class HomeFragment : Fragment() {


    private lateinit var noteAdapter: NoteAdapter
    var notes: MutableList<Note> = mutableListOf<Note>()
    var notesHistory : MutableList<Note> = notes



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var database = NoteDatabase.database
        var binding = FragmentHomeBinding.inflate(inflater, container, false)



        val noteAdapter = NoteAdapter(notes)
        val rvNotes : RecyclerView = binding.rvNotes
        rvNotes.adapter = noteAdapter
        rvNotes.layoutManager = GridLayoutManager(requireContext(),2)

        val btnAddNote : ImageButton = binding.btnAddNote

        getNotes(database, noteAdapter)

        btnAddNote.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragmentContainerView, CreateNote())
                commit()
            }
        }

        val btnClear = binding.btnClear

        btnClear.setOnClickListener{
            database.collection("notes").get().addOnSuccessListener {
                result -> for (document in result){
                    val doc = database.collection("notes").document(document.id)
                    doc.delete()
                    val oldNote = Note(document.getString("notation")?: "")
                    database.collection("history").add(oldNote)
            }
                notes.clear()
                noteAdapter.updateData(notes)
            }
        }

        return binding.root
    }

    private fun getNotes(db: FirebaseFirestore, noteAdapter: NoteAdapter){
        db.collection("notes").get().addOnSuccessListener {
                result ->
            Log.d(TAG, "Document count: ${result.size()}")
            var newNotes = mutableListOf<Note>()
            for(document in result){
            val notation = document.getString("notation")?: ""
            val note = Note(notation)
            newNotes.add(note)
        }
            noteAdapter.updateData(newNotes)
            notes = newNotes
        }.addOnFailureListener { exception ->
            Log.i(TAG, "getNotes: $exception")
        }
    }

}