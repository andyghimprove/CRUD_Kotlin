package com.andygomez.newcrud.repository


import com.andygomez.newcrud.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<Client, Int> {
    fun findByName(name: String): List<Client>
}