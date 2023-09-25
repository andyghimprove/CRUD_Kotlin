package com.andygomez.newcrud.service

import com.andygomez.newcrud.exception.ClientException
import com.andygomez.newcrud.model.Client
import com.andygomez.newcrud.repository.ClientRepository
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class ClientService(private val repository: ClientRepository) {

    fun getAllClient(): List<Client> {
        return repository.findAll()
    }

    fun findClientByName(name: String): List<Client> {
        return repository.findByName(name)
    }

    fun createNewClient(client: Client): Client {
        return repository.save(client)
    }

    fun updateClient(id: Int, updateClient: Client): Client {
        val existingClient = repository.findById(id)
            .orElseThrow { ClientException("Person with id $id not found") }

        val updatedName = updateClient.name
        val updatedLastName = updateClient.lastName
        val updatedEmail = updateClient.email

        val updatedExistingClient = existingClient.copy(
            name = updatedName,
            lastName = updatedLastName,
            email = updatedEmail
        )



        return repository.save(updatedExistingClient)
    }

}