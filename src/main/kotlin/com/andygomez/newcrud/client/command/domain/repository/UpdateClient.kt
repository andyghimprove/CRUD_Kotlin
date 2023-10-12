package com.andygomez.newcrud.client.command.domain.repository

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.web.model.ClientInput
import com.andygomez.newcrud.client.command.web.model.ClientUpdateInput

interface UpdateClient {
    fun updateClient(id: Long, input: ClientUpdateInput): ClientModel
}