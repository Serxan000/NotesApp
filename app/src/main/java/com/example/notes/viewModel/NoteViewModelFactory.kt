package com.example.notes.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notes.rp.NoteRP

class NoteViewModelFactory(
    private val app: Application,
    private val noteRP: NoteRP
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(app, noteRP) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

