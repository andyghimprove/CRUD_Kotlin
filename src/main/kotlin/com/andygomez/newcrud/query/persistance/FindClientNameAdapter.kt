package com.andygomez.newcrud.query.persistance

import com.andygomez.newcrud.command.domain.Client
import com.andygomez.newcrud.query.api.FindClientNameQuery

class FindClientNameAdapter(private val repository: FindClientNameQuery) {

    fun findClientByName(name: String): List<Client> {
        return repository.findByName(name)
    }
}