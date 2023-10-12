package com.andygomez.newcrud.client.command.web

import com.andygomez.newcrud.client.command.application.CreateClientUseCase
import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.web.model.ClientInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class CreateClientMutation(private val service: CreateClientUseCase) {
    @DgsMutation
    fun createNewClient(@InputArgument("newClient") client: ClientInput?): ClientModel {
        if (client == null) {
            throw IllegalArgumentException("Client cannot be null")
        }

        return service.createNewClient(client)
    }
}