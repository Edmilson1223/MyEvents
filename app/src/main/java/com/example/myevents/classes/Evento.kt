package com.example.myevents.classes

class Evento(val id: Int = 0, var nome_evento: String = "", var data_hora: String = "", var local: String = "", var descricao: String = "", var id_promotor: Int = 0) {
    // funcao toString para apresentar os dados no Evento
    override fun toString(): String {
        return "Evento(id=$id, nome_evento='$nome_evento', data_hora='$data_hora', local='$local', descricao='$descricao', id_promotor=$id_promotor)"
    }
}