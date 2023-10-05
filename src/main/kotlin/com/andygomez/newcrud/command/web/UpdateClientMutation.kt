package com.andygomez.newcrud.command.web

import com.andygomez.newcrud.command.application.UpdateClientUseCase
import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.web.model.UpdateClientInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class UpdateClientMutation(private val service: UpdateClientUseCase) {
    @DgsMutation
    fun updateClient(@InputArgument id: Int, @InputArgument client: UpdateClientInput): ClientModel? {
        return service.updateClientById(id, client)
    }
}