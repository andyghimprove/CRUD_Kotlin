package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.domain.repository.CreateClient
import com.andygomez.newcrud.command.web.model.CreateClientInput


import org.springframework.stereotype.Service

@Service
class CreateClientUseCase(private val createClientAdapter: CreateClient) {
    fun createNewClient(input: CreateClientInput): ClientModel {
        return createClientAdapter.createNewClient(input)
    }
}