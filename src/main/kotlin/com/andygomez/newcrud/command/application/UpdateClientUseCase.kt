package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.domain.repository.UpdateClient
import com.andygomez.newcrud.command.web.model.UpdateClientInput

import org.springframework.stereotype.Service

@Service
class UpdateClientUseCase(private val updateClientAdapter: UpdateClient) {
    fun updateClientById(id: Int, update: UpdateClientInput): ClientModel? {
        return updateClientAdapter.updateClientById(id, update)
    }
}