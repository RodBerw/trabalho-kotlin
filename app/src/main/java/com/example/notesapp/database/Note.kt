package com.example.notesapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties data class Note(
    val id: Int,
    val notation:String
)
