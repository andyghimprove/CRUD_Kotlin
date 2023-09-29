package com.andygomez.newcrud.query.api

import com.andygomez.newcrud.command.domain.Client
import org.springframework.data.jpa.repository.JpaRepository

interface FindAllClientQuery : JpaRepository<Client, Int> {
}