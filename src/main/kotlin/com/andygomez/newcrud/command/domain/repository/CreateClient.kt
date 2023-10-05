package com.andygomez.newcrud.command.domain.repository

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.web.model.CreateClientInput


interface CreateClient {
    fun createNewClient(input: CreateClientInput): ClientModel
}