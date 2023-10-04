package com.andygomez.newcrud.command.domain.repository

import com.andygomez.newcrud.command.domain.ClientModel
import org.springframework.stereotype.Repository

@Repository
interface CreateClient  {

    fun createNewClient(clientModel: ClientModel): ClientModel

}