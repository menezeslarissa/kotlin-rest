package br.com.laris.wsbase.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
//data class implementa algumas funções padrões como equals, hashCode, toString...
@Entity
data class Note(@Id
           @GeneratedValue
            @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
            val id : Long = 0L,
        val title: String= "", val description: String = "")