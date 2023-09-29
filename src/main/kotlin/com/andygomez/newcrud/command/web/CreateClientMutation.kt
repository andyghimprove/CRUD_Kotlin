package com.andygomez.newcrud.command.web

import com.andygomez.newcrud.command.application.CreateClientCase
import com.andygomez.newcrud.command.domain.Client
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class CreateClientMutation(private val service: CreateClientCase) {

    @DgsMutation
    fun createNewClient(@InputArgument client: Client): Client {
        return service.createNewClient(client)
    }

}