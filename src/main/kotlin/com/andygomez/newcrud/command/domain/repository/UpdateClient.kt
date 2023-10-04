package com.andygomez.newcrud.command.domain.repository

import com.andygomez.newcrud.command.domain.ClientModel
import com.andygomez.newcrud.command.web.model.UpdateClientInput
import org.springframework.stereotype.Repository

@Repository
interface UpdateClient{

    fun updateClient(id: Int, updateClient: ClientModel): ClientModel?

}