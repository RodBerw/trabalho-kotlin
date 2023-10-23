package com.example.notesapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    val notes: MutableList<Note>
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.note,
                parent,
                false
            )
        )
    }

    fun addNote(note: Note){
        notes.add(note)
        notifyItemInserted(notes.size - 1)
    }

//    fun deleteNote(id: Int){
//        notes.removeAll { note ->
//            note.id == id
//        }
//    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var currentNote = notes[position]
        holder.itemView.apply {
            val txtNote: TextView = findViewById(R.id.txtNote)
            val itemConstraintLayout: ConstraintLayout = findViewById(R.id.itemNote)
            txtNote.text = currentNote.notation
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}