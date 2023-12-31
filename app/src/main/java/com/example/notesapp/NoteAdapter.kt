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


class NoteAdapter(val notes:MutableList<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

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
        return notes.size
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val currentNote = notes[position]
        holder.itemView.apply {
            val txtNote: TextView = findViewById(R.id.txtNote)
            val itemConstraintLayout: ConstraintLayout = findViewById(R.id.itemNote)
            txtNote.text = currentNote.notation
        }
    }


    fun updateData(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

//    fun getNotes(db: DatabaseReference){
//        db.child("notes").get().addOnSuccessListener {
//            resNotes -> if(resNotes != null){
//            val t: GenericTypeIndicator<MutableList<Note>> = object : GenericTypeIndicator<MutableList<Note>>() {}
//            notes = resNotes.getValue(t)!!
//        }
//        }
//    }


}