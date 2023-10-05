package com.andygomez.newcrud.command.web

import com.andygomez.newcrud.command.application.CreateClientUseCase
import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.web.model.CreateClientInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class CreateClientMutation(private val service: CreateClientUseCase) {
    @DgsMutation
    fun createNewClient(@InputArgument client: CreateClientInput?): ClientModel {
        if (client == null) {
            throw IllegalArgumentException("client cannot be null")
        }
        return service.createNewClient(client)
    }
}