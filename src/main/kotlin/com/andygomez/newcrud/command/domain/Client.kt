package com.andygomez.newcrud.command.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Client")
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") val id: Int?,
    @Column(name = "name") var name: String?,
    @Column(name = "last_name") var lastName: String?,
    @Column(name = "email") var email: String?
)