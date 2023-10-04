package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.domain.repository.CreateClient
import com.andygomez.newcrud.command.infrastructure.adapter.CreateClientAdapter
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Service

@Service
class CreateClientCase(private val adapter: CreateClientAdapter) : CreateClient {
    override fun createNewClient(clientModel: ClientModel): ClientModel {
        return adapter.createNewClient(clientModel)
    }
}