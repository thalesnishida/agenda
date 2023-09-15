package br.com.thalesnishida.newagenda.dao

import br.com.thalesnishida.newagenda.module.Contact

class FormAgendaDao {

    fun add(contact: Contact){
        contacts.add(contact)
    }

    fun findAll() : List<Contact>{
        return contacts.toList()
    }

    companion object {
        private val contacts = mutableListOf<Contact>()
    }

}