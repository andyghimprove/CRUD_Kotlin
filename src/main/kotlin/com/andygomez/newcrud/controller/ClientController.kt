package com.andygomez.newcrud.controller

import com.andygomez.newcrud.model.Client
import com.andygomez.newcrud.service.ClientService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/client")
class ClientController(private val service: ClientService) {

    @GetMapping
    fun getAllPersons(): List<Client> {
        return service.getAllClient()
    }

    @GetMapping("/findByName")
    fun findByName(@RequestParam name: String): List<Client> {
        return service.findClientByName(name)
    }

    @PostMapping
    fun createPerson(@RequestBody client: Client): Client {
        return service.createNewClient(client)
    }

    @PutMapping("/{id}")
    fun updatePerson(@PathVariable id: Int, @RequestBody client: Client): Client {
        return service.updateClient(id, client)
    }

}