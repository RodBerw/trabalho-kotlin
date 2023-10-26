package com.example.notesapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.database.Note
import com.example.notesapp.database.NoteDao
import com.example.notesapp.database.NoteViewModel
import com.example.notesapp.database.NoteDatabase
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.ui.history.HistoryFragment
import com.example.notesapp.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private val selectedColor: String = "#4B462C"
    private val nonSelectedColor: String = "#D1C8B7"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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