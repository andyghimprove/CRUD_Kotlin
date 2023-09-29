package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.Client
import com.andygomez.newcrud.command.domain.repository.FindAllClient
import org.springframework.stereotype.Service

@Service
class FindClientNameCase(private val repository: FindAllClient) {

    fun findClientByName(name: String): List<Client> {
        return repository.findByName(name)
    }
}