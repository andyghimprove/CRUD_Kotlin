package com.andygomez.newcrud.command.domain.repository

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.jooq.tables.Client
import org.springframework.stereotype.Repository

@Repository
interface FindAllClient {
    fun findAllClient(): List<ClientModel>
}