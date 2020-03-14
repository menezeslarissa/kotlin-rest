package br.com.laris.wsbase.controller

import br.com.laris.wsbase.model.Note
import br.com.laris.wsbase.service.NoteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController //com essa anotação fazemos com que as respostas das funções do controller que foram
//mapeadas tenham o responsebody por padrão
@RequestMapping("notes")
class NoteController(private val noteService: NoteService){

//    @Autowired
//   lateinit var noteRepository : NoteRepository //lateinit define que a propriedade terá uma inicialização atrasada
    //var são mutable e val são read-only
    @GetMapping
   // @ResponseBody //resposta será apresentada no corpo da requisição
    fun list(): ResponseEntity<List<Note>>{
        return ResponseEntity.ok(noteService.all().toList())
    }

    @PostMapping
    fun add(@RequestBody note : Note) : ResponseEntity<Note>{
        return ResponseEntity.ok(noteService.save(note))
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long,
               @RequestBody note : Note): ResponseEntity<Note>{
        if(noteService.existsById(id)){
            return ResponseEntity.ok(noteService.update(id, note))
        }
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Unit>{
        if(noteService.existsById(id)){
            noteService.deleteById(id)
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }

}