package com.andygomez.newcrud.client.command.infrastructure

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.ClientStatus
import com.andygomez.newcrud.client.command.domain.repository.FindStatusClient
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class FindStatusClientAdapter(private val dsl: DSLContext) : FindStatusClient {
    override fun findStatusClient(status: ClientStatus): List<ClientModel> {
        return dsl.selectFrom(Client.CLIENT)
            .where(Client.CLIENT.STATUS.eq(status.name))
            .fetchInto(ClientModel::class.java)
    }
}