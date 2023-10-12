package com.andygomez.newcrud.client.query.api

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.ClientStatus

interface FindStatusQuery {
    fun findStatus(status: ClientStatus): List<ClientModel>
}