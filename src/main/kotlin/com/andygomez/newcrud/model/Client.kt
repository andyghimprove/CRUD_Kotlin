package com.andygomez.newcrud.model

import javax.persistence.*

@Entity
@Table(name = "Client")
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") val id: Int? = null,
    @Column(name = "name") val name: String?,
    @Column(name = "last_name") val lastName: String?,
    @Column(name = "email") val email: String?
)


