package com.andygomez.newcrud.query.web

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.domain.repository.FindClientName
import com.andygomez.newcrud.query.api.FindNameQuery
import com.andygomez.newcrud.query.persistance.FindNameAdapter
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class FindClientNameGraphQL(private val service: FindNameAdapter) {

    @DgsQuery
    fun findClientByName(@InputArgument name: String): ClientModel? {
        return service.findByName(name)
    }

}