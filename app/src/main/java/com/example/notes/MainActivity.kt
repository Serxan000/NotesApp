package com.example.notes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notes.db.NoteDatabase
import com.example.notes.rp.NoteRP
import com.example.notes.viewModel.NoteViewModel
import com.example.notes.viewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupViewModel()
    }

    private fun setupViewModel() {
        // NoteDatabase üçün Application context istifadə et
        val noteDatabase = NoteDatabase.getInstance(applicationContext)
        val noteRp = NoteRP(noteDatabase)

        // ViewModel factory yarat
        val factory = NoteViewModelFactory(application, noteRp)

        // ViewModelProvider ilə ViewModel-i al
        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
    }

}