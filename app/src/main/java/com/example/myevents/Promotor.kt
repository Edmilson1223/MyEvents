package com.example.myevents

class Promotor(val id: Int = 0, var nome_promotor: String = "", var cni: String = "", var nif: String = "", var email: String = "", var password: String = "", var nib: String = "") {
    // funcao toString para apresentar os dados no Promotor
    override fun toString(): String {
        return "Promotor(id=$id, nome_promotor='$nome_promotor', cni='$cni', nif='$nif', email='$email', password='$password', nib='$nib')"
    }
}