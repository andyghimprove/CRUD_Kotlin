package com.andygomez.newcrud.client.query.api

import com.andygomez.newcrud.client.command.domain.ClientModel

interface FindNameQuery {

    fun findByName(name: String): ClientModel?

}