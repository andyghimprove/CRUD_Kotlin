package com.andygomez.newcrud.client.command.web.model

data class ClientUpdateInput(
    val name: String?,
    val last_name: String?,
    val email: String?,
    val payment_amount: Int?
)