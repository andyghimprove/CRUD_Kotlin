package com.andygomez.newcrud.command.application

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.domain.repository.FindClientName
import com.andygomez.newcrud.command.web.model.UpdateClientInput
import com.andygomez.newcrud.command.domain.repository.UpdateClient
import com.andygomez.newcrud.command.infrastructure.adapter.FindClientNameAdapter
import com.andygomez.newcrud.command.infrastructure.adapter.UpdateClientAdapter
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Service

@Service
class UpdateClientCase(private val adapter: UpdateClientAdapter) : UpdateClient {
    override fun updateClient(id: Int, updateClient: ClientModel): ClientModel? {
        return adapter.updateClient(id, updateClient)
    }

}