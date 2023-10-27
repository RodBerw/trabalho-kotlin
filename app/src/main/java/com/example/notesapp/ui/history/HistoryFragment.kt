package com.example.notesapp.ui.history

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.NoteAdapter
import com.example.notesapp.database.Note
import com.example.notesapp.databinding.FragmentHomeBinding
import com.example.notesapp.databinding.FragmentNotificationsBinding
import com.example.notesapp.databinding.HistoryBinding
import com.google.firebase.firestore.FirebaseFirestore

class HistoryFragment : Fragment() {

    var history: MutableList<Note> = mutableListOf<Note>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var database = NoteDatabase.database
        var binding = HistoryBinding.inflate(inflater, container, false)



        val noteAdapter = NoteAdapter(history)
        val rvHistory : RecyclerView = binding.rvHistory
        rvHistory.adapter = noteAdapter
        rvHistory.layoutManager = GridLayoutManager(requireContext(),2)

        getHistory(database, noteAdapter)

        return binding.root
    }

    private fun getHistory(db: FirebaseFirestore, noteAdapter: NoteAdapter){
        db.collection("history").get().addOnSuccessListener {
                result ->
            Log.d(ContentValues.TAG, "Document count: ${result.size()}")
            var newNotes = mutableListOf<Note>()
            for(document in result){
                val notation = document.getString("notation")?: ""
                val note = Note(notation)
                newNotes.add(note)
            }
            noteAdapter.updateData(newNotes)
            history = newNotes
        }.addOnFailureListener { exception ->
            Log.i(ContentValues.TAG, "getNotes: $exception")
        }
    }

}