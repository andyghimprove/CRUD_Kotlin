package com.andygomez.newcrud.query.persistance

import com.andygomez.newcrud.command.domain.Client
import com.andygomez.newcrud.query.api.FindAllClientQuery

class FindAllClientAdapter(private val repository: FindAllClientQuery) {

    fun getAllClient(): List<Client> {
        return repository.findAll()
    }

}