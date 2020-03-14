package br.com.laris.wsbase.service

import br.com.laris.wsbase.NoteRepository
import br.com.laris.wsbase.model.Note
import org.springframework.stereotype.Service

@Service
class NoteService (private val noteRepository: NoteRepository){

    fun all(): List<Note>{
        return noteRepository.findAll().toList()
    }

    fun deleteById(id: Long){
        noteRepository.deleteById(id)
    }

    fun existsById(id: Long) : Boolean{
        return noteRepository.existsById(id)
    }

    fun save(note : Note): Note{
        return noteRepository.save(note)
    }

    fun update(id: Long, note: Note): Note{
        var safeNote = note.copy(id = id)
        return save(safeNote)
    }
}