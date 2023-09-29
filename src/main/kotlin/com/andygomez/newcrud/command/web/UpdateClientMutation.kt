package com.andygomez.newcrud.command.web

import com.andygomez.newcrud.command.application.UpdateClientCase
import com.andygomez.newcrud.command.domain.Client
import com.andygomez.newcrud.command.web.model.UpdateClientInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class UpdateClientMutation(private val service: UpdateClientCase) {

    @DgsMutation
    fun updateClient(@InputArgument id: Int, @InputArgument updateClient: UpdateClientInput): Client {
        return service.updateClient(id, updateClient)
    }

}