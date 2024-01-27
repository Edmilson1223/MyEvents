package com.example.myevents.classes

class Cliente(val id: Int = 0, var nome_cliente: String = "", var username: String = "", var password: String = "") {
    // funcao toString para apresentar os dados no Cliente
    override fun toString(): String {
        return "Cliente(id=$id, nome_cliente='$nome_cliente', username='$username', password='$password')"
    }
}