package com.andygomez.newcrud.client.query.api

import com.andygomez.newcrud.client.command.domain.ClientModel

interface FindAllQuery {
    fun findAllClients(): List<ClientModel>
}