package com.andygomez.newcrud.client.command.infrastructure

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.ClientStatus
import com.andygomez.newcrud.client.command.domain.repository.CreateClient
import com.andygomez.newcrud.client.command.web.model.ClientInput
import com.andygomez.newcrud.jooq.tables.Client


import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class CreateClientAdapter(private val dsl: DSLContext) : CreateClient {
    override fun createNewClient(input: ClientInput): ClientModel {

        val clientStatus = determineClientStatus(input.payment_amount)

        val clientRecord = dsl.insertInto(Client.CLIENT)
            .set(Client.CLIENT.NAME, input.name)
            .set(Client.CLIENT.LAST_NAME, input.last_name)
            .set(Client.CLIENT.EMAIL, input.email)
            .set(Client.CLIENT.PAYMENT_AMOUNT, input.payment_amount)
            .set(Client.CLIENT.STATUS, clientStatus.name)
            .returning()
            .fetchOne()

        val clientId = clientRecord?.get(Client.CLIENT.ID)?.toLong()

        return ClientModel(
            clientId,
            input.name,
            input.last_name,
            input.email,
            input.payment_amount,
            clientStatus
        )
    }

    private fun determineClientStatus(paymentAmount: Int?): ClientStatus {
        if (paymentAmount == null) {
            throw IllegalArgumentException("paymentAmount cannot be null")
        }

        return when {
            paymentAmount <= 10 -> ClientStatus.PaymentAtTime
            paymentAmount in 11..20 -> ClientStatus.LatePayment
            else -> ClientStatus.NotPayed
        }
    }
}
