package com.example.contactlistroomdb.repository

import com.example.contactlistroomdb.db.ContactDao
import com.example.contactlistroomdb.db.ContactDatabase
import com.example.contactlistroomdb.model.Contact
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val db: ContactDatabase) {

    val readAllContacts: Flow<List<Contact>> = db.getContactDao().readAllContacts()

    suspend fun addContact(contact: Contact) {
        db.getContactDao().addContact(contact)

    }


}