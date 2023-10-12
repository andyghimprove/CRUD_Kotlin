package com.andygomez.newcrud.client.command.domain.repository

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.ClientStatus

interface FindStatusClient {
    fun findStatusClient(status: ClientStatus): List<ClientModel>
}