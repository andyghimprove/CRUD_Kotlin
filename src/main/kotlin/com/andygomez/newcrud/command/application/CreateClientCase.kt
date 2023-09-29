package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.Client
import com.andygomez.newcrud.command.domain.repository.CreateClient
import org.springframework.stereotype.Service

@Service
class CreateClientCase(private val repository: CreateClient) {

    fun createNewClient(client: Client): Client {
        return repository.save(client)
    }
}