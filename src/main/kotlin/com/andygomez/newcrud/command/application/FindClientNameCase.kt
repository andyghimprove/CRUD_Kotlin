package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.domain.repository.FindAllClient
import com.andygomez.newcrud.command.domain.repository.FindClientName
import com.andygomez.newcrud.command.infrastructure.adapter.FindAllClientAdapter
import com.andygomez.newcrud.command.infrastructure.adapter.FindClientNameAdapter
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Service

@Service
class FindClientNameCase(private val adapter: FindClientNameAdapter) : FindClientName {

    override fun findByName(name: String): ClientModel? {
        return adapter.findByName(name)
    }
}