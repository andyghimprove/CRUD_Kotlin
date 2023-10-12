package com.andygomez.newcrud.client.command.application

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.repository.UpdateClient
import com.andygomez.newcrud.client.command.web.model.ClientInput


import org.springframework.stereotype.Service

@Service
class UpdateClientUseCase(private val updateClientAdapter: UpdateClient) {
    fun updateClient(id: Long, input: ClientInput): ClientModel {
        return updateClientAdapter.updateClient(id, input)
    }
}