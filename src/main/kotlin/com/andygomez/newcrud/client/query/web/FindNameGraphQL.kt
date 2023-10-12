package com.andygomez.newcrud.client.query.web

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.query.persistance.FindNameAdapter
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class FindNameGraphQL(private val service: FindNameAdapter) {
    @DgsQuery
    fun findByName(name: String): ClientModel? {
        return service.findByName(name)
    }
}