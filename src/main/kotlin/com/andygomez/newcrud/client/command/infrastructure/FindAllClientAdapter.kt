package com.andygomez.newcrud.client.command.infrastructure

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.repository.FindAllClient
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class FindAllClientAdapter(private val dsl: DSLContext) : FindAllClient {
    override fun findAllClients(): List<ClientModel> {
        val result = dsl.selectFrom(Client.CLIENT)
            .fetchInto(ClientModel::class.java)
        return result
    }
}