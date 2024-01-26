package com.example.myevents

class Bilhete(val id: Int = 0, var preco: Double = 0.0, var quantidade: Int = 0, var total: Double = 0.0, var id_evento: Int = 0, var id_cliente: Int = 0) {
    // funcao toString para apresentar os dados no Bilhete
    override fun toString(): String {
        return "Bilhete(id=$id, preco=$preco, quantidade=$quantidade, total=$total, id_evento=$id_evento, id_cliente=$id_cliente)"
    }
}