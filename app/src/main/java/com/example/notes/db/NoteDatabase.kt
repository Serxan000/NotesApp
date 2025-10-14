package com.example.notes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase:RoomDatabase() {
         abstract fun getNoteDao():NoteDao

         companion object{
             private var instance:NoteDatabase?=null

             fun getInstance(context:Context):NoteDatabase{
                 if(instance==null){
                     instance = Room.databaseBuilder(
                         context.applicationContext,
                         NoteDatabase::class.java,
                         "note_db"

                     ).build()
                 }
                 return instance!!
             }


         }

}