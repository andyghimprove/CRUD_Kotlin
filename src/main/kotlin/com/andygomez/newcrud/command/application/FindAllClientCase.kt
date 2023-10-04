package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.domain.repository.CreateClient
import com.andygomez.newcrud.command.domain.repository.FindAllClient
import com.andygomez.newcrud.command.infrastructure.adapter.FindAllClientAdapter
import org.springframework.stereotype.Service

@Service
class FindAllClientCase(private val adapter: FindAllClientAdapter) : FindAllClient {
    override fun findAllClient(): List<ClientModel> {
        return adapter.findAllClient()
    }
}