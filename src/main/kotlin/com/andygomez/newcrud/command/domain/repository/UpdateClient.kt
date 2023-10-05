package com.andygomez.newcrud.command.domain.repository

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.web.model.UpdateClientInput

interface UpdateClient {
    fun updateClientById(id: Int, update: UpdateClientInput): ClientModel?
}