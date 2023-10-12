package com.andygomez.newcrud.client.command.web.model

data class ClientInput(
    val name: String,
    val last_name: String,
    val email: String,
    var payment_amount: Int
)