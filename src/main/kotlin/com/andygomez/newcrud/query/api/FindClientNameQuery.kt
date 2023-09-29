package com.andygomez.newcrud.query.api

import com.andygomez.newcrud.command.domain.Client
import org.springframework.data.jpa.repository.JpaRepository

interface FindClientNameQuery : JpaRepository<Client, Int> {

    fun findByName(name: String): List<Client>

}