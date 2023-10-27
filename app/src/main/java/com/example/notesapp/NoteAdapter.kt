package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.notesapp.database.Note
import com.example.notesapp.database.NoteDatabase
import com.example.notesapp.ui.home.HomeFragment
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    var notes = MainActivity.notes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val database = MainActivity.database

        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.note,
                parent,
                false
            )

        )
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        notifyItemInserted(notes.size - 1)
        var currentNote = notes[position]
        holder.itemView.apply {
            val txtNote: TextView = findViewById(R.id.txtNote)
            val itemConstraintLayout: ConstraintLayout = findViewById(R.id.itemNote)
            txtNote.text = currentNote.notation
        }
    }

    fun getNotes(db: DatabaseReference): MutableList<Note>{
        for
    }
}