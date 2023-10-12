package com.andygomez.newcrud.client.command.infrastructure

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.repository.FindClientName
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class FindClientNameAdapter(private val dsl: DSLContext) : FindClientName {
    override fun findByName(name: String): ClientModel? {
        return dsl.selectFrom(Client.CLIENT)
            .where(Client.CLIENT.NAME.eq(name))
            .fetchOneInto(ClientModel::class.java)
    }
}