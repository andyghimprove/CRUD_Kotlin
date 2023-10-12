package com.andygomez.newcrud.client.command.domain

data class ClientModel(
    val id: Long?,
    var name: String?,
    var last_name: String?,
    var email: String?,
    var payment_amount: Int,
    var status: ClientStatus
)