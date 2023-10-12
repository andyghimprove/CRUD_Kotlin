package com.andygomez.newcrud.client.query.persistance

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.query.api.FindAllQuery
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class FindAllAdapter(private val dsl: DSLContext) : FindAllQuery {

    override fun findAllClients(): List<ClientModel> {
        val result = dsl.selectFrom(Client.CLIENT)
            .fetchInto(ClientModel::class.java)
        return result
    }
}
