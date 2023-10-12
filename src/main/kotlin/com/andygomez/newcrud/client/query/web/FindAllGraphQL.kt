package com.andygomez.newcrud.client.query.web

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.query.persistance.FindAllAdapter
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery

@DgsComponent
class FindAllGraphQL(private val service: FindAllAdapter) {
    @DgsQuery
    fun findAllClient(): List<ClientModel> {
        return service.findAllClients()
    }
}