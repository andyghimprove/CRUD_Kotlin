package com.andygomez.newcrud.client.command.domain

data class ClientModel(
    val id: Int?,
    var name: String?,
    var last_name: String?,
    var email: String?,
    var payment_amount: Int,
    var status: ClientStatus
)