package com.andygomez.newcrud.client.command.web

import com.andygomez.newcrud.client.command.application.UpdateClientUseCase
import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.web.model.ClientUpdateInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class UpdateClientMutation(private val service: UpdateClientUseCase) {
    @DgsMutation
    fun updateClient(
        @InputArgument id: Long,
        @InputArgument updateClient: ClientUpdateInput
    ): ClientModel {
        return service.updateClient(id, updateClient)
    }
}