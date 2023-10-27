package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.database.Note
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlin.math.log


class HistoryAdapter(val history:MutableList<Note>) : RecyclerView.Adapter<HistoryAdapter.NoteViewHolder>() {

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

    override fun getItemCount(): Int {
        return history.size
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val currentNote = history[position]
        holder.itemView.apply {
            val txtNote: TextView = findViewById(R.id.txtNote)
            val itemConstraintLayout: ConstraintLayout = findViewById(R.id.itemNote)
            txtNote.text = currentNote.notation
        }
    }


    fun updateData(newNotes: List<Note>) {
        history.clear()
        history.addAll(newNotes)
        notifyDataSetChanged()
    }



}