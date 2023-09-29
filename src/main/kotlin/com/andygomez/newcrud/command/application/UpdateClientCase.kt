package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.Client
import com.andygomez.newcrud.command.web.model.UpdateClientInput
import com.andygomez.newcrud.command.domain.repository.UpdateClient
import org.springframework.stereotype.Service

@Service
class UpdateClientCase(private val repository: UpdateClient) {

    fun updateClient(id: Int, updateClient: UpdateClientInput): Client {
        val existingClient = repository.findById(id).orElseThrow { NoSuchElementException("Cliente no encontrado") }

        // Actualiza los campos del cliente existente con los valores del DTO
        existingClient.name = updateClient.name
        existingClient.lastName = updateClient.lastName
        existingClient.email = updateClient.email

        // Guarda los cambios en el repositorio
        return repository.save(existingClient)
    }
}