package com.andygomez.newcrud.fetcher

import com.andygomez.newcrud.model.Client
import com.andygomez.newcrud.service.ClientService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument


@DgsComponent
class ClientDataFetcher (private val service: ClientService){

    @DgsQuery
    fun getAllClient(): List<Client> {
        return service.getAllClient()
    }

    @DgsQuery
    fun findClientByName(@InputArgument name: String): List<Client> {
        return service.findClientByName(name)
    }

    @DgsMutation
    fun createNewClient(@InputArgument client: Client): Client {
        return service.createNewClient(client)
    }

    @DgsMutation
    fun updateClient(@InputArgument id: Int, @InputArgument updateClient: Client): Client {
        return service.updateClient(id, updateClient)
    }
}