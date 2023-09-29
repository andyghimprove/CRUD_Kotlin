package com.andygomez.newcrud.query.web

import com.andygomez.newcrud.command.domain.Client
import com.andygomez.newcrud.command.domain.repository.FindAllClient
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery

@DgsComponent
class FindAllClientGraphQL(private val service: FindAllClient) {

    @DgsQuery
    fun getAllClient(): List<Client> {
        return service.findAll()
    }

}