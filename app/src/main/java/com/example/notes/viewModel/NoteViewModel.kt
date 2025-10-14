package com.example.notes.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.model.Note
import com.example.notes.rp.NoteRP
import kotlinx.coroutines.launch

class NoteViewModel(app:Application,private val noterp:NoteRP):AndroidViewModel(app) {

    fun addNote(note: Note) =
        viewModelScope.launch {
            noterp.insertNote(note)
        }

    fun deleteNote(note: Note) =
        viewModelScope.launch {
            noterp.deleteNote(note)
        }

    fun updateNote(note: Note) =
        viewModelScope.launch {
            noterp.updateNote(note)
        }

    fun getAllNotes() = noterp.getAllNote()

    fun searchNote(query:String?) =
        noterp.searchNote(query)
}