package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.Client
import com.andygomez.newcrud.command.domain.repository.FindAllClient
import org.springframework.stereotype.Service

@Service
class FindAllClientCase(private val repository: FindAllClient) {

    fun getAllClient(): List<Client> {
        return repository.findAll()
    }
}