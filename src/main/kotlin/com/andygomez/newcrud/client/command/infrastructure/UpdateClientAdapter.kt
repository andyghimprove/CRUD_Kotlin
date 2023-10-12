package com.andygomez.newcrud.client.command.infrastructure

import com.andygomez.newcrud.client.command.domain.ClientModel
import com.andygomez.newcrud.client.command.domain.ClientStatus
import com.andygomez.newcrud.client.command.domain.repository.UpdateClient
import com.andygomez.newcrud.client.command.web.model.ClientInput
import com.andygomez.newcrud.jooq.tables.Client
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class UpdateClientAdapter(private val dsl: DSLContext) : UpdateClient {

    override fun updateClient(id: Long, input: ClientInput): ClientModel {

        val exists = dsl.fetchExists(
            dsl.selectFrom(Client.CLIENT).where(Client.CLIENT.ID.eq(id))
        )
        if (exists){
            val updatedRecord = dsl.update(Client.CLIENT)
                .set(Client.CLIENT.NAME, input.name)
                .set(Client.CLIENT.LAST_NAME, input.last_name)
                .set(Client.CLIENT.EMAIL, input.email)
                .set(Client.CLIENT.PAYMENT_AMOUNT, input.payment_amount)
                .set(Client.CLIENT.STATUS, determineClientStatus(input.payment_amount).toString())
                .where(Client.CLIENT.ID.eq(id))
                .execute()
        }else{
            throw RuntimeException("Id: $id, client not found")
        }
        val updatedClient = dsl.selectFrom(Client.CLIENT)
            .where(Client.CLIENT.ID.eq(id))
            .fetchOneInto(ClientModel::class.java)

        return updatedClient ?: throw IllegalStateException("No se pudo recuperar el cliente actualizado")
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