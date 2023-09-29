package com.andygomez.newcrud.command.domain.repository

import com.andygomez.newcrud.command.domain.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UpdateClient : JpaRepository<Client, Int> {
}