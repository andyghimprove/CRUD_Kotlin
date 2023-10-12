package com.andygomez.newcrud.client.command.domain.repository

import com.andygomez.newcrud.client.command.domain.ClientModel

interface FindAllClient {
    fun findAllClients(): List<ClientModel>
}