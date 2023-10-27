package com.example.notesapp

import NoteDatabase
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import com.example.notesapp.database.Note
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.ui.history.HistoryFragment
import com.example.notesapp.ui.home.HomeFragment
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {

    private val selectedColor: String = "#4B462C"
    private val nonSelectedColor: String = "#D1C8B7"


    companion object{
        var notes: MutableList<Note> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var database = NoteDatabase.database


        fun SetNavColors(notesColor:String, historyColor:String){
            binding.btnNotes.setColorFilter(notesColor.toColorInt());
            binding.tvNotes.setTextColor(notesColor.toColorInt());
            binding.btnHistory.setColorFilter(historyColor.toColorInt());
            binding.tvHistory.setTextColor(historyColor.toColorInt());
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, HomeFragment())
            SetNavColors(selectedColor, nonSelectedColor)
            commit()
        }

        val btnNotes : ImageButton = binding.btnNotes
        val btnHistory : ImageButton = binding.btnHistory

        btnNotes.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, HomeFragment())
                SetNavColors(selectedColor, nonSelectedColor)
                commit()
            }
        }

        btnHistory.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, HistoryFragment())
                SetNavColors(nonSelectedColor, selectedColor)
                commit()
            }
        }


    }

}