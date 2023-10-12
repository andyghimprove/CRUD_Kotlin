package com.andygomez.newcrud.client.command.domain.repository

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.web.model.ClientInput

interface UpdateClient {
    fun updateClient(id: Long, input: ClientInput): ClientModel
}