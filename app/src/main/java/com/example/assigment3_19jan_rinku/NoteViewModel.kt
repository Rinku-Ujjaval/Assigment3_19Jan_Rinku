package com.example.assigment3_19jan_rinku

import androidx.lifecycle.ViewModel
import com.example.assigment3_19jan_rinku.model.Note

class NoteViewModel : ViewModel() {

    companion object {
        var count = 0
    }

    val listNotes: MutableList<Note> = mutableListOf()


    init {
        fetchNotList()
    }

    fun fetchNotList(): MutableList<Note> {
        return listNotes
    }

    fun addNote(title: String, content: String) {
        listNotes.add(Note(count, title, content))
        count++
    }

    fun updateNote(note: Note) {
        listNotes.forEach {
            if (it.id == note.id) {
                listNotes[it.id!!] = note
            }
        }
    }

}