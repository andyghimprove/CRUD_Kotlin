package com.andygomez.newcrud.client.query.persistance

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.query.api.FindNameQuery
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class FindNameAdapter(private val dsl: DSLContext) : FindNameQuery {

    override fun findByName(name: String): ClientModel? {
        return dsl.selectFrom(Client.CLIENT)
            .where(Client.CLIENT.NAME.eq(name))
            .fetchOneInto(ClientModel::class.java)
    }
}