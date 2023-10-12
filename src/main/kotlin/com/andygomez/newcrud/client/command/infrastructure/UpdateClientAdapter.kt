package com.andygomez.newcrud.client.command.infrastructure

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.ClientStatus
import com.andygomez.newcrud.client.command.domain.repository.UpdateClient
import com.andygomez.newcrud.client.command.web.model.ClientInput
import com.andygomez.newcrud.client.command.web.model.ClientUpdateInput
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class UpdateClientAdapter(private val dsl: DSLContext) : UpdateClient {
    override fun updateClient(clientId: Long, updatedInfo: ClientUpdateInput): ClientModel {
        val existingClient = dsl.selectFrom(Client.CLIENT)
            .where(Client.CLIENT.ID.eq(clientId))
            .fetchOne()

        if (existingClient == null) {
            throw IllegalArgumentException("Cliente con ID $clientId no encontrado")
        }

        val updatedStatus = determineClientStatus(updatedInfo.payment_amount)

        val updateQuery = dsl.update(Client.CLIENT)
            .set(Client.CLIENT.NAME, updatedInfo.name)
            .set(Client.CLIENT.LAST_NAME, updatedInfo.last_name)
            .set(Client.CLIENT.EMAIL, updatedInfo.email)

        if (updatedInfo.payment_amount != null) {
            updateQuery.set(Client.CLIENT.PAYMENT_AMOUNT, updatedInfo.payment_amount)
        }

        updateQuery.set(Client.CLIENT.STATUS, updatedStatus.name)
            .where(Client.CLIENT.ID.eq(clientId))
            .execute()

        return ClientModel(
            clientId,
            updatedInfo.name,
            updatedInfo.last_name,
            updatedInfo.email,
            updatedInfo.payment_amount ?: 0 ,
            updatedStatus
        )
    }

    private fun determineClientStatus(paymentAmount: Int?): ClientStatus {
        if (paymentAmount == null) {
            throw IllegalArgumentException("paymentAmount no puede ser nulo")
        }

        return when {
            paymentAmount <= 10 -> ClientStatus.PaymentAtTime
            paymentAmount in 11..20 -> ClientStatus.LatePayment
            else -> ClientStatus.NotPayed
        }
    }
}