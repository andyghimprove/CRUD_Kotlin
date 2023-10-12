package com.andygomez.newcrud.client.command.application

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.repository.CreateClient
import com.andygomez.newcrud.client.command.web.model.ClientInput

import org.springframework.stereotype.Service

@Service
class CreateClientUseCase(private val createClientAdapter: CreateClient) {
    fun createNewClient(input: ClientInput): ClientModel {
        return createClientAdapter.createNewClient(input)
    }
}