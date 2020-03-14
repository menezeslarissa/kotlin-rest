package br.com.laris.wsbase

import br.com.laris.wsbase.model.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long> {
}