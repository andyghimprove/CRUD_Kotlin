package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.domain.repository.FindClientName
import com.andygomez.newcrud.command.infrastructure.FindClientNameAdapter

import org.springframework.stereotype.Service

@Service
class FindClientNameUseCase(private val findClientName: FindClientName) {

    fun findByName(name: String): ClientModel? {
        return findClientName.findByName(name)
    }
}