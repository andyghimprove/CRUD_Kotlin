package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.domain.repository.FindAllClient
import com.andygomez.newcrud.command.infrastructure.FindAllClientAdapter
import org.springframework.stereotype.Service

@Service
class FindAllClientUseCase(private val findAll: FindAllClient)  {
    fun findAllClient(): List<ClientModel> {
        return findAll.findAllClient()
    }
}