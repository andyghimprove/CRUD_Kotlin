package com.andygomez.newcrud.client.command.domain.repository

import com.andygomez.newcrud.client.command.domain.ClientModel
interface FindClientName {
    fun findByName(name: String): ClientModel?
}