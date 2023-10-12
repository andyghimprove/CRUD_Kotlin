package com.andygomez.newcrud.client.query.persistance

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.ClientStatus
import com.andygomez.newcrud.client.query.api.FindStatusQuery
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class FindStatusAdapter(private val dsl: DSLContext) : FindStatusQuery {

    override fun findStatus(status: ClientStatus): List<ClientModel> {
        return dsl.selectFrom(Client.CLIENT)
            .where(Client.CLIENT.STATUS.eq(status.name))
            .fetchInto(ClientModel::class.java)
    }
}