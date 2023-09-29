package com.andygomez.newcrud.query.web

import com.andygomez.newcrud.command.domain.Client
import com.andygomez.newcrud.command.domain.repository.FindClientName
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class FindClientNameGraphQL(private val service: FindClientName) {

    @DgsQuery
    fun findClientByName(@InputArgument name: String): List<Client> {
        return service.findByName(name)
    }

}