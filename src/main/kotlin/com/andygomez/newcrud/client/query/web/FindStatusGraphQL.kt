package com.andygomez.newcrud.client.query.web

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.ClientStatus
import com.andygomez.newcrud.client.query.persistance.FindStatusAdapter
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery


@DgsComponent
class FindStatusGraphQL (private val service: FindStatusAdapter){

    @DgsQuery
    fun findStatus(status: ClientStatus): List<ClientModel> {
        return service.findStatus(status)
    }
}